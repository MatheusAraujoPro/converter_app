package com.example.converter_app

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.converter_app.models.CalculationStrategyHolder
import com.example.converter_app.models.Calculator
import com.example.converter_app.models.strategies.KilometerToMeterStrategy
import com.example.converter_app.models.strategies.KilometersToCentimeters
import com.example.converter_app.models.strategies.MeterToKilometerStrategy
import com.example.converter_app.models.strategies.MetersToCentimeters

class MainActivity : AppCompatActivity() {

    private lateinit var spConversios: Spinner
    private lateinit var editValue: EditText

    private val supportedCalculationStrategies = arrayOf(
        CalculationStrategyHolder("Quilômetros para centímetros", KilometersToCentimeters()),
        CalculationStrategyHolder("Quilômetros para metros", KilometerToMeterStrategy()),
        CalculationStrategyHolder("Metros para centímetros", MetersToCentimeters()),
        CalculationStrategyHolder("Metros para Quilômetros", MeterToKilometerStrategy())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var value = 0.0
        var position = 0

        savedInstanceState?.let {
            value = it.getDouble("VALUE")
            position = it.getInt("POSITION")
        }

        initUI()

        setUI(value, position)

        setActions()



    }

    override fun onSaveInstanceState(outState: Bundle) {
        try {
            outState.putDouble("VALUE", editValue.text.toString().toDouble())
        } catch (e: java.lang.NumberFormatException) {
            editValue.error = "Valor inválido"
        }
        outState.putInt("POSITION", spConversios.selectedItemPosition)


        super.onSaveInstanceState(outState)

    }


    private fun initUI() {
        spConversios = findViewById(R.id.spinner)
        editValue = findViewById(R.id.editt_value)
    }

    private fun setActions() {
        val btnConvert: Button = findViewById(R.id.button_converter)
        val btnLimpar: Button = findViewById(R.id.button_limpar)

        btnConvert.setOnClickListener {

            try {
                //Getting values
                val value = editValue.text.toString().toDouble()
                val selectedItemPosition = spConversios.selectedItemPosition
                val calculationStrategy =
                    supportedCalculationStrategies[selectedItemPosition].strategy


                //Setting and using the strategy
                Calculator.setCalculationStrategy(calculationStrategy)
                val calculateResult = Calculator.calculate(value)
                val label = calculationStrategy.getResultLabel(calculateResult != 1.toDouble())

                //Sending intent with display values
                showResult(calculateResult, label)


            } catch (error: java.lang.NumberFormatException) {
                editValue.error = "Valor inválido"
                editValue.requestFocus()
            }

        }

        btnLimpar.setOnClickListener {
            editValue.setText("")
            editValue.error = ""
            spConversios.setSelection(0)
        }


    }

    private fun showResult(calculateResult: Double, label: String) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("RESULT", calculateResult)
        intent.putExtra("LABEL", label)
        startActivity(intent)

    }


    private fun setUI(value: Double, position: Int) {

        val spAdapter = ArrayAdapter(this, R.layout.res_spinner_item, getSpinnerData())
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spConversios.adapter = spAdapter

        spConversios.setSelection(position)
        editValue.setText(value.toString())

    }

    fun getSpinnerData(): MutableList<String> {
        val spinnerData = mutableListOf<String>()
        supportedCalculationStrategies.forEach { strategyHolder ->
            spinnerData.add(
                strategyHolder.name
            )
        }
        return spinnerData
    }


}