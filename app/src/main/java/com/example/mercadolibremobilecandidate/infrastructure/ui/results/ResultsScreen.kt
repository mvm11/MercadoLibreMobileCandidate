package com.example.mercadolibremobilecandidate.infrastructure.ui.results

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mercadolibremobilecandidate.infrastructure.ui.navigation.Routes

@Composable
fun ResultsScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
            text = Routes.RESULT)

    }
}