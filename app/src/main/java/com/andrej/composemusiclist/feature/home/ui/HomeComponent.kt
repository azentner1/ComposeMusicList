@file:OptIn(ExperimentalFoundationApi::class)

package com.andrej.composemusiclist.feature.home.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.andrej.composemusiclist.base.ui.compose.GridItemComponent
import com.andrej.composemusiclist.feature.home.HomeDataEvent
import com.andrej.composemusiclist.feature.home.HomeViewModel

@Composable
fun HomeComponent(homeViewModel: HomeViewModel = hiltViewModel()) {

    homeViewModel.dataState.observeForever {
        println("--- data state: " + it)
    }
    homeViewModel.setStateForEvent(HomeDataEvent.FetchMostPlayedAlbums)

    HomeListComponent()
}

@Composable
fun HomeListComponent() {

    val scrollState = rememberLazyListState()

    println("scroll state: " + scrollState.firstVisibleItemScrollOffset)
    println("index state: " + scrollState.firstVisibleItemIndex)

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(horizontal = 4.dp)) {
        val titleWeight = if(scrollState.firstVisibleItemIndex == 0 && scrollState.firstVisibleItemScrollOffset < 200) {
            FontWeight.Normal
        } else {
            FontWeight.Bold
        }
        val titleFontSize =  if(scrollState.firstVisibleItemIndex == 0 && scrollState.firstVisibleItemScrollOffset < 200) {
            34.sp
        } else {
            16.sp
        }
        val titleAlignment = if(scrollState.firstVisibleItemIndex == 0 && scrollState.firstVisibleItemScrollOffset < 200) {
            TextAlign.Start
        } else {
            TextAlign.Center
        }
        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp), text = "Top 100 Albums", fontSize = titleFontSize
       ,
            fontWeight = titleWeight, fontFamily = FontFamily.SansSerif,
        textAlign = titleAlignment)
        Spacer(modifier = Modifier.height(3.dp))
        LazyVerticalGrid(modifier = Modifier
            .fillMaxSize(),
            state = scrollState,
            cells = GridCells.Fixed(2), contentPadding = PaddingValues(
            all = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp), content = {
            items(30) {
                GridItemComponent()
            }
        })
    }
}

@Preview
@Composable
fun HomeListComponentPreview() {
    HomeListComponent()
}