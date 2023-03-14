package com.projects.programmercalculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var editTextBinary: TextInputLayout
    private lateinit var editTextOctal: TextInputLayout
    private lateinit var editTextDecimal: TextInputLayout
    private lateinit var editTextHexadecimal: TextInputLayout
    private lateinit var outputBinary: String
    private lateinit var outputOctal: String
    private lateinit var outputDecimal: String
    private lateinit var outputHexadecimal: String
    private lateinit var buttonClear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        onTextChanged()
        buttonClear.setOnClickListener {
            clearEditTextInputs()
        }
    }

    private fun onTextChanged() {
        var base: Int

        editTextBinary.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                base = BINARY_BASE
                convertNumber(base, editTextBinary)
            }
        })

        editTextOctal.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                base = OCTAL_BASE
                convertNumber(base, editTextOctal)

            }
        })

        editTextDecimal.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                base = DECIMAL_BASE
                convertNumber(base, editTextDecimal)
            }
        })

        editTextHexadecimal.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                base = HEXADECIMAL_BASE
                convertNumber(base, editTextHexadecimal)
            }
        })
    }

    private fun convertNumber(base: Int, editText: TextInputLayout) {
        if (this@MainActivity.currentFocus?.id == editText.editText?.id
            && editText.editText?.text?.isNotEmpty() == true
        ) {
            updateEditTextInputValues(base, editText)
        }
        if (editText.editText?.text?.isEmpty() == true) {
            clearEditTextInputs()
        }
    }

    private fun updateEditTextInputValues(base: Int, editText: TextInputLayout) {
        val input = editText.editText?.text.toString()
        outputDecimal = input.toLong(base).toString()
        outputBinary = outputDecimal.toLong().toString(BINARY_BASE)
        outputOctal = outputDecimal.toLong().toString(OCTAL_BASE)
        outputHexadecimal = outputDecimal.toLong().toString(HEXADECIMAL_BASE)
        setEditTextViewsTexts(editText)
    }

    private fun setEditTextViewsTexts(editText: TextInputLayout) {
        when (editText.id) {
            editTextBinary.id -> {
                editTextDecimal.editText?.setText(outputDecimal)
                editTextOctal.editText?.setText(outputOctal)
                editTextHexadecimal.editText?.setText(outputHexadecimal)
            }
            editTextOctal.id -> {
                editTextDecimal.editText?.setText(outputDecimal)
                editTextBinary.editText?.setText(outputBinary)
                editTextHexadecimal.editText?.setText(outputHexadecimal)
            }
            editTextHexadecimal.id -> {
                editTextDecimal.editText?.setText(outputDecimal)
                editTextOctal.editText?.setText(outputOctal)
                editTextBinary.editText?.setText(outputBinary)
            }
            editTextDecimal.id -> {
                editTextBinary.editText?.setText(outputBinary)
                editTextOctal.editText?.setText(outputOctal)
                editTextHexadecimal.editText?.setText(outputHexadecimal)
            }
        }
    }

    private fun clearEditTextInputs() {
        editTextBinary.editText?.text?.clear()
        editTextOctal.editText?.text?.clear()
        editTextDecimal.editText?.text?.clear()
        editTextHexadecimal.editText?.text?.clear()
    }

    private fun initViews() {
        editTextBinary = findViewById(R.id.text_input_layout_binary)
        editTextOctal = findViewById(R.id.text_input_layout_octal)
        editTextDecimal = findViewById(R.id.text_input_layout_decimal)
        editTextHexadecimal = findViewById(R.id.text_input_layout_hexadecimal)
        buttonClear = findViewById(R.id.button_clear)
    }
}