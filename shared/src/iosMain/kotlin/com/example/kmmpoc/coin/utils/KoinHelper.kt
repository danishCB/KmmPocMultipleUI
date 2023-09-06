package com.example.kmmpoc.coin.utils

import com.example.kmmpoc.coin.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(getSharedModules())
    }
}