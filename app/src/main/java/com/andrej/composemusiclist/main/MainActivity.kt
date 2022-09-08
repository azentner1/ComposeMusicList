package com.andrej.composemusiclist.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.andrej.composemusiclist.base.ui.navigation.NavigationComponent
import com.andrej.composemusiclist.base.ui.theme.ComposeMusicListTheme
import com.andrej.composemusiclist.feature.home.repository.HomeRepository
import dagger.hilt.android.AndroidEntryPoint
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
                val navController = rememberNavController()
                NavigationComponent(navController = navController)
            }
        }
    }
}