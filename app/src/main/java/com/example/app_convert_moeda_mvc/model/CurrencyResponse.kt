package com.example.app_convert_moeda_mvc.model

import com.google.gson.annotations.SerializedName

class CurrencyResponse (
    @SerializedName("USDBRL") val usdBrl: CurrencyInfo,
    @SerializedName("EURBRL") val eurBrl: CurrencyInfo
)

data class  CurrencyInfo(
    val code: String,
    val codein: String,
    val name: String,
    val high: String,
    val low: String,
    val varBid: String,
    val pctChange: String,
    val bid: String,
    val ask: String,
    val timestamp: String,
    val create_date: String
)
