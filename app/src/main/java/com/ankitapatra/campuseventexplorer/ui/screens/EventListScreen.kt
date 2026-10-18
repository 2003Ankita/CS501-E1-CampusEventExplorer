
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

@Composable
fun EventListScreen(
    events: List<CampusEvent>,
    query: String,
    onQueryChange: (String) -> Unit,
    onEventSelected: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    // Filtering is derived from query, not stored separately.
    val filteredEvents = events.filter { event ->
        event.title.contains(query.trim(), ignoreCase = true) ||
                event.category.contains(query.trim(), ignoreCase = true)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
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
                text = "🎓 Campus Explorer",
                color = androidx.compose.ui.graphics.Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Discover what's happening on campus!",
                color = androidx.compose.ui.graphics.Color.White.copy(
                    alpha = 0.85f
                ),
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

        // Number of matching events
        Text(
            text = "${filteredEvents.size} events found",
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
