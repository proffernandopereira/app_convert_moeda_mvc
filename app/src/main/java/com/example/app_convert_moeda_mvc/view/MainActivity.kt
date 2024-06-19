package com.example.app_convert_moeda_mvc.view

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_convert_moeda_mvc.R
import com.example.app_convert_moeda_mvc.controller.CurrencyController
import com.example.app_convert_moeda_mvc.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var controller: CurrencyController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        controller = CurrencyController(this)
        binding.buttonConvert.setOnClickListener {
            val realValue = binding.editTextRealValue.text.toString().toDoubleOrNull()
            if(realValue != null){
                try {
                    controller.getCurrencies(realValue, "USD-BRL,EUR-BRL")
                } catch (e:Exception){
                    Log.e("MainActivity", "Erro ao buscar moedas: ${e.message}")
                    Toast.makeText(this, "Erro ao buscar moedas", Toast.LENGTH_SHORT).show()
                }
            }else {
                Log.e("MainActivity", "Valor de entrada inválido")
                Toast.makeText(this, "Por favor, insira um valor válido", Toast.LENGTH_SHORT).show()
            }
        }

    }
    fun updateValues(realValue: Double, usdValue: Double, eurValue: Double){
        binding.textViewUsdValue.text = String.format(Locale.getDefault(), "%.2f", realValue * usdValue)
        binding.textViewEurValue.text = String.format(Locale.getDefault(), "%.2f",  realValue * eurValue)
    }
}