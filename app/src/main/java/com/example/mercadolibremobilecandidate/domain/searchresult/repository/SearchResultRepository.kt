package com.example.mercadolibremobilecandidate.domain.searchresult.repository

import com.example.mercadolibremobilecandidate.domain.searchresult.model.SearchResult

fun interface SearchResultRepository {
    suspend fun searchProducts(query: String): SearchResult

}