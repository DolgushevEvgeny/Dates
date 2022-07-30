package com.eugene_dolgushev.dates.events.addEvent

import com.eugene_dolgushev.dates.events.EventRepository
import com.eugene_dolgushev.dates.events.addEvent.domain.CreateEventUseCase

object AddEventDICompanion {

    val createEventUseCaseProvider = { createEventUseCase }

    private lateinit var createEventUseCase: CreateEventUseCase

    fun init(
        eventRepository: EventRepository
    ) {
        createEventUseCase = CreateEventUseCase(eventRepository)
    }
}