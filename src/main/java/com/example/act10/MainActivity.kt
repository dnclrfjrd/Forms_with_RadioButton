package com.example.act10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*

class MainActivity : AppCompatActivity() {
    // Declare variables at the class level
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var courseEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the EditText and RadioGroup variables
        firstNameEditText = findViewById(R.id.fname)
        lastNameEditText = findViewById(R.id.lname)
        courseEditText = findViewById(R.id.course)
        emailEditText = findViewById(R.id.email)
        phoneNumberEditText = findViewById(R.id.phone)
        addressEditText = findViewById(R.id.address)
        radioGroup = findViewById(R.id.radio_group_id)

        val submitButton = findViewById<Button>(R.id.button)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            callActivity()
        }

        // Animation for the logo
        val logo = findViewById<ImageView>(R.id.logo)
        logo.animate().apply{
            duration = 7000
            rotationBy(3600f)
        }.start()

        // Set a listener for radio button changes
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            // Update UI based on which radio button is checked
            val checkedRadioButton = findViewById<RadioButton>(checkedId)
            // Do something with the checked radio button
        }
    }

    private fun callActivity() {
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
        val year = selectedRadioButton?.text.toString()

        // Get the input field values
        val firstName = firstNameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()
        val course = courseEditText.text.toString()
        val email = emailEditText.text.toString()
        val phoneNumber = phoneNumberEditText.text.toString()
        val address = addressEditText.text.toString()

        if(firstName.isEmpty() || lastName.isEmpty() || year.isEmpty() || course.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()){
            Toast.makeText(this, "Fill out all the fields", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, SecondWindow::class.java)

            // Bundle the data to pass to the next activity
            val bundle = Bundle()
            bundle.putString("firstName", firstName)
            bundle.putString("lastName", lastName)
            bundle.putString("year", year)
            bundle.putString("course", course)
            bundle.putString("email", email)
            bundle.putString("phoneNumber", phoneNumber)
            bundle.putString("address", address)

            intent.putExtras(bundle)

            // Start the next activity
            startActivity(intent)
        }

    }
}
