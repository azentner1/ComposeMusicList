@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)

package com.andrej.composemusiclist.feature.home.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.andrej.composemusiclist.R
import com.andrej.composemusiclist.base.model.data.UiDataState
import com.andrej.composemusiclist.base.model.domain.Album
import com.andrej.composemusiclist.base.ui.compose.FullscreenLoadingComponent
import com.andrej.composemusiclist.base.ui.compose.NetworkErrorComponent
import com.andrej.composemusiclist.base.ui.theme.GridImageGradientBottom
import com.andrej.composemusiclist.base.ui.theme.GridImageGradientTop
import com.andrej.composemusiclist.base.ui.theme.GridItemSubtitleStyle
import com.andrej.composemusiclist.base.ui.theme.GridItemTitleStyle
import com.andrej.composemusiclist.base.ui.theme.HomeTitleStyleNormal
import com.andrej.composemusiclist.base.ui.theme.HomeTitleStyleScroll
import com.andrej.composemusiclist.feature.home.HomeDataEvent
import com.andrej.composemusiclist.feature.home.HomeViewModel

@Composable
fun HomeComponent(onNavigateToDetails: (albumId: String) -> Unit) {
    HomeListComponent(hiltViewModel(), onNavigateToDetails)
}

@Composable
fun HomeListComponent(
    homeViewModel: HomeViewModel,
    onNavigateToDetails: (albumId: String) -> Unit
) {

    when (homeViewModel.homeUiDataState) {
        is UiDataState.Loading -> {
            FullscreenLoadingComponent()
        }
        is UiDataState.Error -> {
            when {
                homeViewModel.albumList.isEmpty() -> {
                    NetworkErrorComponent(showRetryButton = true, onNetworkRetry = {
                        homeViewModel.setStateForEvent(HomeDataEvent.FetchMostPlayedAlbums)
                    })
                }
                else -> {
                    AlbumsGridList(
                        albumList = homeViewModel.albumList,
                        onNavigateToDetails = onNavigateToDetails
                    )
                }
            }
        }
        is UiDataState.Success -> {
            AlbumsGridList(
                albumList = homeViewModel.albumList,
                onNavigateToDetails = onNavigateToDetails
            )
        }
    }

    homeViewModel.setStateForEvent(HomeDataEvent.FetchMostPlayedAlbums)
}

@Composable
fun AlbumsGridList(albumList: List<Album>, onNavigateToDetails: (albumId: String) -> Unit) {

    val scrollState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 4.dp)
    ) {
        val titleTextStyle =
            if (scrollState.firstVisibleItemIndex == 0 && scrollState.firstVisibleItemScrollOffset < TOOLBAR_COLLAPSE_THRESHOLD) {
                HomeTitleStyleNormal
            } else {
                HomeTitleStyleScroll
            }
        val titleAlignment =
            if (scrollState.firstVisibleItemIndex == 0 && scrollState.firstVisibleItemScrollOffset < TOOLBAR_COLLAPSE_THRESHOLD) {
                TextAlign.Start
            } else {
                TextAlign.Center
            }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            text = stringResource(R.string.home_title),
            textAlign = titleAlignment,
            style = titleTextStyle
        )
        Spacer(modifier = Modifier.height(3.dp))
        LazyVerticalGrid(modifier = Modifier
            .fillMaxSize(),
            state = scrollState,
            cells = GridCells.Fixed(GRID_COLUMN_COUNT), contentPadding = PaddingValues(
                all = 12.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp), content = {
                items(albumList.size) { index ->
                    GridItemComponent(
                        album = albumList[index],
                        onAlbumClicked = { albumId -> onNavigateToDetails(albumId) })
                }
            })
    }
}

@Composable
fun GridItemComponent(album: Album, onAlbumClicked: (id: String) -> Unit) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(size = 16.dp))
        .aspectRatio(1f)
        .clickable { onAlbumClicked(album.id) }) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberImagePainter(data = album.artworkUrl),
            contentDescription = ""
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(GridImageGradientTop, GridImageGradientBottom)
                    )
                )
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 12.dp), horizontalAlignment = Alignment.Start
        ) {
            Text(text = album.name, style = GridItemTitleStyle)
            Text(text = album.artistName, style = GridItemSubtitleStyle)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

private const val TOOLBAR_COLLAPSE_THRESHOLD = 200
private const val GRID_COLUMN_COUNT = 2