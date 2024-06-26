package com.myapplication.feeling.controllers

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.myapplication.choosetaste.controllers.ChooseTaste
import com.example.myapplication.R
import com.google.android.material.button.MaterialButton

final class ChooseFeeling : ComponentActivity() {
    private lateinit var feelingButtons: Array<MaterialButton>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_feeling_activity)
        setUpMaterialButton()
    }

    private fun setUpMaterialButton() {
        feelingButtons = arrayOf(
            findViewById<MaterialButton>(R.id.cyf_1),
            findViewById<MaterialButton>(R.id.cyf_2),
            findViewById<MaterialButton>(R.id.cyf_3)
        )
        feelingButtons.forEach { element ->
            element.setOnClickListener {
                val buttonText = element.text
                val intent = Intent(this, ChooseTaste::class.java)
                intent.putExtra("feeling", buttonText)
                startActivity(intent)
                finish()
            }
        }
    }
}