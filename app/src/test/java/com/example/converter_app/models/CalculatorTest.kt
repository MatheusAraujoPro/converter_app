package com.example.converter_app.models

import com.example.converter_app.models.strategies.KilometerToMeterStrategy
import com.example.converter_app.models.strategies.KilometersToCentimeters
import com.example.converter_app.models.strategies.MeterToKilometerStrategy
import com.example.converter_app.models.strategies.MetersToCentimeters
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    private lateinit var calculator: Calculator

    @Before
    fun setup() {
        calculator = Calculator
    }

    @Test
    fun `when calculate kilometer to centimeters with success`() {
        calculator.setCalculationStrategy(KilometersToCentimeters())
        val result = calculator.calculate(CONSTANTS.DUMMY_PARAM_KILOMETER_TO_CENTIMETER)
        assertThat(result).isEqualTo(CONSTANTS.DUMMY_RESULT_KILOMETER_TO_CENTIMETER)
    }

    @Test
    fun `when calculate kilometer to meters with success`() {
        calculator.setCalculationStrategy(KilometerToMeterStrategy())
        val result = calculator.calculate(CONSTANTS.DUMMY_PARAM_KILOMETER_TO_METER)
        assertThat(result).isEqualTo(CONSTANTS.DUMMY_RESULT_KILOMETER_TO_METER)
    }

    @Test
    fun `when calculate meters to centimeters with success`() {
        calculator.setCalculationStrategy(MetersToCentimeters())
        val result = calculator.calculate(CONSTANTS.DUMMY_PARAM_METER_TO_CENTIMETER)
        assertThat(result).isEqualTo(CONSTANTS.DUMMY_RESULT_METER_TO_CENTIMETER)
    }

    @Test
    fun `when calculate meters to kilometers with success`() {
        calculator.setCalculationStrategy(MeterToKilometerStrategy())
        val result = calculator.calculate(CONSTANTS.DUMMY_PARAM_METER_TO_KILOMETER)
        assertThat(result).isEqualTo(CONSTANTS.DUMMY_RESULT_METER_TO_KILOMETER)
    }
}