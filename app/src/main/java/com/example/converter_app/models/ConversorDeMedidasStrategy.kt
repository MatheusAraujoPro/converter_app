package com.example.converter_app.models

interface ConversorDeMedidasStrategy {
    fun converter(value: Double): Double
    fun getLabel(value: Double): String
}
