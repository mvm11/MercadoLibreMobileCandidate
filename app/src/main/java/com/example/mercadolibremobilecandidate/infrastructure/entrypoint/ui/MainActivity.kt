package com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.navigation.AppNavigationGraph
import com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.theme.MercadoLibreMobileCandidateTheme

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
