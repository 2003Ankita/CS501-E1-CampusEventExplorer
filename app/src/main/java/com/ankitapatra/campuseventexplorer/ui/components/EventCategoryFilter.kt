package com.ankitapatra.campuseventexplorer.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun EventCategoryFilter(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        categories.forEach { category ->
            FilterChip(
                selected = selectedCategory == category,
                onClick = { onCategorySelected(category) },
                shape = RoundedCornerShape(50),
                border = FilterChipDefaults.filterChipBorder(
                    enabled = true,
                    selected = selectedCategory == category,
                    borderColor = Color(0xFFE1D9F5),
                    selectedBorderColor = Color.Transparent
                ),
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = Color.White,
                    labelColor = Color(0xFF716987),
                    selectedContainerColor = Color(0xFFE8DEFF),
                    selectedLabelColor = Color(0xFF5032A5)
                ),
                label = {
                    Text(
                        text = when (category) {
                            "All" -> "✨ All"
                            "Technology" -> "💻 Technology"
                            "Music" -> "🎵 Music"
                            "Career" -> "💼 Career"
                            "Wellness" -> "🌿 Wellness"
                            "Culture" -> "🌎 Culture"
                            "Sports" -> "🏅 Sports"
                            "Arts" -> "🎨 Arts"
                            else -> category
                        }
                    )
                }
            )
        }
    }
}