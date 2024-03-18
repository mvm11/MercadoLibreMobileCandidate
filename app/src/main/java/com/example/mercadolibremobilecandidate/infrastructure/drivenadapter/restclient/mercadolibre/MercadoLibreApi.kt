package com.example.mercadolibremobilecandidate.infrastructure.drivenadapter.restclient.mercadolibre

import com.example.mercadolibremobilecandidate.infrastructure.drivenadapter.restclient.mercadolibre.response.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

fun interface MercadoLibreApi {
    @GET("sites/MCO/search")
    suspend fun searchProducts(
        @Query("q") query: String
    ): ApiResponse
}