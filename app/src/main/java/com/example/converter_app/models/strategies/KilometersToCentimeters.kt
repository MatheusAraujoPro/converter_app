package com.example.converter_app.models.strategies

class KilometersToCentimeters : CalculatorStrategy {
    override fun calculate(value: Double): Double {
        return value / 100_000
    }

    override fun getResultLabel(isPlural: Boolean) = if (isPlural) "Centímetros" else "Centímetro"

}