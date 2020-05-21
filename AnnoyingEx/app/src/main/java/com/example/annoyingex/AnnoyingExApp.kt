package com.example.annoyingex

import android.app.Application
import com.example.annoyingex.activity.AEWorkerManager
import kotlin.random.Random

class AnnoyingExApp: Application() {
    lateinit var aeNotificationManager: AENotificationManager
    lateinit var aeWorkerManager: AEWorkerManager
    lateinit var messageFetch: MessageFetch
    lateinit var messages: List<String>

    override fun onCreate() {
        super.onCreate()
        messageFetch = MessageFetch(this)
        messageFetch.getMessages { messagesList ->
            this.messages = messagesList.messages
        }

        aeNotificationManager = AENotificationManager(this)
        aeWorkerManager = AEWorkerManager(this)
    }

    fun getRandomMessage(): String {
        if(messages[0] == MessageFetch.FAILED_REQUEST) {
            return "unable to retrieve message"
        } else {
            return messages[Random.nextInt(0, messages.size)]
        }
    }
}