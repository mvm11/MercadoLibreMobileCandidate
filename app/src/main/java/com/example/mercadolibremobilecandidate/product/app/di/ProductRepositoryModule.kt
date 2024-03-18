package com.example.mercadolibremobilecandidate.product.app.di

import com.example.mercadolibremobilecandidate.product.domain.repository.ProductRepository
import com.example.mercadolibremobilecandidate.product.infrastructure.drivenadapter.restclient.mercadolibre.impl.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
fun interface ProductRepositoryModule {

    @Binds
    fun bindSearchResultRepository(impl: ProductRepositoryImpl): ProductRepository
}
