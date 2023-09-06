package com.example.kmmpoc.coin.di

import com.example.kmmpoc.coin.data.remote.ApiService
import com.example.kmmpoc.coin.data.remote.RemoteDataSource
import com.example.kmmpoc.coin.data.repository.CoinRepositoryImp
import com.example.kmmpoc.coin.domain.repository.CoinRepository
import com.example.kmmpoc.coin.domain.usecases.GetCoinUseCase
import com.example.kmmpoc.coin.domain.usecases.GetCoinsUseCase
import com.example.kmmpoc.coin.utils.provideDispatcher
import org.koin.dsl.module

//// Koin Dependency Injection
private val dataModule =  module {
    factory { RemoteDataSource(get(),get()) }
    factory { ApiService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module{
    single<CoinRepository> { CoinRepositoryImp(get()) }
    factory { GetCoinsUseCase() }
    factory { GetCoinUseCase() }
}

private val sharedModules = listOf(dataModule, utilityModule, domainModule)

fun getSharedModules() = sharedModules