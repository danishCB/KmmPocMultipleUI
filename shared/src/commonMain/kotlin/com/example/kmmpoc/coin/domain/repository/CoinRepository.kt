package com.example.kmmpoc.coin.domain.repository

import com.example.kmmpoc.coin.data.remote.model.CoinRemote
import com.example.kmmpoc.coin.data.remote.model.CoinRemoteDetail

interface CoinRepository {

    suspend fun getCoins(): List<CoinRemote>

    suspend fun getCoinDetails(coinId:String): CoinRemoteDetail

}