package com.example.annoyingex.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.annoyingex.AENotificationManager
import com.example.annoyingex.AnnoyingExApp
import com.example.annoyingex.MessageFetch
import com.example.annoyingex.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var annoyingExApp: AnnoyingExApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        annoyingExApp = applicationContext as AnnoyingExApp

        button.setOnClickListener {
            Toast.makeText(this,"Texts Incoming", Toast.LENGTH_SHORT).show()
            annoyingExApp.aeWorkerManager.startExTexts()
        }

        button2.setOnClickListener {
            Toast.makeText(this,"Texts stopped", Toast.LENGTH_SHORT).show()
            annoyingExApp.aeWorkerManager.stopExTexts()
        }
    }


}
