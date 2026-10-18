
package com.ankitapatra.campuseventexplorer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightCampusColorScheme = lightColorScheme(
    primary = CampusPurple,
    onPrimary = CampusSurface,
    primaryContainer = CampusLavender,
    onPrimaryContainer = CampusDeepPurple,

    secondary = CampusCoral,
    onSecondary = CampusSurface,

    tertiary = CampusTeal,
    onTertiary = CampusSurface,

    background = CampusBackground,
    onBackground = CampusText,

    surface = CampusSurface,
    onSurface = CampusText,
    onSurfaceVariant = CampusTextSecondary
)

private val DarkCampusColorScheme = darkColorScheme(
    primary = CampusLavender,
    onPrimary = CampusDeepPurple,

    secondary = CampusCoral,
    tertiary = CampusTeal
)

@Composable
fun CampusEventExplorerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkCampusColorScheme
    } else {
        LightCampusColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
