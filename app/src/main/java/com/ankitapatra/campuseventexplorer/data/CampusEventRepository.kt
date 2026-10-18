
package com.ankitapatra.campuseventexplorer.data

import com.ankitapatra.campuseventexplorer.model.CampusEvent

class CampusEventRepository : EventRepository {

    private val events: List<CampusEvent> = SampleEvents.events

    override fun getAllEvents(): List<CampusEvent> {
        return events
    }

    override fun getEventById(id: Long): CampusEvent? {
        return events.firstOrNull { event ->
            event.id == id
        }
    }
}
