package com.android.example.kotlincoroutines_channels.cheezy_code_coroutines_practice.viewmodel_scope_and_lifecycle_scope

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.android.example.kotlincoroutines_channels.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity4 : ComponentActivity() {
    private val TAG = "KOTLIN_COROUTINES"
    private lateinit var mainActivity4ViewModel: MainActivity4ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        mainActivity4ViewModel = ViewModelProvider(this)[MainActivity4ViewModel::class.java]

        // lifecycle scope
        lifecycleScope.launch {
            delay(2000)
            val intent = Intent(this@MainActivity4, AnotherActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}