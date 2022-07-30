package com.eugene_dolgushev.dates.events

import com.eugene_dolgushev.dates.events.eventList.data.EventDataSource
import com.eugene_dolgushev.dates.room.Event

class EventRepository(private val eventDataSource: EventDataSource) {

    suspend fun add(event: Event) {
        eventDataSource.eventDao().add(event)
    }

    fun list() = eventDataSource.eventDao().list()
}