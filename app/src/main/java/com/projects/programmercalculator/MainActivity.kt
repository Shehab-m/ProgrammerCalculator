package com.projects.programmercalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

//limit num for crashes
class MainActivity : AppCompatActivity() {
    private lateinit var btnConvert: Button
    private lateinit var btnClear: Button
    private lateinit var etBin: EditText
    private lateinit var etOct: EditText
    private lateinit var etDec: EditText
    private lateinit var etHex: EditText
    private lateinit var binOutput: String
    private lateinit var octOutput: String
    private lateinit var decOutput: String
    private lateinit var hexOutput: String
//    private lateinit var btnClearLog: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // supportActionBar!!.setBackgroundDrawable(ColorDrawable(getColor(R.))))
        initViews()

        btnConvert.setOnClickListener {
            convertNumbers()
        }

        btnClear.setOnClickListener {
            clearViewsInput()
        }

    }


    private fun convertNumbers() {
        //while ((this.currentFocus as EditText).text.toString().toLong() <= Long.MAX_VALUE) {
            when(this.currentFocus?.id) {
                etBin.id -> {
                    convertBinaryToAll()
                }
                etDec.id -> {
                    convertDecimalToAll()
                }
                etOct.id -> {
                    convertOctalToAll()
                }
                etHex.id -> {
                    convertHexToAll()
                }
                else -> Toast.makeText(this,"Enter number first", Toast.LENGTH_SHORT).show()
            }
     //   }
    }

    private fun convertHexToAll() {
        if (areAllInputsNotEmpty()) {
            val hexInput = etHex.text.toString()
            decOutput = hexInput.toLong(HEXADECIMAL_BASE).toString()
            binOutput = decOutput.toLong().toString(BINARY_BASE)
            octOutput = decOutput.toLong().toString(OCTAL_BASE)
            etDec.setText(decOutput)
            etBin.setText(binOutput)
            etOct.setText(octOutput)

        }
    }

    private fun convertOctalToAll() {
        if (areAllInputsNotEmpty()) {
            val octInput = etOct.text.toString()
            decOutput = octInput.toLong(OCTAL_BASE).toString()
            binOutput = decOutput.toLong().toString(BINARY_BASE)
            hexOutput = decOutput.toLong().toString(HEXADECIMAL_BASE)
            etDec.setText(decOutput)
            etBin.setText(binOutput)
            etHex.setText(hexOutput)

        }
    }

    private fun convertDecimalToAll() {
        if (areAllInputsNotEmpty()) {
            val decInput = etDec.text.toString()
            binOutput = decInput.toLong().toString(BINARY_BASE)
            octOutput = decInput.toLong().toString(OCTAL_BASE)
            hexOutput = decInput.toLong().toString(HEXADECIMAL_BASE)
            etBin.setText(binOutput)
            etOct.setText(octOutput)
            etHex.setText(hexOutput)
        }
    }


    private fun convertBinaryToAll() {
        if (areAllInputsNotEmpty()) {
            val binaryInput = etBin.text.toString()
            decOutput = binaryInput.toLong(BINARY_BASE).toString()
            octOutput = binaryInput.toLong(BINARY_BASE).toString(OCTAL_BASE)
            hexOutput = binaryInput.toLong(BINARY_BASE).toString(HEXADECIMAL_BASE)
            etDec.setText(decOutput)
            etOct.setText(octOutput)
            etHex.setText(hexOutput)
        }
    }

    private fun areAllInputsNotEmpty(): Boolean {
        return (etBin.text.isNotEmpty()
                || etOct.text.isNotEmpty()
                || etDec.text.isNotEmpty()
                || etHex.text.isNotEmpty())
    }


    private fun clearViewsInput() {
        etBin.setText("")
        etOct.setText("")
        etDec.setText("")
        etHex.setText("")
    }

    private fun initViews() {
        btnConvert = findViewById(R.id.btn_convert)
        btnClear = findViewById(R.id.btn_clear)
        etBin = findViewById(R.id.et_bin)
        etOct = findViewById(R.id.et_oct)
        etDec = findViewById(R.id.et_dec)
        etHex = findViewById(R.id.et_hex)
    }

    private companion object {
        const val BINARY_BASE = 2
        const val OCTAL_BASE = 8
        const val DECIMAL_BASE = 10
        const val HEXADECIMAL_BASE = 16
    }

}