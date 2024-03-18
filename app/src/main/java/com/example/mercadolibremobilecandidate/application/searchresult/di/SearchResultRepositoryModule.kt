package com.example.mercadolibremobilecandidate.application.searchresult.di

import com.example.mercadolibremobilecandidate.domain.searchresult.repository.SearchResultRepository
import com.example.mercadolibremobilecandidate.infrastructure.drivenadapter.restclient.mercadolibre.impl.SearchResultRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SearchResultRepositoryModule {

    @Binds
    abstract fun bindSearchResultRepository(impl: SearchResultRepositoryImpl): SearchResultRepository
}
