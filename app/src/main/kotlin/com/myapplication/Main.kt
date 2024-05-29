package com.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.myapplication.R
import com.myapplication.feeling.controllers.ChooseFeeling
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Main : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.fab)
        floatingActionButton.setOnClickListener {
            val intent = Intent(this, ChooseFeeling::class.java)
            startActivity(intent)
            finish()
        }
    }
}