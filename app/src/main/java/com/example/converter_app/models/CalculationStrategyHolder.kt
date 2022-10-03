package com.example.converter_app.models

import com.example.converter_app.models.strategies.CalculatorStrategy

data class CalculationStrategyHolder(
     var name: String,
     var strategy: CalculatorStrategy
 )