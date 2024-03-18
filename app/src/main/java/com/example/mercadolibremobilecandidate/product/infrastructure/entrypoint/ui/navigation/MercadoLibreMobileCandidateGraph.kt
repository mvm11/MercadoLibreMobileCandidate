package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.detail.DetailsScreen
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.results.view.ResultsScreen
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.results.viewmodel.ResultsViewModel
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.search.SearchScreen

@Composable
fun MercadoLibreMobileCandidateGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.SEARCH) {

        composable(Routes.SEARCH) { SearchScreen(navController) }

        composable(
            "RESULT/{query}",
            arguments = listOf(navArgument("query") { type = NavType.StringType })
        ) { backStackEntry ->
            val query = backStackEntry.arguments?.getString("query") ?: ""
            val viewModel = hiltViewModel<ResultsViewModel>()
            ResultsScreen(query,
                viewModel = viewModel,
                navController = navController)
        }
        composable(
            "DETAILS/{productName}",
            arguments = listOf(navArgument("productName") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailsScreen(backStackEntry.arguments?.getString("productName") ?: "")
        }
    }
}
