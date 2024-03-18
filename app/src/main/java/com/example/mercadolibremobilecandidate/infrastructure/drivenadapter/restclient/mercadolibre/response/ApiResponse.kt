package com.example.mercadolibremobilecandidate.infrastructure.drivenadapter.restclient.mercadolibre.response

import com.example.mercadolibremobilecandidate.domain.product.model.Product

data class ApiResponse(
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