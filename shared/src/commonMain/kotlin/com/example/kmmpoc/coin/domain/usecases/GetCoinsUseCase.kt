package com.example.kmmpoc.coin.domain.usecases

import com.example.kmmpoc.coin.data.remote.model.CoinRemote
import com.example.kmmpoc.coin.domain.repository.CoinRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetCoinsUseCase: KoinComponent {

    private val repository: CoinRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(): List<CoinRemote>{
        return repository.getCoins()
    }

}