package com.example.converter_app.models

class ConversorDeKmParaMetros : ConversorDeMedidasStrategy {

    override fun converter(value: Double): Double {
        return value * 1000
    }

    override fun getLabel(value: Double): String {
        return if(value > 2) "Metros" else "Metro"
    }
}