package com.example.mercadolibremobilecandidate.infrastructure.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mercadolibremobilecandidate.infrastructure.ui.results.ResultsScreen
import com.example.mercadolibremobilecandidate.infrastructure.ui.search.SearchScreen

@Composable
fun AppNavigationGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = Routes.SEARCH) {

        composable(Routes.SEARCH) { SearchScreen(navController) }
        composable(Routes.RESULT) { ResultsScreen() }

    }
}