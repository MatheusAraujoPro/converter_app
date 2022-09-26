package com.example.converter_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.converter_app.models.Contantes

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, View.OnClickListener {
    private lateinit var spinner: Spinner
    private lateinit var edit: EditText
    private var calculate: Double = 0.0
    private lateinit var buttonConverter: Button
    private lateinit var buttonLimpar: Button
    private var positionSelected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner)
        edit = findViewById(R.id.editt_value)
        buttonConverter = findViewById(R.id.button_converter)
        buttonLimpar = findViewById(R.id.button_limpar)

        ArrayAdapter.createFromResource(
            this,
            // Array de opções
            R.array.option_to_converter,
            // Layout de Spinner Padrão disponível no Android
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // setando a visualização de dropDown
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // setando o adapter ao Spinner
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = this
        buttonConverter.setOnClickListener(this)
        buttonLimpar.setOnClickListener(this)


    }

    override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, p3: Long) {
        val item = adapter?.selectedItem as String
        positionSelected = position

        when (item) {

            Contantes.KM_PARA_METROS -> {
                //Chamar um método
                if (!edit.text.toString().isEmpty()) {
                    var inputValue = edit.text.toString()
                    calculate = inputValue.toDouble() * 1000
                }

            }

            Contantes.KM_POR_CENTIMETROS -> {
                //Chamar um método
                if (!edit.text.toString().isEmpty()) {
                    var inputValue = edit.text.toString()
                    calculate = inputValue.toDouble() * 100000
                }

            }

            Contantes.METROS_PARA_KM -> {
                if (!edit.text.toString().isEmpty()) {
                    var inputValue = edit.text.toString()
                    calculate = inputValue.toDouble() / 1000
                }
            }
        }
    }

    override fun onNothingSelected(adapter: AdapterView<*>?) {}

    override fun onClick(view: View) {
        if (view.id == R.id.button_converter) {

            if(edit.text.toString().isEmpty()){
                Toast.makeText(
                    this,
                    "Digite um valor válido!",
                    Toast.LENGTH_LONG
                ).show()
                return

            }

            if (positionSelected == 0) {
                Toast.makeText(
                    this,
                    "Selecione uma das opções de conversão!",
                    Toast.LENGTH_LONG
                ).show()
                return
            }


            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("calculo", calculate)
            startActivity(intent)

        } else {
            edit.setText("")
            spinner.setSelection(0)
        }
    }


}