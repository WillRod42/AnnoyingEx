package com.example.annoyingex

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class AnnoyingWorker(context: Context, workerParams: WorkerParameters): Worker(context, workerParams) {
    override fun doWork(): Result {
        return Result.success()
    }
}