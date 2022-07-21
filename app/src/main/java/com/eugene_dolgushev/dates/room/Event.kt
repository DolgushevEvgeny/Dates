package com.eugene_dolgushev.dates.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class Event(val title: String, val description: String = "") {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}