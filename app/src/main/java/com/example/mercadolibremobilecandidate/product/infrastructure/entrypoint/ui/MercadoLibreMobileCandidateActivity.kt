package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.theme.MercadoLibreMobileCandidateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MercadoLibreMobileCandidateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MercadoLibreMobileCandidateTheme {
                MercadoLibreMobileCandidateApp()
            }
        }
    }
}
