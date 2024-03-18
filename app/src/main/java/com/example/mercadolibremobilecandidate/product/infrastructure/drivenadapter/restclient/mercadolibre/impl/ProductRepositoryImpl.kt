package com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.impl

import com.example.mercadolibremobilecandidate.product.domain.model.Product
import com.example.mercadolibremobilecandidate.product.domain.repository.ProductRepository
import com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.api.MercadoLibreAPI
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl @Inject
constructor(private val mercadoLibreApi: MercadoLibreAPI) : ProductRepository {

    override suspend fun searchProducts(query: String): List<Product> {
        return mercadoLibreApi.searchProducts(query).results
    }
}