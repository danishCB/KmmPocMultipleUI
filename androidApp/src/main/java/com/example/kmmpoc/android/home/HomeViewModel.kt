package com.example.kmmpoc.android.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmmpoc.coin.data.remote.model.CoinRemote
import com.example.kmmpoc.coin.domain.usecases.GetCoinUseCase
import com.example.kmmpoc.coin.domain.usecases.GetCoinsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(val getCoinsUseCase: GetCoinsUseCase) : ViewModel() {

    var uiState by mutableStateOf(HomeScreenStates())
    var _uiStateCoinList = MutableStateFlow(HomeScreenStates())
    var uiStateCoin = _uiStateCoinList.asStateFlow()

    init {
        loadCoins(refreshData = false)
    }

    fun loadCoins(refreshData: Boolean = false) {
        println("CoinData true")

        if (uiState.loading) return
        if (refreshData) uiState.coinList = arrayListOf()
        if (refreshData) uiState.copy(refreshing = true)

        viewModelScope.launch {
            uiState = uiState.copy(loading = true)


            try {
                val coinList = getCoinsUseCase()
                coinList.let { list ->
                    _uiStateCoinList.update {
                        uiState.copy(
                            loading = false,
                            refreshing = false,
                            loadingFinished = coinList.isEmpty(),
                            coinList = list as ArrayList<CoinRemote>
                        )
                    }
                }
                println("CoinData $coinList")
            } catch (error: Throwable) {
                uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadingFinished = true,
                    error = "Error Loading Coins ${error.localizedMessage}"
                )
                println("CoinDataExc $error")
            }
        }

    }

}


data class HomeScreenStates(
    var loading: Boolean = false,
    var refreshing: Boolean = false,
    var coinList: ArrayList<CoinRemote> = arrayListOf(),
    var loadingFinished: Boolean = false,
    var error: String = "",
)