package com.example.mercadolibremobilecandidate.infrastructure.drivenadapter.restclient.mercadolibre.impl

import com.example.mercadolibremobilecandidate.domain.searchresult.model.SearchResult
import com.example.mercadolibremobilecandidate.domain.searchresult.repository.SearchResultRepository
import com.example.mercadolibremobilecandidate.infrastructure.drivenadapter.restclient.mercadolibre.MercadoLibreApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchResultRepositoryImpl() : SearchResultRepository {


    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.mercadolibre.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val mercadoLibreApi: MercadoLibreApi = retrofit.create(MercadoLibreApi::class.java)
    override suspend fun searchProducts(query: String): SearchResult {
        return mercadoLibreApi.searchProducts(query)
    }
}