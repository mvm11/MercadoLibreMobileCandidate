package com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.api

import com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.common.APIConstants.SEARCH_PRODUCT
import com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.common.APIConstants.SEARCH_PRODUCTS
import com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.response.SearchProductResponse
import com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.response.SearchProductsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MercadoLibreAPI {
    @GET(SEARCH_PRODUCTS)
    suspend fun searchProducts(
        @Query("q") query: String
    ): SearchProductsResponse

    @GET(SEARCH_PRODUCT)
    suspend fun searchProductById(
        @Path("productId") productId: String
    ): SearchProductResponse

}