package com.example.mercadolibremobilecandidate.domain.searchresult.model

import com.example.mercadolibremobilecandidate.domain.product.model.Product

data class SearchResult(
    val results: List<Product>
)