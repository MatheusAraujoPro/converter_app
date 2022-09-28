package com.example.converter_app

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    private lateinit var textResult: TextView
    private lateinit var textMeasure: TextView
    private lateinit var buttonVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reuslt)

        textResult = findViewById(R.id.text_result)
        textMeasure = findViewById(R.id.text_medida)
        buttonVoltar = findViewById(R.id.button_voltar)

        //Recebendo valor da intent
        val calculate = intent.getDoubleExtra("calculo", 1.0)

        textResult.text = calculate.toString()
        textMeasure.text = intent.getStringExtra("medida")

        buttonVoltar.setOnClickListener {
            finish()
        }
    }
}