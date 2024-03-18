package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailsScreen(productName: String) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text(text = productName, modifier = Modifier.padding(16.dp))
    }
}
