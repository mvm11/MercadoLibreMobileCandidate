package com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.results.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mercadolibremobilecandidate.product.app.usecase.SearchProductsUseCase
import com.example.mercadolibremobilecandidate.product.domain.model.DomainResult
import com.example.mercadolibremobilecandidate.product.infrastructure.entrypoint.ui.results.state.ResultsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(private val searchProductsUseCase: SearchProductsUseCase) :
    ViewModel() {

    private val _resultsState = MutableStateFlow(ResultsState())
    val resultsState: StateFlow<ResultsState> = _resultsState.asStateFlow()

    fun setQuery(newQuery: String) {
        if (newQuery.isNotEmpty() && newQuery != _resultsState.value.query) {
            _resultsState.value = _resultsState.value.copy(query = newQuery)
            searchProducts(newQuery)
        }
    }

    private fun searchProducts(query: String) {
        viewModelScope.launch {
            _resultsState.value = _resultsState.value.copy(isLoading = true)
            when (val result = searchProductsUseCase(query)) {
                is DomainResult.Success -> {
                    _resultsState.value = _resultsState.value.copy(
                        products = result.data,
                        isLoading = false
                    )
                }

                is DomainResult.Error -> {
                    _resultsState.value = _resultsState.value.copy(
                        error = result.error,
                        isLoading = false
                    )
                }
            }
        }
    }
}
