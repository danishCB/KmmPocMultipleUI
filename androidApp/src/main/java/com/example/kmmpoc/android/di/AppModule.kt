package com.example.kmmpoc.android.di

import com.example.kmmpoc.android.home.Detail.DetailViewModel
import com.example.kmmpoc.android.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { params -> DetailViewModel(getCoinUseCase = get()) }
}