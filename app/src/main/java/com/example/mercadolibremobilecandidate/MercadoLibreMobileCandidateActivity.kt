package com.example.mercadolibremobilecandidate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.MercadoLibreMobileCandidateApp
import com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.theme.MercadoLibreMobileCandidateTheme
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
