package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.theme.MercadoLibreMobileCandidateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MercadoLibreMobileCandidateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MercadoLibreMobileCandidateTheme {
                MercadoLibreMobileCandidateApp()
            }
        }
    }
}
