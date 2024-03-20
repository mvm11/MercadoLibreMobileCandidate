package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.results.view.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.mercadolibremobilecandidate.product.domain.model.Product
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.common.CustomSpacer


@Composable
fun ProductCard(configuration: Configuration, navController: NavHostController, product: Product) {

    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp


    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .width(screenWidth)
            .height(screenHeight * 0.15f),
        shape = RoundedCornerShape(15.dp)) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .clickable { navController.navigate("DETAILS/${product.id}") },
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProductCardThumbnail(product)
            CustomSpacer(width = screenWidth * 0.02f, height = screenHeight)
            ProductCardDescription(product)
        }
    }
}


@Composable
fun ProductCardThumbnail(product: Product) {
    AsyncImage(
        model = product.thumbnail,
        contentDescription = "Product Thumbnail",
        modifier = Modifier
            .fillMaxHeight()
            .width(100.dp)
            .clip(RoundedCornerShape(15.dp))
    )
}

@Composable
fun ProductCardDescription(product: Product) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(text = product.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = product.price.toString(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)
    }
}