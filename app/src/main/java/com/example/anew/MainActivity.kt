package com.example.anew

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val btnClear: Button = findViewById(R.id.btnC)
        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnSub: Button = findViewById(R.id.btnSub)
        val btnDiv: Button = findViewById(R.id.btnDiv)
        val btnMulti: Button = findViewById(R.id.btnMulti)
        val btnEqu: Button = findViewById(R.id.btnEqu)

        numButtonClicked(findViewById(R.id.btn1), textView, "1")
        numButtonClicked(findViewById(R.id.btn2), textView, "2")
        numButtonClicked(findViewById(R.id.btn3), textView, "3")
        numButtonClicked(findViewById(R.id.btn4), textView, "4")
        numButtonClicked(findViewById(R.id.btn5), textView, "5")
        numButtonClicked(findViewById(R.id.btn6), textView, "6")
        numButtonClicked(findViewById(R.id.btn7), textView, "7")
        numButtonClicked(findViewById(R.id.btn8), textView, "8")
        numButtonClicked(findViewById(R.id.btn9), textView, "9")

        btnClear.setOnClickListener {
            clear(textView)
        }

        btnAdd.setOnClickListener {
            action("add")
        }

        btnSub.setOnClickListener {
            action("subtract")
        }

        btnMulti.setOnClickListener {
            action("multiple")
        }

        btnDiv.setOnClickListener {
            action("divide")
        }

        btnEqu.setOnClickListener {
            equals(textView)
        }
    }

//    var newNumber = ""
    var num1 = ""
    var num2 = ""
    var result = ""
    var action = ""

    fun numButtonClicked(button: Button, textView: TextView, number: String) {
        button.setOnClickListener {
            num1 += number
            textView.text = num1
        }
    }

    fun clear(textView: TextView) {
        num1 = ""
        textView.text = ""
    }

    fun action(operator: String) {
        num2 = num1
        num1 = ""
        action = operator
    }

    fun equals(textView: TextView) {
        if (num1.isNotEmpty() && num2.isNotEmpty()) {
            //num2 = newNumber

            when(action) {
                "add" -> result = (num2.toDouble() + num1.toDouble()).toString()
                "subtract" -> result = (num2.toDouble() - num1.toDouble()).toString()
                "divide" -> result = (num2.toDouble() / num1.toDouble()).toString()
                "multiple" -> result = (num2.toDouble() * num1.toDouble()).toString()
            }
            textView.text = result
        }
    }
}