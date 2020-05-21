package com.example.annoyingex.activity

import android.content.Context
import android.util.Log
import androidx.work.*
import com.example.annoyingex.AnnoyingWorker
import java.util.concurrent.TimeUnit

class AEWorkerManager(private val context: Context) {
    private var workManager = WorkManager.getInstance(context)

    companion object {
        const val AE_WORK_REQUEST_TAG = "AE_TAG"
    }

    fun startExTexts() {
        if(!isAnnoyingRunning()) {
            Log.i("workerbug", "TEST")
            val constraints = Constraints.Builder()
                .setRequiresCharging(true)
                .build()

            val workRequest = PeriodicWorkRequestBuilder<AnnoyingWorker>(20, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .setInitialDelay(5, TimeUnit.SECONDS)
                .addTag(AE_WORK_REQUEST_TAG)
                .build()

            workManager.enqueue(workRequest)
        }
    }

    fun stopExTexts() {
        workManager.cancelAllWorkByTag(AE_WORK_REQUEST_TAG)
    }

    private fun isAnnoyingRunning(): Boolean {
        val state = workManager.getWorkInfosByTag(AE_WORK_REQUEST_TAG).get().firstOrNull()?.state
        return (state == WorkInfo.State.ENQUEUED || state == WorkInfo.State.RUNNING)
    }
}