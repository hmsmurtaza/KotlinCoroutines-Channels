package com.android.example.kotlincoroutines_channels.cheezy_code_coroutines_practice.with_context_and_run_blocking

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.android.example.kotlincoroutines_channels.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity3 : ComponentActivity() {
    private val TAG = "KOTLIN_COROUTINES"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        GlobalScope.launch {
//            executeTask()
        }

        GlobalScope.launch {
            runBlocking()
        }

    }

    private suspend fun runBlocking() {
        runBlocking {
            GlobalScope.launch {
                delay(1000)
                Log.d(TAG, "hello")
            }
            Log.d(TAG, "world")
        }
    }

    private suspend fun executeTask() {
        Log.d(TAG, "Before")
//        GlobalScope.launch
        withContext(Dispatchers.IO) {
            delay(1000)
            Log.d(TAG, "inside")
        }
        Log.d(TAG, "After")
    }
}