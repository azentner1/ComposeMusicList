package com.andrej.composemusiclist.base.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.andrej.composemusiclist.feature.details.ui.AlbumDetailsComponent
import com.andrej.composemusiclist.feature.home.ui.HomeComponent

@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationDirections.home.destination
    ) {
        composable(NavigationDirections.home.destination) {
            HomeComponent(onNavigateToDetails = {
                    albumId ->
                navController.navigate("${NavigationDirections.albumDetails.destination}/$albumId")

            })
        }
        composable(NavigationDirections.albumDetails.destination + DETAILS_ARG_PLACEHOLDER,
        arguments = listOf(navArgument(DETAILS_ARG) { type = NavType.StringType })) {
            val albumId = it.arguments?.getString(DETAILS_ARG)
            AlbumDetailsComponent(albumId, onNavigateToHome = {
                navController.navigate(NavigationDirections.home.destination)
            })
        }
    }
}


private const val DETAILS_ARG = "albumId"
private const val DETAILS_ARG_PLACEHOLDER = "/{albumId}"