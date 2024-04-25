package com.example.act10

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.os.Handler
import androidx.core.os.HandlerCompat.postDelayed
import com.example.act10.R.id

class SecondWindow : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_window)

        val backgroundView = findViewById<ImageView>(R.id.backgroundView)
        val animationScaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up_animation)
        val animationScaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down_animation)

        animationScaleUp.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                    backgroundView.startAnimation(animationScaleDown)
            }
            override fun onAnimationRepeat(animation: Animation?) {}
        })

        mediaPlayer = MediaPlayer.create(this, R.raw.sound1)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        backgroundView.startAnimation(animationScaleUp)

        val extras = intent.extras

        val firstName = extras?.getString("firstName")
        val lastName = extras?.getString("lastName")
        val course = extras?.getString("course")
        val year = extras?.getString("year")
        val email = extras?.getString("email")
        val phone = extras?.getString("phoneNumber")
        val address = extras?.getString("address")

        val displayFirstName = findViewById<TextView>(R.id.displayFirstName)
        val displayLastName = findViewById<TextView>(R.id.displayLastName)
        val displayCourse = findViewById<TextView>(R.id.displayCourse)
        val displayYear = findViewById<TextView>(R.id.displayYear)
        val displayPhone = findViewById<TextView>(R.id.displayPhone)
        val displayEmail = findViewById<TextView>(R.id.displayEmail)
        val displayAddress = findViewById<TextView>(R.id.displayAddress)
        // Find other TextViews as needed

        // Set the retrieved data to the TextViews
        displayFirstName.text = "First Name: $firstName"
        displayLastName.text = "Last Name: $lastName"
        displayCourse.text = "Course: $course"
        displayYear.text = "Year: $year"
        displayPhone.text = "Phone No.: $phone"
        displayEmail.text = "Email: $email"
        displayAddress.text = "Address: $address"
    }
    override fun onDestroy(){
        super.onDestroy()
        mediaPlayer.release()
    }

}