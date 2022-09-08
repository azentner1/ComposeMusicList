@file:OptIn(ExperimentalUnitApi::class)

package com.andrej.composemusiclist.feature.details.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.andrej.composemusiclist.R
import com.andrej.composemusiclist.base.ext.toNamedMonth
import com.andrej.composemusiclist.base.model.domain.Album
import com.andrej.composemusiclist.base.model.domain.Genre
import com.andrej.composemusiclist.base.ui.compose.FullscreenLoadingComponent
import com.andrej.composemusiclist.base.ui.compose.NetworkErrorComponent
import com.andrej.composemusiclist.base.ui.theme.AlbumDetailButtonStyle
import com.andrej.composemusiclist.base.ui.theme.AlbumDetailCopyrightStyle
import com.andrej.composemusiclist.base.ui.theme.AlbumDetailGenrePillStyle
import com.andrej.composemusiclist.base.ui.theme.AlbumDetailReleasedStyle
import com.andrej.composemusiclist.base.ui.theme.AlbumDetailSubtitleStyle
import com.andrej.composemusiclist.base.ui.theme.AlbumDetailTitleStyle
import com.andrej.composemusiclist.base.ui.theme.BackIconCircleHalfTransparent
import com.andrej.composemusiclist.base.ui.theme.BrightBlue
import com.andrej.composemusiclist.feature.details.DetailsViewModel

@Composable
fun AlbumDetailsComponent(albumId: String?, onNavigateToHome: () -> Unit) {

    val detailsViewModel: DetailsViewModel = hiltViewModel()

    when (albumId) {
        null -> {
            NetworkErrorComponent(showRetryButton = false)
        }
        else -> {
            detailsViewModel.getAlbumById(albumId)
        }
    }

    when (detailsViewModel.album) {
        null -> {
            FullscreenLoadingComponent()
        }
        else -> {
            AlbumDetailsScreen(detailsViewModel.album, onNavigateToHome)
        }
    }
}

@Composable
fun AlbumDetailsScreen(album: Album?, onNavigateToHome: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .aspectRatio(1f)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = rememberImagePainter(data = album?.artworkUrl),
                contentDescription = ""
            )
            IconButton(modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
                .clip(
                    RoundedCornerShape(
                        200.dp
                    )
                )
                .background(BackIconCircleHalfTransparent), onClick = { onNavigateToHome() }) {
                Icon(
                    painter = rememberVectorPainter(image = ImageVector.vectorResource(id = R.drawable.ic_chevron_left)),
                    contentDescription = ""
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = album?.artistName ?: "",
            style = AlbumDetailTitleStyle
        )
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = album?.name ?: "",
            style = AlbumDetailSubtitleStyle
        )
        Spacer(modifier = Modifier.height(8.dp))
        GenrePill(modifier = Modifier.padding(horizontal = 16.dp), album?.genres ?: listOf())
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.details_released, album?.releaseDate?.toNamedMonth() ?: ""),
                    style = AlbumDetailReleasedStyle
                )
                Text(
                    text = stringResource(R.string.detail_copyright),
                    style = AlbumDetailCopyrightStyle
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(backgroundColor = BrightBlue)
                ) {
                    Text(text = stringResource(R.string.details_button), style = AlbumDetailButtonStyle)
                }
                Spacer(modifier = Modifier.height(48.dp))
            }
        }
    }
}

@Composable
fun GenrePill(modifier: Modifier, genres: List<Genre>) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(50.dp),
        border = BorderStroke(width = 1.dp, color = BrightBlue)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            text = genres.first().name,
            style = AlbumDetailGenrePillStyle
        )
    }
}