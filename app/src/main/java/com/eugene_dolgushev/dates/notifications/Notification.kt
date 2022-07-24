package com.eugene_dolgushev.dates.notifications

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.eugene_dolgushev.dates.room.Event
import com.eugene_dolgushev.dates.room.converters.DateTypeConverter
import java.util.*

@Entity(
    foreignKeys = [ForeignKey(
        entity = Event::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("eventId"),
        onDelete = ForeignKey.CASCADE
    )]
)
@TypeConverters(DateTypeConverter::class)
data class Notification(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    val date: Date,
    val eventId: Long
) {
}
