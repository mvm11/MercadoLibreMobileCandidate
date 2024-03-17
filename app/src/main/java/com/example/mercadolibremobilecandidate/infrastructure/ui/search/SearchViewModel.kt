package com.example.mercadolibremobilecandidate.infrastructure.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel: ViewModel() {

    private val _query = MutableLiveData<String>()
    val query: LiveData<String> = _query

    fun setQuery(input: String) {
        _query.value = input
    }

}