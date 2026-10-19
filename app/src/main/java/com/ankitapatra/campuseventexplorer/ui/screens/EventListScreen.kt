
package com.ankitapatra.campuseventexplorer.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ankitapatra.campuseventexplorer.model.CampusEvent
import com.ankitapatra.campuseventexplorer.ui.components.EventCard
import com.ankitapatra.campuseventexplorer.ui.components.EventSearchBar
import com.ankitapatra.campuseventexplorer.ui.theme.CampusDeepPurple
import com.ankitapatra.campuseventexplorer.ui.theme.CampusPurple
import androidx.compose.ui.graphics.Brush
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.ankitapatra.campuseventexplorer.ui.components.EventCategoryFilter



@Composable
fun EventListScreen(
    events: List<CampusEvent>,
    query: String,
    onQueryChange: (String) -> Unit,
    onEventSelected: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    // Selected category survives screen rotation.
    var selectedCategory by rememberSaveable {
        mutableStateOf("All")
    }
    // Filtering is derived from query, not stored separately.
    // Filtering is derived from the search query and selected category.
    val filteredEvents = events.filter { event ->

        val matchesSearch =
            event.title.contains(query.trim(), ignoreCase = true) ||
                    event.category.contains(query.trim(), ignoreCase = true)

        val matchesCategory =
            selectedCategory == "All" ||
                    event.category == selectedCategory

        matchesSearch && matchesCategory
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
    ) {

        // Colorful header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            CampusPurple,
                            CampusDeepPurple
                        )
                    ),
                    shape = RoundedCornerShape(
                        bottomStart = 28.dp,
                        bottomEnd = 28.dp
                    )
                )
                .padding(24.dp)
        ) {
            Text(
                text = "✦ YOUR CAMPUS, YOUR EVENTS",
                color = androidx.compose.ui.graphics.Color.White.copy(alpha = 0.75f),
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Discover what's\nhappening ✨",
                color = androidx.compose.ui.graphics.Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                lineHeight = 36.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Find your next favorite campus experience.",
                color = androidx.compose.ui.graphics.Color.White.copy(alpha = 0.85f),
                fontSize = 14.sp
            )
        }

        // Search field
        EventSearchBar(
            query = query,
            onQueryChange = onQueryChange,
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 16.dp
            )
        )
    // Horizontally scrollable category filters
        EventCategoryFilter(
            categories = listOf("All") + events.map { it.category }.distinct(),
            selectedCategory = selectedCategory,
            onCategorySelected = { selectedCategory = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 12.dp)
        )
        // Number of matching events
        Text(
            text = "${filteredEvents.size} ${if (filteredEvents.size == 1) "event" else "events"} found",
            modifier = Modifier.padding(
                horizontal = 20.dp,
                vertical = 4.dp
            ),
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // Event list
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 12.dp,
                bottom = 24.dp
            ),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(
                items = filteredEvents,
                key = { event -> event.id }
            ) { event ->
                EventCard(
                    event = event,
                    onClick = onEventSelected
                )
            }
        }
    }
}
