package com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mercadolibremobilecandidate.application.searchresult.SearchProductsUseCase
import com.example.mercadolibremobilecandidate.infrastructure.drivenadapter.restclient.mercadolibre.MercadoLibreApi
import com.example.mercadolibremobilecandidate.infrastructure.drivenadapter.restclient.mercadolibre.impl.SearchResultRepositoryImpl
import com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.navigation.AppNavigationGraph
import com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.results.viewmodel.ResultsViewModel
import com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.theme.MercadoLibreMobileCandidateTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.mercadolibre.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val mercadoLibreApi: MercadoLibreApi = retrofit.create(MercadoLibreApi::class.java)
        val repository = SearchResultRepositoryImpl(mercadoLibreApi)
        val searchProductsUseCase = SearchProductsUseCase(repository)
        val viewModel = ResultsViewModel(searchProductsUseCase)

        setContent {
            MercadoLibreMobileCandidateTheme {
                AppNavigationGraph(viewModel)
            }
        }
    }
}
