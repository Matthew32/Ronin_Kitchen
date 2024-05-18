package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.gemini.GeminiRequest
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.launch

final class ShowResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_result_activity)
        requestGemini()
    }

    private fun requestGemini() {
        val context = this;

        lifecycleScope.launch {
            val feeling = intent.getStringExtra("feeling")
            val taste = intent.getStringExtra("taste")
            val geminiRequestInstance = GeminiRequest(context);
            try {
                val geminiResult = geminiRequestInstance.requestGeminiGuest(feeling, taste)
                val resultTextView = findViewById<TextView>(R.id.sr_result_textview)
                val progressBar = findViewById<ProgressBar>(R.id.sr_result_progressbar)

                progressBar.visibility = View.GONE
                resultTextView.text = geminiResult;
            } catch (e: Exception) {
                println(e)
                Toast.makeText(
                    context,
                    "Error requesting information on gemini api, Please, PAY!",
                    Toast.LENGTH_LONG
                ).show();
                finish()
            }
        }
    }
}