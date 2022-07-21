package com.eugene_dolgushev.dates.notifications

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.eugene_dolgushev.dates.room.Event
import com.eugene_dolgushev.dates.room.converters.DateTypeConverter
import java.util.*

@Entity(
    tableName = "notifications",
    foreignKeys = [ForeignKey(
        entity = Event::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("eventId"),
        onDelete = ForeignKey.CASCADE
    )]
)
@TypeConverters(DateTypeConverter::class)
data class Notification(val date: Date, val eventId: Long) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
