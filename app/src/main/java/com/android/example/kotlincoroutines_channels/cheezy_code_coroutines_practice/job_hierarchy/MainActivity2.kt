package com.android.example.kotlincoroutines_channels.cheezy_code_coroutines_practice.job_hierarchy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.android.example.kotlincoroutines_channels.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class MainActivity2 : ComponentActivity() {
    private val TAG = "KOTLIN_COROUTINES"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        GlobalScope.launch(Dispatchers.Main) {
            execute3()
        }
    }

    private fun execute() {
        val parentJob = GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Parent - $coroutineContext")

            val childJob = launch(Dispatchers.IO) {
                Log.d(TAG, "Child - $coroutineContext")
            }
        }
    }

    private suspend fun execute2() {
        val parentJob = GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Parent started")

            val childJob = launch(Dispatchers.IO) {
                try {
                    Log.d(TAG, "Child started")

                    delay(5000)
                    Log.d(TAG, "Child ended")
                } catch (cancellationException: CancellationException) {
                    Log.d(TAG, "Child job cancelled")
                }
            }
            delay(3000)
//            Log.d(TAG, "Child job cancelled")
            childJob.cancel()
            Log.d(TAG, "Parent ended")
        }
//        delay(1000)
//        parentJob.cancel()
        parentJob.join()
        Log.d(TAG, "Parent completed")
    }

    private suspend fun execute3() {
        val parentJob = CoroutineScope(Dispatchers.IO).launch {
            for (i in 1..1000) {
                if (isActive) {
                    executeLongRunningTask()
                    Log.d(TAG, i.toString())
                }
            }
        }
        delay(100)
        Log.d(TAG, "Cancelling job")
        parentJob.cancel()
        parentJob.join()
        Log.d(TAG, "Parent completed")
    }

    private suspend fun executeLongRunningTask() {
        for (i in 1..10000000) {
        }
    }
}