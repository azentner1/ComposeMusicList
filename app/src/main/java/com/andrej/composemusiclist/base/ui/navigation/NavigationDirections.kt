package com.andrej.composemusiclist.base.ui.navigation

object NavigationDirections {

    val home = object: NavigationItem {
        override val destination: String by lazy { HOME }
    }

    val albumDetails = object: NavigationItem {
        override val destination: String by lazy { ALBUM_DETAILS }
    }

    private const val HOME = "home"
    private const val ALBUM_DETAILS = "albumDetails"
}