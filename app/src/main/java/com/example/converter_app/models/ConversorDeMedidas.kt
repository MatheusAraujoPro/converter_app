package com.example.converter_app.models

class ConversorDeMedidas(private val conversor: ConversorDeMedidasStrategy) {

    fun converter(value: Double): Double{
        return conversor.converter(value)
    }

    fun getLabel(value: Double): String{
        return conversor.getLabel(value)
    }

}