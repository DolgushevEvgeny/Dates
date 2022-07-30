package com.eugene_dolgushev.dates

import android.content.Context
import com.eugene_dolgushev.dates.events.EventRepository
import com.eugene_dolgushev.dates.events.addEvent.AddEventDICompanion
import com.eugene_dolgushev.dates.events.eventList.data.DataSource

object ApplicationDICompanion {

    private lateinit var dataSource: DataSource
    private lateinit var eventRepository: EventRepository

    fun init(context: Context) {
        dataSource = DataSource.Base(context)
        eventRepository = EventRepository(dataSource)

        AddEventDICompanion.init(eventRepository = eventRepository)
    }
}