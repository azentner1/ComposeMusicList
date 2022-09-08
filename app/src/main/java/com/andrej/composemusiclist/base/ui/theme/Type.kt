@file:OptIn(ExperimentalUnitApi::class, ExperimentalUnitApi::class, ExperimentalUnitApi::class)

package com.andrej.composemusiclist.base.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

val HomeTitleStyleNormal = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Normal,
    fontSize = 34.sp
)
val HomeTitleStyleScroll = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp
)
val GridItemTitleStyle = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    color = Color.White,
    letterSpacing = TextUnit(value = -0.64f, TextUnitType.Sp),
)
val GridItemSubtitleStyle = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    color = Grey
)
val AlbumDetailTitleStyle = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Normal,
    fontSize = 18.sp,
    letterSpacing = TextUnit(value = -1.36f, TextUnitType.Sp),
    color = DarkerGrey
)
val AlbumDetailSubtitleStyle = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Bold,
    fontSize = 34.sp,
    letterSpacing = TextUnit(value = -0.72f, TextUnitType.Sp),
    color = Dark
)
val AlbumDetailReleasedStyle = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    color = Grey
)
val AlbumDetailCopyrightStyle = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    color = Grey
)
val AlbumDetailButtonStyle = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp,
    letterSpacing = TextUnit(value = -0.64f, TextUnitType.Sp),
    color = Color.White
)
val AlbumDetailGenrePillStyle = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    color = BrightBlue
)