package com.example.kmmpoc.coin.data.remote

import com.example.kmmpoc.coin.data.remote.model.CoinRemote
import com.example.kmmpoc.coin.data.remote.model.CoinRemoteDetail
import com.example.kmmpoc.coin.data.remote.model.CoinResponse
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class ApiService : KtorApi() {

    suspend fun getCoin(page: Int = 1): CoinResponse = client.get("https://api.slingacademy.com/v1/sample-data/photos").body()

    suspend fun getCoinDetail(coinId: String): CoinRemoteDetail = client.get("https://api.slingacademy.com/v1/sample-data/photos/${coinId}").body()

}