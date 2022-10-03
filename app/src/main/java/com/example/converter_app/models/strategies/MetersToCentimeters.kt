package com.example.converter_app.models.strategies

class MetersToCentimeters: CalculatorStrategy {
    override fun calculate(value: Double): Double {
        return value * 100
    }

    override fun getResultLabel(isPlural: Boolean) = if(isPlural) "Centímetros" else "Centímetro"
}