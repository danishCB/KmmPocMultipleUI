package com.example.kmmpoc.android

import android.app.Application
import com.example.kmmpoc.android.di.appModule
import com.example.kmmpoc.coin.di.getSharedModules
import org.koin.core.context.startKoin

class Coin : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule+ getSharedModules())
        }

    }

}