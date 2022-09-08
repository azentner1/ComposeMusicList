package com.andrej.composemusiclist.base.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.andrej.composemusiclist.base.ui.theme.BrightBlue

@Composable
fun FullscreenLoadingComponent() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White), contentAlignment = Alignment.Center) {
       CircularProgressIndicator(color = BrightBlue)
    }
}