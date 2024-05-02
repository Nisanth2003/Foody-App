package com.example.thefoodapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class LoginActivity : AppCompatActivity() {

    lateinit var  sharedPreferences: SharedPreferences
    lateinit var name: TextView
    lateinit var email: TextView
    val mypreference = "mypref"
    val Name = "nameKey"
    val Email = "emailKey"


    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginbutton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                val username = Intent(this,MainActivity::class.java)
                startActivity(username)

            } else {
                Toast.makeText(this, "Please enter Username and Password", Toast.LENGTH_SHORT).show()
            }
        }
        val url ="https://www.google.com"
        val implicitButton = findViewById<Button>(R.id.googleButton)

        implicitButton.setOnClickListener {
            val implicitButton = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(implicitButton)
        }

        val url1 = "https://www.facebook.com"
        val implicitButton1 = findViewById<Button>(R.id.facebookButton)

        implicitButton1.setOnClickListener {
            val implicitButton1 = Intent(Intent.ACTION_VIEW, Uri.parse(url1))
            startActivity(implicitButton1)
        }

        name = findViewById(R.id.username)
        email = findViewById(R.id.password)
        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE)
        name.text = sharedPreferences.getString(Name, "")
        email.text = sharedPreferences.getString(Email, "")
    }

    fun login(view : View?) {
        val n  = name.text.toString()
        val e = email.text.toString()
        val editor = sharedPreferences.edit()
        editor.putString(Name, n)
        editor.putString(Email, e)
        editor.apply()

    }
}