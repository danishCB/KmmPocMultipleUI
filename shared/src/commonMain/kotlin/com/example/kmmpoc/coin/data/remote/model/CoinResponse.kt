package com.example.kmmpoc.coin.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
internal data class CoinResponse(
    /*    val data: ArrayList<CoinRemote> = arrayListOf(),
        val timestamp: Int? = null*/
    val totalPhotos: Int? = null,
    val message: String? = null,
    val offset: Int? = null,
    val limit: Int? = null,
    val photos: List<CoinRemote> = arrayListOf()
)
