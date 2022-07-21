package com.eugene_dolgushev.dates.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eugene_dolgushev.dates.notifications.Notification
import com.eugene_dolgushev.dates.room.Event
import com.eugene_dolgushev.dates.room.dao.EventDao
import com.eugene_dolgushev.dates.room.dao.NotificationDao


@Database(
    entities = [Event::class, Notification::class],
    version = 1, exportSchema = true,
)
abstract class DataBase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "events_database.db"
    }

    abstract fun eventDao(): EventDao
    abstract fun notificationDao(): NotificationDao
}