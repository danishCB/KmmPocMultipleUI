package com.example.kmmpoc.coin.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val BASE_URL = "https://api.coincap.io/v2/"
private const val API_KEY = "d958324e-2872-438a-81c8-af8b85dacf65"

internal abstract class KtorApi {

    val client = HttpClient{
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
                encodeDefaults = true
            })
        }
    }

    fun HttpRequestBuilder.pathUrl(path:String){
        url{
            takeFrom(BASE_URL)
            path("3",path)
        }
    }
}