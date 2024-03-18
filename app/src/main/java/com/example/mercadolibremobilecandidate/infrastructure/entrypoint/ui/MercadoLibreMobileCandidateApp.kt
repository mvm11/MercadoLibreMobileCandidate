package com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.navigation.MercadoLibreMobileCandidateGraph

@Composable
fun MercadoLibreMobileCandidateApp() {

    val navController = rememberNavController()
    MercadoLibreMobileCandidateGraph(navController)

}