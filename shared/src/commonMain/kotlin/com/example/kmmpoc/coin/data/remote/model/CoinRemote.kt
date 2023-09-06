package com.example.kmmpoc.coin.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class CoinRemote(
    /* var id: String? = null,
     var rank: String? = null,
     var symbol: String? = null,
     var name: String? = null,
     var supply: String? = null,
     var maxSupply: String? = null,
     var marketCapUsd: String? = null,
     var volumeUsd24Hr: String? = null,
     var priceUsd: String? = null,
     var changePercent24Hr: String? = null,
     var vwap24Hr: String? = null,
     var explorer: String? = null*/
    val description: String? = null,
    val id: Int? = null,
    val url: String? = null,
    val title: String? = null,
    val user: Int? = null
)

