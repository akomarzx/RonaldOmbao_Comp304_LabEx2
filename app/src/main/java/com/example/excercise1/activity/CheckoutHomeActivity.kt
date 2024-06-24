package com.example.excercise1.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.excercise1.R
import com.google.android.material.textfield.TextInputEditText

class CheckoutHomeActivity : AppCompatActivity(){

    private lateinit var fullNameEditText: TextInputEditText
    private lateinit var cardNumberEditText: TextInputEditText
    private lateinit var expiryDate : TextInputEditText
    private lateinit var checkoutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_checkout_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val extras = intent.extras

        if (extras != null) {
            val itemToBuy = extras.getString("item")
            val textViewItem = findViewById<TextView>(R.id.textView_item_to_buy)
            textViewItem.text = getString(R.string.checking_out, itemToBuy)
        } else {
            Log.d("SecondActivity", "No extras found in intent")
        }

        fullNameEditText = findViewById(R.id.txtEdit_FullName)
        cardNumberEditText = findViewById(R.id.txtEdit_CardNumber)
        checkoutButton = findViewById(R.id.btn_checkout)
        expiryDate = findViewById(R.id.txtEdit_expiryDate)

        checkoutButton.setOnClickListener {
            validateAndProcessCheckout()
        }
    }

    private fun validateAndProcessCheckout() {
        val fullName = fullNameEditText.text.toString().trim()
        val cardNumber = cardNumberEditText.text.toString().trim()

        if (fullName.isEmpty()) {
            fullNameEditText.error = getString(R.string.full_name_is_required_message)
            return
        }

        if (cardNumber.isEmpty()) {
            cardNumberEditText.error = getString(R.string.card_number_is_required_message)
            return
        }

        if (!isValidCardNumber(cardNumber)) {
            cardNumberEditText.error = getString(R.string.invalid_card_number_message)
            return
        }

        if(expiryDate.text?.isEmpty() == true) {
            expiryDate.error = getString(R.string.expiry_cannot_be_blank_message)
            return
        }
        // If all validations pass, proceed with checkout logic
        performCheckout(fullName, cardNumber)
    }

    private fun isValidCardNumber(cardNumber: String): Boolean {
        // Basic validation for demonstration (you can implement more advanced checks)
        return cardNumber.length == 16 && cardNumber.matches(Regex("[0-9]+"))
    }

    private fun performCheckout(fullName: String, cardNumber: String) {
        val message = "Checkout for $fullName with card ending ${cardNumber.substring(cardNumber.length - 4)} is successful"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}