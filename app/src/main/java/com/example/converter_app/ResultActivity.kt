package com.example.converter_app

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reuslt)

        val result = intent.getDoubleExtra("RESULT", 0.0)
        var label = intent.getStringExtra("LABEL")

        val buttonVoltar: Button = findViewById(R.id.button_voltar)

        val textResult: TextView = findViewById(R.id.text_result)
        textResult.text = result.toString()

        val textLabel: TextView = findViewById(R.id.text_medida)
        textLabel.text = label.toString()

        buttonVoltar.setOnClickListener {
            finish()
        }
    }
}