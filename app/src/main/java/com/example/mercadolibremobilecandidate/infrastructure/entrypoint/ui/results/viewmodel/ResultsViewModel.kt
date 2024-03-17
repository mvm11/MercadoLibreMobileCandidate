package com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.results.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercadolibremobilecandidate.domain.searchresult.model.SearchResult
import com.example.mercadolibremobilecandidate.infrastructure.drivenadapter.restclient.mercadolibre.MercadoLibreApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultsViewModel : ViewModel() {

    private val _query = MutableStateFlow("")

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _products = MutableStateFlow(SearchResult(emptyList()))
    val products: StateFlow<SearchResult> = _products.asStateFlow()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.mercadolibre.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val mercadoLibreApi: MercadoLibreApi = retrofit.create(MercadoLibreApi::class.java)

    fun setQuery(newQuery: String) {
        if (newQuery.isNotEmpty() && newQuery != _query.value) {
            _query.value = newQuery
            searchProducts(newQuery)
        }
    }

    private fun searchProducts(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val result = mercadoLibreApi.searchProducts(query)
                _products.value = result
            } catch (e: Exception) {
                // Handle the error
            } finally {
                _isLoading.value = false
            }
        }
    }
}
