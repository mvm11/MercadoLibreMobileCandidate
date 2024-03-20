package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.common

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mercadolibremobilecandidate.product.domain.error.DomainError

@Composable
fun ErrorScreen(configuration: Configuration, error: DomainError) {

    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Header()
        CustomSpacer(width = screenWidth, height = screenHeight * 0.01f)
        Text(text = error.getMessage(), textAlign = TextAlign.Center)
    }
}