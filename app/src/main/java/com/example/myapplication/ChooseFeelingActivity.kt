package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.google.android.material.button.MaterialButton

final class ChooseFeelingActivity : ComponentActivity() {
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
                val intent = Intent(this, ChooseTasteActivity::class.java)
                intent.putExtra("feeling", buttonText)
                startActivity(intent)
                finish()
            }
        }
    }
}