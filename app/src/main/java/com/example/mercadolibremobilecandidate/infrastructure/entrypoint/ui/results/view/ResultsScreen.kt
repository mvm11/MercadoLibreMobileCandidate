package com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.results.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mercadolibremobilecandidate.domain.product.model.Product
import com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.results.viewmodel.ResultsViewModel

@Composable
fun ResultsScreen(query: String, onQueryChanged: (String) -> Unit, viewModel: ResultsViewModel, navController: NavHostController) {
    onQueryChanged(query)

    val products = viewModel.products.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value

    if (isLoading) {
        Text(text = "Cargando...")
    } else {
        LazyColumn {
            items(products.results) { product ->
                ProductItem(product, navController)
            }
        }
    }
}

@Composable
fun ProductItem(product: Product, navController: NavHostController) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .clickable { navController.navigate("DETAILS/${product.title}") }
    ) {
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = product.title)
    }
}
