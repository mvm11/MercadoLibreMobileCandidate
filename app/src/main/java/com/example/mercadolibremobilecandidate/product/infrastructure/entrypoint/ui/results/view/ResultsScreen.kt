package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.results.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mercadolibremobilecandidate.product.domain.model.Product
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.common.CustomSpacer
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.common.ErrorScreen
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.common.Header
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.common.Loading
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.results.view.components.ProductCard
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.results.viewmodel.ResultsViewModel

@Composable
fun ResultsScreen(
    query: String, viewModel: ResultsViewModel = hiltViewModel(), navController: NavHostController
) {

    viewModel.setQuery(query)

    val configuration = LocalConfiguration.current
    val state = viewModel.resultsState.collectAsState().value

    when {
        state.isLoading -> {
            Loading()
        }
        state.error != null -> {
            ErrorScreen(configuration, state.error)
        }
        else -> {
            Results(configuration, state.products, navController)
        }
    }
}

@Composable
fun Results(
    configuration: Configuration, products: List<Product>, navController: NavHostController
) {

    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Header()
        CustomSpacer(width = screenWidth, height = screenHeight * 0.01f)
        LazyColumn {
            items(products) { product ->
                ProductItem(configuration, navController, product)
            }
        }
    }
}

@Composable
fun ProductItem(
    configuration: Configuration,
    navController: NavHostController,
    product: Product,
) {
    ProductCard(configuration, navController, product)
}
