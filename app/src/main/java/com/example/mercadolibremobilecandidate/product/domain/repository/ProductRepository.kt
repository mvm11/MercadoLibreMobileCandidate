package com.example.mercadolibremobilecandidate.product.domain.repository

import com.example.mercadolibremobilecandidate.product.domain.model.Product

fun interface ProductRepository {
    suspend fun searchProducts(query: String): List<Product>

}