package com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.response

import com.example.mercadolibremobilecandidate.product.domain.model.Product

data class SearchProductsResponse(
    val siteId: String,
    val query: String,
    val paging: Paging,
    val results: List<Product>
)

data class Paging(
    val total: Int,
    val offset: Int,
    val limit: Int,
    val primaryResults: Int
)