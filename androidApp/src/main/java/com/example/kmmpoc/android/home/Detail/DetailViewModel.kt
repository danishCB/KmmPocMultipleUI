package com.example.kmmpoc.android.home.Detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmmpoc.coin.data.remote.model.CoinRemoteDetail
import com.example.kmmpoc.coin.domain.usecases.GetCoinUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailViewModel(val getCoinUseCase: GetCoinUseCase) : ViewModel() {

    var uiState by mutableStateOf(DetailScreenStates())
    var _uiStateCoinList = MutableStateFlow(DetailScreenStates())
    var uiStateCoin = _uiStateCoinList.asStateFlow()
    var coinId = ""

    fun loadCoins(refreshData: Boolean = false) {
        println("CoinData true")

        if (uiState.loading) return
        if (refreshData) uiState.coin
        if (refreshData) uiState.copy(refreshing = true)

        viewModelScope.launch {
            uiState = uiState.copy(loading = true)


            try {
                val coinList = getCoinUseCase(coinId)
                coinList.let { list ->
                    _uiStateCoinList.update {
                        uiState.copy(
                            loading = false,
                            refreshing = false,
                            loadingFinished = coinList.photo?.title?.isEmpty() == true,
                            coin = list as CoinRemoteDetail
                        )
                    }
                }
                println("CoinDataDetail $coinList")
            } catch (error: Throwable) {
                uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadingFinished = true,
                    error = "Error Loading Coins ${error.localizedMessage}"
                )
                println("CoinDataDetailExc $error")
            }
        }

    }

}


data class DetailScreenStates(
    var loading: Boolean = false,
    var refreshing: Boolean = false,
    var coin: CoinRemoteDetail? = null,
    var loadingFinished: Boolean = false,
    var error: String = "",
)