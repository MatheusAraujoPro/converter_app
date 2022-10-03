package com.example.converter_app.models

import com.example.converter_app.models.strategies.CalculatorStrategy

// Singleton Object
object Calculator {

    private var calculationstrategy: CalculatorStrategy? = null

    //Set the strategy
    fun setCalculationStrategy(calculationstrategy: CalculatorStrategy){
        this.calculationstrategy = calculationstrategy
    }

    fun calculate(value: Double): Double{
        if(calculationstrategy == null)
            throw IllegalArgumentException("Calculation Strategy is not set")

        return calculationstrategy!!.calculate(value)
    }

}