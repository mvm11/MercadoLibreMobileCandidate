package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.results.state

import com.example.mercadolibremobilecandidate.product.domain.error.DomainError
import com.example.mercadolibremobilecandidate.product.domain.model.Product

data class ResultsState(
    val query: String = "",
    val isLoading:Boolean = false,
    val products: List<Product> = emptyList(),
    val error: DomainError? = (null)
)