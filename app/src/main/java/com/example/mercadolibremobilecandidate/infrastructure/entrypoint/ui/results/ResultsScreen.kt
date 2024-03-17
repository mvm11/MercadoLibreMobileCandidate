package com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.results

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mercadolibremobilecandidate.domain.product.model.Product
import com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.search.SearchViewModel

@Composable
fun ResultsScreen(query: String, viewModel: SearchViewModel = SearchViewModel()) {
    // Llamar a searchProducts cuando cambie el valor de query
    LaunchedEffect(query) {
        viewModel.searchProducts(query, "tu_access_token")
    }

    val products by viewModel.products.collectAsState()

    LazyColumn {
        items(products) { product ->
            ProductItem(product)
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Row(modifier = Modifier.padding(8.dp)) {
        /*Image(
            painter = rememberImagePainter(product.thumbnail),
            contentDescription = product.title,
            modifier = Modifier.size(64.dp)
        )*/
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = product.title)
    }
}
