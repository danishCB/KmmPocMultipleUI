package com.example.kmmpoc.android.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kmmpoc.android.R
import com.example.kmmpoc.android.home.ComposeItems.CoinListItem
import com.example.kmmpoc.coin.data.remote.model.CoinRemote
//import com.ramcosta.composedestinations.annotation.Destination
//import com.ramcosta.composedestinations.annotation.RootNavGraph
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = koinViewModel(),
    pullToRefresh: (Boolean) -> Unit,
    navigateToDetail: (CoinRemote) -> Unit
) {

    val pullRefreshState = rememberPullRefreshState(refreshing = homeViewModel.uiState.refreshing,
        onRefresh = { pullToRefresh(true) })
    val uiState by homeViewModel.uiStateCoin.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .pullRefresh(pullRefreshState)
    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(
                uiState.coinList,
                key = { _, movie -> movie.id.toString() }
            ) { index, movie ->
                CoinListItem(coin = movie, onCoinClick = { navigateToDetail(movie) })
            }
        }

    }

}