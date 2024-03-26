package com.android.example.kotlincoroutines_channels.cheezy_code_coroutines_practice.viewmodel_scope_and_lifecycle_scope

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.android.example.kotlincoroutines_channels.R

class AnotherActivity : ComponentActivity() {
    private val TAG = "KOTLIN_COROUTINES"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)
    }
}