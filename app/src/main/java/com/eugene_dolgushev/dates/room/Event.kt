package com.eugene_dolgushev.dates.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Event(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    val title: String,
    val description: String = ""
) {
}