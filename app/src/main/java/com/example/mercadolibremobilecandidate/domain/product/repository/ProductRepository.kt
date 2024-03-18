package com.example.mercadolibremobilecandidate.domain.product.repository

import com.example.mercadolibremobilecandidate.domain.product.model.Product

fun interface ProductRepository {
    suspend fun searchProducts(query: String): List<Product>

}