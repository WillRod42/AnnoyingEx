package com.example.annoyingex.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.annoyingex.MessageFetch
import com.example.annoyingex.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mFetch = MessageFetch(this)
        mFetch.getMessages(this) { messages ->
            Log.i("testtest", messages.toString())
        }
    }
}
