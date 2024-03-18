package com.example.mercadolibremobilecandidate.application.searchresult.usecase

import com.example.mercadolibremobilecandidate.domain.searchresult.model.SearchResult
import com.example.mercadolibremobilecandidate.domain.searchresult.repository.SearchResultRepository
import javax.inject.Inject

class SearchProductsUseCase @Inject constructor(private val repository: SearchResultRepository) {

    suspend operator fun invoke(query: String): SearchResult {
        return repository.searchProducts(query)
    }
}