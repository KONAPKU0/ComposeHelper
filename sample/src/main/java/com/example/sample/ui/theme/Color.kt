package com.example.sample.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

@Immutable
data class AppColorsPalette(
    val sampleOne: Color = Color.Unspecified,
    val sampleTow: Color = Color.Unspecified,
)

val LocalAppColorsPalette = staticCompositionLocalOf { AppColorsPalette() }

val MaterialTheme.appColors: AppColorsPalette
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColorsPalette.current

val OnLightAppColorsPalette =
    AppColorsPalette(sampleOne = Color(0x4DEDEDED), sampleTow = Color(0x4DEDEDED))

val OnDarkAppColorsPalette =
    AppColorsPalette(sampleOne = Color(0x4DEDEDED), sampleTow = Color(0x4DEDEDED))