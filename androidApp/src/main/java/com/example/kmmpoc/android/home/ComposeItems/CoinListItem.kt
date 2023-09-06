package com.example.kmmpoc.android.home.ComposeItems

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kmmpoc.android.R
import com.example.kmmpoc.coin.data.remote.model.CoinRemote

@Composable
fun CoinListItem(
    modifier: Modifier = Modifier, coin: CoinRemote, onCoinClick: (CoinRemote) -> Unit
) {
    Card(
        modifier = modifier
            .height(220.dp)
            .background(colorResource(id = R.color.white))
            .clickable { onCoinClick.invoke(coin) },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Box(
                modifier = modifier.height(100.dp),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = coin.url,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                )
            }

            Column(
                modifier = modifier.padding(10.dp)
            ) {
                Text(
                    text = coin.title.toString(),
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = modifier.height(4.dp))

                Text(text = coin.description.toString(), style = MaterialTheme.typography.caption, maxLines = 4,overflow = TextOverflow.Ellipsis)
            }
        }
    }
}

@Composable
fun SimpleText(
    text: String,
    textColor: Color = colorResource(id = R.color.white),
    style: TextStyle,
    modifier: Modifier
) {
    Text(
        text = text, color = textColor, modifier = modifier, style = style

    )
}
