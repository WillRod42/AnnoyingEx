package com.example.annoyingex

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class AnnoyingWorker(private val context: Context, workerParams: WorkerParameters): Worker(context, workerParams) {
    override fun doWork(): Result {
        val app = context.applicationContext as AnnoyingExApp
        app.aeNotificationManager.makeNotification()
        return Result.success()
    }
}