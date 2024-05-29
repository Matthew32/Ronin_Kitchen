package com.myapplication.choosetaste.controllers

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.myapplication.R
import com.google.android.material.button.MaterialButton
import com.myapplication.showresults.controllers.ShowResultActivity

class ChooseTaste : ComponentActivity() {
    private lateinit var tasteButtons: Array<MaterialButton>
    private var intentFeelingExtra: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_taste_activity)
        intentFeelingExtra = intent.getStringExtra("feeling");
        setUpMaterialButton()
    }

    private fun setUpMaterialButton() {
        tasteButtons = arrayOf(
            findViewById<MaterialButton>(R.id.cyt_1),
            findViewById<MaterialButton>(R.id.cyt_2),
            findViewById<MaterialButton>(R.id.cyt_3),
            findViewById<MaterialButton>(R.id.cyt_4)
        )
        tasteButtons.forEach { element ->
            element.setOnClickListener {
                val buttonText = element.text
                val intent = Intent(this, ShowResultActivity::class.java)
                intent.putExtra("feeling", intentFeelingExtra)
                intent.putExtra("taste", buttonText)
                startActivity(intent)
                finish()
            }
        }
    }
}