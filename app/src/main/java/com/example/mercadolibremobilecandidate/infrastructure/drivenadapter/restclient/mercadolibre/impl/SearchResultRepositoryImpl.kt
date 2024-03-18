package com.example.mercadolibremobilecandidate.infrastructure.drivenadapter.restclient.mercadolibre.impl

import com.example.mercadolibremobilecandidate.domain.searchresult.model.SearchResult
import com.example.mercadolibremobilecandidate.domain.searchresult.repository.SearchResultRepository
import com.example.mercadolibremobilecandidate.infrastructure.drivenadapter.restclient.mercadolibre.MercadoLibreApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchResultRepositoryImpl @Inject
constructor(private val mercadoLibreApi: MercadoLibreApi) : SearchResultRepository {

    override suspend fun searchProducts(query: String): SearchResult {
        return mercadoLibreApi.searchProducts(query)
    }
}