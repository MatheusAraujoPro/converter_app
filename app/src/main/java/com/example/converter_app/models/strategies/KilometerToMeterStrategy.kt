package com.example.converter_app.models.strategies

class KilometerToMeterStrategy : CalculatorStrategy {
    override fun calculate(value: Double): Double {
        return value * 1_000
    }

    override fun getResultLabel(isPlural: Boolean) = if (isPlural) "Metros" else "Metro"

}