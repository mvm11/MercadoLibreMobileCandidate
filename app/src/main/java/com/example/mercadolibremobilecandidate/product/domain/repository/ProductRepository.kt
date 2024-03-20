package com.example.mercadolibremobilecandidate.product.domain.repository

import com.example.mercadolibremobilecandidate.product.domain.model.DomainResult
import com.example.mercadolibremobilecandidate.product.domain.model.Product

interface ProductRepository {
    suspend fun searchProducts(query: String): DomainResult<List<Product>>
    suspend fun searchProductById(id: String): DomainResult<Product>

}