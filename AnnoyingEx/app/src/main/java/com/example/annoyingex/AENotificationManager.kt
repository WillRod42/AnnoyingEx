package com.example.annoyingex

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.annoyingex.activity.MainActivity
import kotlin.random.Random

class AENotificationManager(private val context: Context) {
    private val notificationManagerCompat = NotificationManagerCompat.from(context)
    private val app = context.applicationContext as AnnoyingExApp

    companion object {
        const val CHANNEL_ID = "AECHANNEL"
    }

    init {
        createChannel()
    }

    fun makeNotification() {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(context, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT)

        val message = app.getRandomMessage()
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle("Ex")
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_directions_run_black_24dp)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        notificationManagerCompat.notify(Random.nextInt(), notification)
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "AE Notifications"
            val descriptionText = "Notifications from your fictional ex"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            notificationManagerCompat.createNotificationChannel(channel)
        }
    }
}