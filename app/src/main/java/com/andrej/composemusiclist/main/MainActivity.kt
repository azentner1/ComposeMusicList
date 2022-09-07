package com.andrej.composemusiclist.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.andrej.composemusiclist.base.ui.theme.ComposeMusicListTheme
import com.andrej.composemusiclist.feature.home.repository.HomeRepository
import com.andrej.composemusiclist.feature.home.ui.HomeComponent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var homeRepository: HomeRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            homeRepository.getMostPlayedAlbums()
        }
        setContent {
            ComposeMusicListTheme {
                HomeComponent()
            }
        }
    }
}