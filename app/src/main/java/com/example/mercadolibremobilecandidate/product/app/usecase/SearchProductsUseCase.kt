package com.example.mercadolibremobilecandidate.product.app.usecase

import com.example.mercadolibremobilecandidate.product.domain.model.Product
import com.example.mercadolibremobilecandidate.product.domain.repository.ProductRepository
import javax.inject.Inject

class SearchProductsUseCase @Inject constructor(private val repository: ProductRepository) {

    suspend operator fun invoke(query: String): List<Product> {
        return repository.searchProducts(query)
    }
}