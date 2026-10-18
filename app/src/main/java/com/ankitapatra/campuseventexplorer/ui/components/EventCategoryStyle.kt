
package com.ankitapatra.campuseventexplorer.ui.components

import androidx.compose.ui.graphics.Color
import com.ankitapatra.campuseventexplorer.ui.theme.*

data class EventCategoryStyle(
    val backgroundColor: Color,
    val accentColor: Color,
    val emoji: String
)

fun getEventCategoryStyle(category: String): EventCategoryStyle {
    return when (category.lowercase()) {
        "technology" -> EventCategoryStyle(
            TechnologyBackground,
            CampusPurple,
            "💻"
        )
        "music" -> EventCategoryStyle(
            MusicBackground,
            CampusCoral,
            "🎵"
        )
        "career" -> EventCategoryStyle(
            CareerBackground,
            CampusBlue,
            "💼"
        )
        "wellness" -> EventCategoryStyle(
            WellnessBackground,
            CampusTeal,
            "🌿"
        )
        "culture" -> EventCategoryStyle(
            CultureBackground,
            CampusCoral,
            "🌍"
        )
        "sports" -> EventCategoryStyle(
            SportsBackground,
            CampusYellow,
            "🏆"
        )
        "arts" -> EventCategoryStyle(
            ArtsBackground,
            CampusPurple,
            "🎨"
        )
        else -> EventCategoryStyle(
            CampusLavender,
            CampusDeepPurple,
            "📅"
        )
    }
}
