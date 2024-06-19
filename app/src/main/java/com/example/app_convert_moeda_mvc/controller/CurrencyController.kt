package com.example.app_convert_moeda_mvc.controller

import android.util.Log
import android.widget.Toast
import com.example.app_convert_moeda_mvc.model.CurrencyRepository
import com.example.app_convert_moeda_mvc.view.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CurrencyController (private val activity: MainActivity) {
    private val repository: CurrencyRepository = CurrencyRepository()

    fun getCurrencies (realValue: Double, currencies: String){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = withContext(Dispatchers.IO){
                    repository.getCurrencies(currencies)
                }
                 result?.let{
                     val usdRate = it.usdBrl.bid.toDoubleOrNull() ?: 0.0
                     var eurRate = it.eurBrl.bid.toDoubleOrNull() ?: 0.0
                     activity.updateValues(realValue, usdRate, eurRate)
                 }  ?: run {
                    Log.e("CurrencyController", "Resposta vazia")
                    Toast.makeText(activity, "Falha ao obter resposta do servidor", Toast.LENGTH_SHORT).show()
                }
            }catch (e: Exception){
                Log.e("CurrencyController", "Erro ao buscar moedas: ${e.message}")
                Toast.makeText(activity, "Erro ao buscar moedas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}