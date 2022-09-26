package com.example.converter_app

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var buttonVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textView = findViewById(R.id.text_result)
        buttonVoltar = findViewById(R.id.button_voltar)

        //Recebendo valor da intent
        val calculate = intent.getDoubleExtra("calculo", 1.0)
        textView.text = calculate.toString()

        buttonVoltar.setOnClickListener {
            finish()
        }
    }
}