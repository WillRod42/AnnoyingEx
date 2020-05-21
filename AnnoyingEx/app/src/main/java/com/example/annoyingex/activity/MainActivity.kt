package com.example.annoyingex.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.annoyingex.AENotificationManager
import com.example.annoyingex.MessageFetch
import com.example.annoyingex.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var notificationManager: AENotificationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mFetch = MessageFetch(this)
        mFetch.getMessages { messages ->
            Log.i("testtest", messages.toString())
        }

        notificationManager = AENotificationManager(this)
        button.setOnClickListener {
            notificationManager.makeNotification()
        }
    }


}
