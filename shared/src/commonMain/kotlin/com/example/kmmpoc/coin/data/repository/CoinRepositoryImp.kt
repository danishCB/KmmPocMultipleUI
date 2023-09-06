package com.example.kmmpoc.coin.data.repository

import com.example.kmmpoc.coin.data.remote.RemoteDataSource
import com.example.kmmpoc.coin.data.remote.model.CoinRemote
import com.example.kmmpoc.coin.data.remote.model.CoinRemoteDetail
import com.example.kmmpoc.coin.domain.repository.CoinRepository

internal class CoinRepositoryImp(private val remoteDataSource: RemoteDataSource) : CoinRepository {

    override suspend fun getCoins(): List<CoinRemote> {
       return remoteDataSource.getCoins().photos
    }

    override suspend fun getCoinDetails(coinId:String): CoinRemoteDetail {
        return remoteDataSource.getCoinDetail(coinId)
    }

}