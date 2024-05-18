package com.example.myapplication.gemini

import androidx.activity.ComponentActivity
import com.example.myapplication.R
import com.example.myapplication.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel

class GeminiRequest(
    private var context: ComponentActivity
) {
    suspend fun requestGeminiGuest(feeling: String?, taste: String?): String? {
        if (feeling === null) {
            throw Exception("GeminiRequest::Feeling is not set up.")
        }
        if (taste == null) {
            throw Exception("GeminiRequest::Taste is not set up.");
        }
        val generativeModel = GenerativeModel(
            // For text-only input, use the gemini-pro model
            modelName = "gemini-pro",
            // Access your API key as a Build Configuration variable (see "Set up your API key" above)
            apiKey = BuildConfig.GEMINI_API_KEY
        )

        val prompt = getPrompt(feeling, taste)
        val generateContentResponse = generativeModel.generateContent(prompt)

        return generateContentResponse.text;
    }

    private fun getPrompt(feeling: String?, taste: String?): String {
        val prompt =
            buildString {
                append(context.getString(R.string.today_i_m_feeling))
                append(feeling)
                append(context.getString(R.string.and_my_usual_taste_is))
                append(taste)
                append(context.getString(R.string.recommend_text))
            }
        return prompt
    }
}