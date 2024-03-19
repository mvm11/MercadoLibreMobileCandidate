package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.search.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchTitle(configuration: Configuration) {

    val screenHeight = configuration.screenHeightDp.dp

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            SearchTitleLandscapeView(screenHeight)
        }
        else -> {
            SearchTitlePortraitView(screenHeight)
        }
    }
}

@Composable
fun SearchTitleLandscapeView(screenHeight: Dp) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight * 0.2f)
    ) {
        Text(
            text = "Buscar en\nMercado Libre",
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )
    }
}

@Composable
fun SearchTitlePortraitView(screenHeight: Dp) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(screenHeight * 0.1f)
    ) {
        Text(
            text = "Buscar en\nMercado Libre",
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )
    }
}

