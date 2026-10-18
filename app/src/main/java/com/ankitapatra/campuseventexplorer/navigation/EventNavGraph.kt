
package com.ankitapatra.campuseventexplorer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ankitapatra.campuseventexplorer.data.CampusEventRepository
import com.ankitapatra.campuseventexplorer.data.EventRepository
import com.ankitapatra.campuseventexplorer.ui.screens.EventDetailScreen
import com.ankitapatra.campuseventexplorer.ui.screens.EventListScreen

@Composable
fun EventNavGraph(
    onShareEvent: (Long) -> Unit
) {
    val navController = rememberNavController()

    // Use the repository interface, not a concrete type.
    val repository: EventRepository = CampusEventRepository()

    NavHost(
        navController = navController,
        startDestination = EventList
    ) {

        composable<EventList> {

            // Search state belongs to the list destination.
            var query by rememberSaveable {
                mutableStateOf("")
            }

            EventListScreen(
                events = repository.getAllEvents(),
                query = query,
                onQueryChange = { query = it },
                onEventSelected = { eventId ->
                    navController.navigate(
                        EventDetail(eventId = eventId)
                    )
                }
            )
        }

        composable<EventDetail> { backStackEntry ->

            // Extract only the event ID from the route.
            val route = backStackEntry.toRoute<EventDetail>()

            // Retrieve the event using the repository.
            val event = repository.getEventById(route.eventId)

            EventDetailScreen(
                event = event,
                onBack = {
                    navController.popBackStack()
                },
                onShare = {
                    if (event != null) {
                        onShareEvent(event.id)
                    }
                }
            )
        }
    }
}
