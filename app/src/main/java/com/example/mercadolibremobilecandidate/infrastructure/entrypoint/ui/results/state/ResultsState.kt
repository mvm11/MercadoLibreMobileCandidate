package com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.results.state

import com.example.mercadolibremobilecandidate.domain.product.model.Product

data class ResultsState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val query: String = ""
)