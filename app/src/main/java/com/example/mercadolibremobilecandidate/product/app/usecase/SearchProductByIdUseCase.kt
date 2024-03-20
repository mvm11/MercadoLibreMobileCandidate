package com.example.mercadolibremobilecandidate.product.app.usecase

import com.example.mercadolibremobilecandidate.product.domain.model.DomainResult
import com.example.mercadolibremobilecandidate.product.domain.model.Product
import com.example.mercadolibremobilecandidate.product.domain.repository.ProductRepository
import javax.inject.Inject

class SearchProductByIdUseCase @Inject constructor(private val repository: ProductRepository) {
    suspend operator fun invoke(id: String): DomainResult<Product> {
        return repository.searchProductById(id)
    }
}