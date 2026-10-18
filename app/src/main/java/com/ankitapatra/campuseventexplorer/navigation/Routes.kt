
package com.ankitapatra.campuseventexplorer.navigation

import kotlinx.serialization.Serializable

@Serializable
data object EventList

@Serializable
data class EventDetail(
    val eventId: Long
)
