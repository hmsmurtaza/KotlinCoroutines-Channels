package com.android.example.kotlincoroutines_channels.cheezy_code_coroutines_practice.viewmodel_scope_and_lifecycle_scope

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity4ViewModel : ViewModel() {
    private val TAG = "KOTLIN_COROUTINES"

    init {
        viewModelScope.launch {// Dispatcher.IO || Dispatcher.Main
            while (true) {
                delay(500)
                Log.d(TAG, "hello from hmsmurtaza")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "View model destroyed")
    }
}