package com.example.app_convert_moeda_mvc.model

import com.example.app_convert_moeda_mvc.network.CurrencyApiService
import com.example.app_convert_moeda_mvc.network.RetrofitInstance

class CurrencyRepository {
    private val apiService: CurrencyApiService = RetrofitInstance.api
    suspend fun getCurrencies(currencies: String) = apiService.getCurrencies(currencies)

}