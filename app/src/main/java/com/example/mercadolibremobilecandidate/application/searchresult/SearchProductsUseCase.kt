package com.example.mercadolibremobilecandidate.application.searchresult

import com.example.mercadolibremobilecandidate.domain.searchresult.model.SearchResult
import com.example.mercadolibremobilecandidate.domain.searchresult.repository.SearchResultRepository

class SearchProductsUseCase(private val repository: SearchResultRepository) {
    suspend operator fun invoke(query: String): SearchResult {
        return repository.searchProducts(query)
    }
}