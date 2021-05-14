package com.main.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoCalcular.setOnClickListener { this.calcularGastoDeViagem(); }
    }


    private fun calcularGastoDeViagem() {
        if (this.validacaoEstiverOk()) {
            try {
                val distancia = inputDistancia.text.toString().toFloat();
                val preco = inputPreco.text.toString().toFloat();
                val autonomia = inputAutonomia.text.toString().toFloat();

                val custoTotalDaViagem = (distancia * preco) / autonomia;

                textMoney.text = "R$ ${"%.2f".format(custoTotalDaViagem)}";
            } catch (exception: NumberFormatException) {
                Toast.makeText(this, getString(R.string.valores_validos), Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, getString(R.string.preencha_todos_os_campos), Toast.LENGTH_LONG)
                .show();
        }
    }

    private fun validacaoEstiverOk(): Boolean = !(inputDistancia.text.isEmpty()
            || inputPreco.text.isEmpty()
            || inputAutonomia.text.isEmpty());

}