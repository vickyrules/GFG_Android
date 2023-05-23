package com.mine.gfgnews.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mine.gfgnews.R
import com.mine.gfgnews.network.model.Item
import com.mine.gfgnews.ui.components.Top_App_Bar
import com.mine.gfgnews.ui.utils.formatDateFromString

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    onRefresh: () -> Unit,
    homeUiState: HomeUiState = homeViewModel.homeUiState
) {
    when (homeUiState) {
        is HomeUiState.Success -> ResultScreen(newsList = homeUiState.NewsList)
        is HomeUiState.Loading -> LoadingScreen()
        is HomeUiState.Error -> ErrorScreen(retryAction = onRefresh)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(modifier: Modifier = Modifier, newsList: List<Item>) {
    val isRefreshing = remember { mutableStateOf(false) }

    Scaffold(
        topBar = { Top_App_Bar(title = "GeekForGeeks") }
    ) { innerPadding ->
        LazyColumn(
            modifier.fillMaxWidth().padding(innerPadding)
                .padding(all = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item { NewsCard(item = newsList.first()) }
            items(newsList.subList(1, newsList.size)) { item ->
                ListItems(item = item)
            }
        }

    }
}


@Composable
fun ListItems(item: Item) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(100.dp, 160.dp)
            .clickable(onClick = {}),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(15.dp)
    ) {
        Row(modifier = Modifier.wrapContentHeight())
        {
            Column(
                modifier = Modifier.fillMaxHeight().weight(0.65f).padding(start = 5.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    modifier = Modifier.padding(5.dp).align(Alignment.Start),
                    text = item.title,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Start
                )
                Divider()
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = formatDateFromString(inputDateTime = item.pubDate),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            NewsImg(
                img_src = item.thumbnail, modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.35f)
            )
        }
    }
}

@Composable
fun NewsCard(modifier: Modifier = Modifier, item: Item) {
    OutlinedCard(modifier = Modifier.clickable(onClick = {})) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            NewsImg(
                img_src = item.enclosure.link,
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(200.dp, 200.dp)
            )
            NewsInfo(
                title = item.title,
                time = item.pubDate,
                description = item.description
            )

        }
    }
}

@Composable
fun NewsInfo(modifier: Modifier = Modifier, title: String, description: String, time: String) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(5.dp),
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )
        Divider()
        Text(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            text = formatDateFromString(inputDateTime = time),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyMedium
        )
    }

}

@Composable
fun NewsImg(modifier: Modifier = Modifier, img_src: String) {
    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(data = img_src)
            .crossfade(true)
            .build(),
        error = painterResource(id = R.drawable.ic_broken_image),
        placeholder = painterResource(id = R.drawable.loading_img),
        contentScale = ContentScale.FillBounds,
        contentDescription = null
    )
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.loading_img),
            contentDescription = "laoding"
        )

    }
}

/**
 * The home screen displaying error message with re-attempt button.
 */
@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Failed")
        Button(onClick = retryAction) {
            Text("retry")
        }
    }
}