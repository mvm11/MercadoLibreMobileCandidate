package com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.impl

import com.example.mercadolibremobilecandidate.product.domain.error.ErrorFactory
import com.example.mercadolibremobilecandidate.product.domain.model.Product
import com.example.mercadolibremobilecandidate.product.domain.repository.ProductRepository
import com.example.mercadolibremobilecandidate.product.domain.model.DomainResult
import com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.api.MercadoLibreAPI
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl @Inject constructor(
    private val mercadoLibreAPI: MercadoLibreAPI,
    private val errorFactory: ErrorFactory
) : ProductRepository {
    override suspend fun searchProducts(query: String): DomainResult<List<Product>> {
        return try {
            val response = mercadoLibreAPI.searchProducts(query)
            DomainResult.Success(response.results)
        } catch (exception: Exception) {
            DomainResult.Error(errorFactory.getError(exception))
        }
    }
}

