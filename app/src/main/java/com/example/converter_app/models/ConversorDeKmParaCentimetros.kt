package com.example.converter_app.models

class ConversorDeKmParaCentimetros : ConversorDeMedidasStrategy {

    override fun converter(value: Double): Double {
        return value / 100000
    }

    override fun getLabel(value: Double): String {
        return if(value > 2) "Centímetros" else "Centímetro"
    }
}