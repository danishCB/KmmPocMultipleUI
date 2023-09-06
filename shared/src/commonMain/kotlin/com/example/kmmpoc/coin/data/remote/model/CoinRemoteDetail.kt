package com.example.kmmpoc.coin.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class CoinRemoteDetail(
    val message: String? = null,
    val photo: CoinRemote? = null,
    val success: Boolean? = null
)

