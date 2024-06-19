package com.example.app_convert_moeda_mvc.network

import com.example.app_convert_moeda_mvc.model.CurrencyResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyApiService {
    @GET("json/last/{currencies}")
    suspend fun getCurrencies(@Path("currencies")currencies: String?): CurrencyResponse
}