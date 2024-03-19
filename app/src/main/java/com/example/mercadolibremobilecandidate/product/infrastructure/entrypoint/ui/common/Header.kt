package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mercadolibremobilecandidate.R

@Composable
fun Header() {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val headerHeight = screenHeight * 0.10f

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(headerHeight)
            .background(Color(0xFFFFE600))
    ){
        GetHeaderImage(Modifier.align(Alignment.Center))
    }
}

@Composable
fun GetHeaderImage(modifier: Modifier) {
    Image(
        painterResource(id = R.drawable.logo),
        contentDescription = "Logo",
        modifier = modifier
    )
}