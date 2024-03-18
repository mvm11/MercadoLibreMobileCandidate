package com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.detail.DetailsScreen
import com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.results.view.ResultsScreen
import com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.results.viewmodel.ResultsViewModel
import com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.search.SearchScreen

@Composable
fun AppNavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SEARCH) {
        composable(Routes.SEARCH) { SearchScreen(navController) }
        composable(
            "RESULT/{query}",
            arguments = listOf(navArgument("query") { type = NavType.StringType })
        ) { backStackEntry ->
            val query = backStackEntry.arguments?.getString("query") ?: ""
            val viewModel = ResultsViewModel()
            ResultsScreen(query, onQueryChanged = { viewModel.setQuery(it) }, viewModel = viewModel, navController = navController)
        }
        composable(
            "DETAILS/{productName}",
            arguments = listOf(navArgument("productName") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailsScreen(backStackEntry.arguments?.getString("productName") ?: "")
        }
    }
}
