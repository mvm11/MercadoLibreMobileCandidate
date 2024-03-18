package com.example.mercadolibremobilecandidate.application.searchresult

import com.example.mercadolibremobilecandidate.domain.searchresult.model.SearchResult
import com.example.mercadolibremobilecandidate.domain.searchresult.repository.SearchResultRepository
import com.example.mercadolibremobilecandidate.infrastructure.drivenadapter.restclient.mercadolibre.impl.SearchResultRepositoryImpl

class SearchProductsUseCase() {

    private val repository: SearchResultRepository = SearchResultRepositoryImpl()
    suspend operator fun invoke(query: String): SearchResult {
        return repository.searchProducts(query)
    }
}