package com.eugene_dolgushev.dates.room.converters

import androidx.room.TypeConverter
import java.util.*

object DateTypeConverter {

    @TypeConverter
    @JvmStatic
    fun fromTimestampToDate(value: Long?): Date? = if (value == null) null else Date(value)

    @TypeConverter
    @JvmStatic
    fun fromDateToTimestamp(date: Date?): Long? = date?.time
}