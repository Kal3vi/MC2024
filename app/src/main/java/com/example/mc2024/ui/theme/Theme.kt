package com.example.mc2024.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPaletteOld = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)
private val DarkColorPalette = darkColors(
    primary = pink100,
    primaryVariant = Purple200,
    secondary = pink50
)

private val LightColorPaletteOld = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

)
private val LightColorPalette = lightColors(
    primary = pink100,
    primaryVariant = Purple200,
    secondary = pink50

)

@Composable
fun MC2024Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}