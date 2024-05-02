package com.example.thefoodapp

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var detail1 : CardView
    lateinit var detail2 : CardView
    lateinit var detail3 : CardView
    lateinit var navBar : BottomNavigationView
    lateinit var textView : TextView

    private lateinit var builder: Notification.Builder
    private lateinit var notificationChannel : NotificationChannel
    private lateinit var notificationManager : NotificationManager
    private lateinit var pendingIntent: PendingIntent
    private val notificationId = 103



    private lateinit var sharedpreferences: SharedPreferences
    private var username: String? = null

    val SHARED_PREFS = "mySharedPref"
    val EMAIL_KEY = "email_key"
    val PASSWORD_KEY = "password_key"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        username = sharedpreferences.getString(EMAIL_KEY,null)

        textView = findViewById(R.id.textView3)
        textView.text = username

        detail1 = findViewById(R.id.card1)
        detail2 = findViewById(R.id.card2)
        detail3 = findViewById(R.id.card3)

        detail1.setOnClickListener {

            val i = Intent(this,Card1Activity::class.java)
            startActivity(i)
        }



        navBar = findViewById(R.id.bottomNavigationView)
        navBar.setOnItemSelectedListener{
            when(it.itemId)
            {
                R.id.cart -> {
                    val j = Intent(this,CartActivity::class.java)
                    startActivity(j)
                    true
                }
                R.id.profile -> {
                    val k = Intent(this,ProfileActivity::class.java)
                    startActivity(k)
                    true
                }

                else -> {true}
            }
        }

        val shopNowButton = findViewById<Button>(R.id.button)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        shopNowButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            pendingIntent = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_IMMUTABLE)

            createNotificationChannel()
            notificationManager.notify(notificationId,builder.build())


        }
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            val name = "Notification title 2"
            val descriptionText = "Notification description 2"
            notificationChannel = NotificationChannel(name,descriptionText, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this,name)
                .setSmallIcon(R.drawable.bell)
                .setContentTitle("Sale Notification")
                .setContentText("Order at Flat 30% discount!!")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        }

        else
        {
            builder = Notification.Builder(this)
                .setSmallIcon(R.drawable.bell)
                .setContentTitle("Sale Notification")
                .setContentText("Order at Flat 30% discount!!")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        }
    }
}