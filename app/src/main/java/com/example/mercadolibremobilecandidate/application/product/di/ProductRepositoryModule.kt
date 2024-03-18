package com.example.mercadolibremobilecandidate.application.product.di

import com.example.mercadolibremobilecandidate.domain.product.repository.ProductRepository
import com.example.mercadolibremobilecandidate.infrastructure.drivenadapter.restclient.mercadolibre.impl.ProductRepositoryImpl
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
