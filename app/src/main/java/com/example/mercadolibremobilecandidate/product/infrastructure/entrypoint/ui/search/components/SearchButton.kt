package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.search.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SearchButton(configuration: Configuration, query: String, onClick: () -> Unit) {

    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            SearchButtonLandscapeView(screenWidth, screenHeight, query, onClick)
        }

        else -> {
            SearchButtonPortraitView(screenWidth, screenHeight, query, onClick)
        }
    }
}

@Composable
fun SearchButtonLandscapeView(screenWidth: Dp,
                              screenHeight: Dp,
                              query: String,
                              onClick: () -> Unit) {

    Box(
        contentAlignment = Alignment.Center,
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .width(screenWidth * 0.4f)
                .height(screenHeight * 0.15f),
            enabled = query.isNotBlank(),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = "Buscar")
        }
    }
}

@Composable
fun SearchButtonPortraitView(screenWidth: Dp,
                             screenHeight: Dp,
                             query: String,
                             onClick: () -> Unit) {

    Box(
        contentAlignment = Alignment.Center,
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .width(screenWidth * 0.7f)
                .height(screenHeight * 0.07f),
            enabled = query.isNotBlank(),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = "Buscar")
        }
    }

}

