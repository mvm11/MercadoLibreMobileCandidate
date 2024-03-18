package com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.api

import com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.response.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

fun interface MercadoLibreAPI {
    @GET("sites/MCO/search")
    suspend fun searchProducts(
        @Query("q") query: String
    ): ApiResponse
}