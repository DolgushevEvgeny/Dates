package com.eugene_dolgushev.dates.events.addEvent.domain

import com.eugene_dolgushev.dates.Result
import com.eugene_dolgushev.dates.events.EventRepository
import com.eugene_dolgushev.dates.room.Event

class CreateEventUseCase(private val eventRepository: EventRepository) {

    suspend fun execute(title: String, description: String) = when {
        title.isBlank() -> {
            Result.Error("Пустое название события")
        }
        title.length < TITLE_MIN_LENGTH -> {
            Result.Error("Название события должно быть длиннее чем 8 символов")
        }
        else -> {
            eventRepository.add(Event(title = title, description = description))
            Result.Success
        }
    }

    companion object {
        private const val TITLE_MIN_LENGTH = 8
    }
}