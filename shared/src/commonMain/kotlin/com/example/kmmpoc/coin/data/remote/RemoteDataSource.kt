package com.example.kmmpoc.coin.data.remote

import com.example.kmmpoc.coin.utils.Dispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSource(
    private val apiService: ApiService,
    private val dispatcher: Dispatcher
) {

    suspend fun getCoins() = withContext(dispatcher.io) {
        apiService.getCoin(1)
    }

    suspend fun getCoinDetail(coinId: String) = withContext(dispatcher.io) {
        apiService.getCoinDetail(coinId)
    }

}