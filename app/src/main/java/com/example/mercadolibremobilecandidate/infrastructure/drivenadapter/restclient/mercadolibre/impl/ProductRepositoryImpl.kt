package com.example.mercadolibremobilecandidate.infrastructure.drivenadapter.restclient.mercadolibre.impl

import com.example.mercadolibremobilecandidate.domain.product.model.Product
import com.example.mercadolibremobilecandidate.domain.product.repository.ProductRepository
import com.example.mercadolibremobilecandidate.infrastructure.drivenadapter.restclient.mercadolibre.MercadoLibreApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl @Inject
constructor(private val mercadoLibreApi: MercadoLibreApi) : ProductRepository {

    override suspend fun searchProducts(query: String): List<Product> {
        return mercadoLibreApi.searchProducts(query).results
    }
}