package com.example.thefoodapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {


    private lateinit var sharedpreferences: SharedPreferences
    private var username: String? = null

    val SHARED_PREFS = "mySharedPref"
    val EMAIL_KEY = "email_key"

    private lateinit var tv : TextView
    private lateinit var tv2 : TextView
    private lateinit var backButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        username = sharedpreferences.getString(EMAIL_KEY,null)

        tv = findViewById(R.id.textView66)
        tv2 = findViewById(R.id.textView67)

        tv.text = username
        tv2.text = "$username@gmail.com"

        backButton = findViewById(R.id.profileButton6)

        backButton.setOnClickListener {
            val x = Intent(this,MainActivity::class.java)
            startActivity(x)
        }

    }
}