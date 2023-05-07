package com.onuralan.bootcamp.network


import android.util.Log
import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.chat.*
import com.aallam.openai.api.http.Timeout
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import com.aallam.openai.client.OpenAIConfig
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.time.Duration.Companion.seconds


@OptIn(BetaOpenAI::class)
suspend fun sendGPTPropt(message:String):String?{
    val config = OpenAIConfig(
        token = "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",
        timeout = Timeout(socket = 60.seconds),
        // additional configurations...
    )

    val openAI = OpenAI("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")
    openAI.model(ModelId("gpt-3.5-turbo"))
    val chatCompletionRequest = ChatCompletionRequest(
        model = ModelId("gpt-3.5-turbo"),
        messages = listOf(
            ChatMessage(
                role = ChatRole.User,
                content = message
            )
        )
    )
    val completion: ChatCompletion = openAI.chatCompletion(chatCompletionRequest)
    return completion.choices[0].message?.content;
}