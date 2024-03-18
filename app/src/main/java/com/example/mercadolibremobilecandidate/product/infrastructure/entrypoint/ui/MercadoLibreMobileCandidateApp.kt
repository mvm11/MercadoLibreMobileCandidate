package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.navigation.MercadoLibreMobileCandidateGraph

@Composable
fun MercadoLibreMobileCandidateApp() {

    val navController = rememberNavController()
    MercadoLibreMobileCandidateGraph(navController)

}