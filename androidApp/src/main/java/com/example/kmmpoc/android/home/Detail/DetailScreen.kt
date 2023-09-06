package com.example.kmmpoc.android.home.Detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    detailViewModel: DetailViewModel = koinViewModel(),
    coinId: Int
) {

    detailViewModel.coinId = coinId.toString()

    detailViewModel.loadCoins(false)
    val uiState by detailViewModel.uiStateCoin.collectAsState()

    Box(
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {
            AsyncImage(
                model = uiState.coin?.photo?.url,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxWidth()
                    .height(320.dp)
            )

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(20.dp)
            ) {

                Text(
                    text = "Released in ${uiState.coin?.photo?.title}".uppercase(),
                    style = MaterialTheme.typography.overline
                )

                Spacer(modifier = modifier.height(4.dp))

                Text(
                    text = uiState.coin?.photo?.description.toString(),
                    style = MaterialTheme.typography.body2
                )
            }
        }

    }
}
















