package com.example.mercadolibremobilecandidate.infrastructure.entrypoint.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercadolibremobilecandidate.domain.product.model.Product
import com.example.mercadolibremobilecandidate.infrastructure.drivenadapter.restclient.mercadolibre.MercadoLibreApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.mercadolibre.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val mercadoLibreApi: MercadoLibreApi = retrofit.create(MercadoLibreApi::class.java)

    fun searchProducts(query: String, accessToken: String) {
        viewModelScope.launch {
            try {
                val result = mercadoLibreApi.searchProducts(query, "Bearer $accessToken")
                _products.emit(result.results)
            } catch (e: Exception) {
                // Manejar el error
            }
        }
    }
}
