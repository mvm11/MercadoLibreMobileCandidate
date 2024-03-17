package com.example.mercadolibremobilecandidate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mercadolibremobilecandidate.infrastructure.ui.navigation.AppNavigationGraph
import com.example.mercadolibremobilecandidate.infrastructure.ui.theme.MercadoLibreMobileCandidateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MercadoLibreMobileCandidateTheme {
                AppNavigationGraph()
            }
        }
    }
}
