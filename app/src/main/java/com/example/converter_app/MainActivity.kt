package com.example.converter_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.converter_app.models.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, View.OnClickListener {
    private lateinit var spinner: Spinner
    private lateinit var edit: EditText
    private lateinit var buttonConverter: Button
    private lateinit var buttonLimpar: Button

    private var positionSelected = 0
    private lateinit var conversorStrategy: ConversorDeMedidasStrategy


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
                conversorStrategy = ConversorDeKmParaMetros()
            }

            Contantes.KM_POR_CENTIMETROS -> {
                conversorStrategy = ConversorDeKmParaCentimetros()

            }

            Contantes.METROS_PARA_KM -> {
                conversorStrategy = ConversorDeMetrosParaKM()
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

            //Lógica da conversão
            val conversor = ConversorDeMedidas(conversorStrategy)
            val textValue = edit.text.toString()
            val result = conversor.converter(textValue.toDouble())
            val measure = conversor.getLabel(result)



            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("calculo", result)
            intent.putExtra("medida",  measure)
            startActivity(intent)

        } else {
            edit.setText("")
            spinner.setSelection(0)
        }
    }


}