package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.detail.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.mercadolibremobilecandidate.product.domain.model.Product
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.common.CustomSpacer
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.common.ErrorScreen
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.common.Header
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.common.Loading
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.detail.viewmodel.DetailsViewModel

@Composable
fun DetailsScreen(productId: String, viewModel: DetailsViewModel = hiltViewModel()) {

    viewModel.setId(productId)

    val configuration = LocalConfiguration.current

    val product = viewModel.product.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value
    val error = viewModel.error.collectAsState().value

    when {
        isLoading -> {
            Loading()
        }

        error != null -> {
            ErrorScreen(configuration, error)
        }

        else -> {
            ValidateOrientation(configuration, product)
        }
    }
}

@Composable
fun ValidateOrientation(
    configuration: Configuration, product: Product?
) {

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            DetailsScreenLandscapeView(configuration, product)
        }

        else -> {
            DetailsScreenLandscapeView(configuration, product)
        }
    }

}


@Composable
fun DetailsScreenLandscapeView(
    configuration: Configuration, product: Product?
) {

    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    Column {
        Header()
        Column(Modifier.padding(screenWidth * 0.05f)) {
            product?.title?.let { DetailsTitle(configuration, it) }
            product?.pictures?.let { ImageCarousel(configuration, it) }
            CustomSpacer(width = screenWidth, height = screenHeight * 0.01f)
            product?.price?.let { DetailsPrice(it.toString()) }
            CustomSpacer(width = screenWidth, height = screenHeight * 0.01f)
            product?.freeShipping?.let { DetailsFreeShipping(it) }
            CustomSpacer(width = screenWidth, height = screenHeight * 0.01f)
            product?.acceptsMercadoPago?.let { DetailsAcceptsMercadoPago(it) }
        }
    }


}

@Composable
fun DetailsTitle(configuration: Configuration, title: String) {

    val screenHeight = configuration.screenHeightDp.dp

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight * 0.2f)
    ) {
        Text(
            text = title, textAlign = TextAlign.Start, fontSize = 24.sp
        )
    }
}

@Composable
fun ImageCarousel(configuration: Configuration, urls: List<String>) {

    val screenHeight = configuration.screenHeightDp.dp

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight * 0.4f)
    ) {
        items(urls) { url ->
            AsyncImage(
                model = url,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillHeight
            )
        }
    }
}

@Composable
fun DetailsPrice(price: String) {

    Text(
        text = "$ $price",
        textAlign = TextAlign.Start,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun DetailsFreeShipping(freeShipping: Boolean) {

    if (freeShipping) {
        Text(
            text = "Envío gratis",
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            color = Color.Green
        )
    }
}

@Composable
fun DetailsAcceptsMercadoPago(acceptsMercadoPago: Boolean) {

    if(acceptsMercadoPago) {

        Text(
            text = "Acepta Mercado Pago",
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            color = Color.Blue
        )
    }
}

