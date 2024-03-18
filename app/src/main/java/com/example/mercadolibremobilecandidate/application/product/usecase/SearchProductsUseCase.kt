package com.example.mercadolibremobilecandidate.application.product.usecase

import com.example.mercadolibremobilecandidate.domain.product.model.Product
import com.example.mercadolibremobilecandidate.domain.product.repository.ProductRepository
import javax.inject.Inject

class SearchProductsUseCase @Inject constructor(private val repository: ProductRepository) {

    suspend operator fun invoke(query: String): List<Product> {
        return repository.searchProducts(query)
    }
}