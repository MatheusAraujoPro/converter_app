package com.example.converter_app.models.strategies

interface CalculatorStrategy {
    fun calculate(value: Double): Double
    fun getResultLabel(isPlural: Boolean): String
}
