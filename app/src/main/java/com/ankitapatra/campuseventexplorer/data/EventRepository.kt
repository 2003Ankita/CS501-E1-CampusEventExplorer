
package com.ankitapatra.campuseventexplorer.data

import com.ankitapatra.campuseventexplorer.model.CampusEvent

interface EventRepository {

    // Retrieve all available campus events
    fun getAllEvents(): List<CampusEvent>

    // Find a specific event using its unique ID
    fun getEventById(id: Long): CampusEvent?
}
