package com.andrej.composemusiclist.base.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andrej.composemusiclist.R
import com.andrej.composemusiclist.base.model.domain.Album
import com.andrej.composemusiclist.base.ui.theme.GridImageGradientBottom
import com.andrej.composemusiclist.base.ui.theme.GridImageGradientTop

@Composable
fun GridItemComponent() {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(size = 16.dp))
        .aspectRatio(1f)) {
        Image(modifier = Modifier.fillMaxSize(), painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "")
        Box(modifier = Modifier.fillMaxSize().background(
            brush = Brush.verticalGradient(
                colors = listOf(GridImageGradientTop, GridImageGradientBottom)
            )
        )
        )
        Column(modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .padding(horizontal = 12.dp), horizontalAlignment = Alignment.Start) {
            Text(text = "Title", fontSize = 16.sp, fontFamily = FontFamily.SansSerif, color = Color.White)
            Text(text = "Subtitle", fontSize = 12.sp, fontFamily = FontFamily.SansSerif, color = Color.Gray)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Preview
@Composable
fun GridItemComponentPreview() {
   GridItemComponent()
}