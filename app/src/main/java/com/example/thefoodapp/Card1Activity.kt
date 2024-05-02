package com.example.thefoodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Card1Activity : AppCompatActivity() {

    lateinit var back_arrow : ImageView
    lateinit var rateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card1)

        back_arrow = findViewById(R.id.imageView9)
        rateButton = findViewById(R.id.rateButton1)

        back_arrow.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

        rateButton.setOnClickListener {
            Toast.makeText(this,"Thank you for the feedback!", Toast.LENGTH_SHORT).show()
        }
    }
}