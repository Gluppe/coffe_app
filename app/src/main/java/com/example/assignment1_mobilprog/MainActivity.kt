package com.example.assignment1_mobilprog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var quantityCounter: Double = 0.0
        val plusButton = findViewById<Button>(R.id.plusButton)
        val minusButton = findViewById<Button>(R.id.minusButton)
        val mutableQuantityTextView = findViewById<TextView>(R.id.mutableQuantityTextView)
        val orderSummaryBox = findViewById<TextView>(R.id.orderSummaryBox)
        val orderButton = findViewById<Button>(R.id.orderButton)
        val chocolateCheckbox = findViewById<CheckBox>(R.id.chocolateCheckbox)
        val creamCheckbox = findViewById<CheckBox>(R.id.creamCheckbox)

        /**
         * The order button takes the information from quantity and if chocolate and cream checkboxes
         * where checked or not. It uses this to calculate the price and personalize the message.
         */
        orderButton.setOnClickListener {
            var price: Double  = 4 * quantityCounter
            var chocolate = "No"
            var cream = "No"

            // Checks if if chocolate is checked.
            if(chocolateCheckbox.isChecked) {
                price += 1 * quantityCounter
                chocolate = "yes"
            }

            // Checks if if creaqm is checked.
            if(creamCheckbox.isChecked) {
                price += 0.5 * quantityCounter
                cream = "yes"
            }

            // Uses a get string with variables to create the right message.
            orderSummaryBox.text = getString(R.string.coffePrice, cream, chocolate, quantityCounter, price.toString());

        }

        /**
         * The plus button add 1 to quantity when pressed.
         */
        plusButton.setOnClickListener {
            quantityCounter ++
            mutableQuantityTextView.text = quantityCounter.toString()
        }

        /**
         * The minus button subtracts 1 from quantity when pressed.
         */
        minusButton.setOnClickListener {
            if(quantityCounter > 0) {
                quantityCounter --
                mutableQuantityTextView.text = quantityCounter.toString()
            }
        }
    }
}