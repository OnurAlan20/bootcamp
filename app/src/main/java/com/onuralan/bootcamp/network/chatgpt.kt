package com.onuralan.bootcamp.network

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray


fun sendGPTPropt(message:String){
    runBlocking {
        val prompt = "Kotlin hakkında bazı bilgiler verin."
        val apiKey = "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"
        val apiUrl = "https://api.openai.com/v1/engines/davinci-codex/completions"

        val client = HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }

        val customHeaders = Headers.build {
            append("Content-Type", "application/json")
            append("Authorization", "Bearer $apiKey")
        }

        val data = "{\"prompt\":${prompt},\"max_tokens\":50}"

        val response: HttpResponse = client.post(apiUrl) {
            headers.appendAll(customHeaders)
            contentType(ContentType.Application.Json)
            body = data
        }

        if (response.status == HttpStatusCode.OK) {
            val responseBody = response.readText()
            println(responseBody)
            /*val chatGPTResponse = JsonArray(responseBody)
            val answer = chatGPTResponse.choices[0].text
            println("Cevap: $answer")*/
        } else {
           // println("Hata: ${response.status} - ${response.readText()}")
        }

        client.close()
    }
}