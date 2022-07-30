package com.eugene_dolgushev.dates.events.eventList.data

import android.content.Context
import androidx.room.Room
import com.eugene_dolgushev.dates.room.dao.EventDao
import com.eugene_dolgushev.dates.room.dao.NotificationDao
import com.eugene_dolgushev.dates.room.database.DataBase
import com.eugene_dolgushev.dates.room.database.DataBase.Companion.DATABASE_NAME

interface DataSource : NotificationDataSource, EventDataSource {

    abstract class Abstract(context: Context, databaseName: String) : DataSource {

        @Volatile
        private var room: DataBase = Room.databaseBuilder(
            context,
            DataBase::class.java,
            databaseName
        ).build()

        @Synchronized
        override fun notificationDao() = synchronized(this) {
            room.notificationDao()
        }

        @Synchronized
        override fun eventDao() = synchronized(this) {
            room.eventDao()
        }
    }

    class Base(context: Context) : Abstract(context, DATABASE_NAME)
}

interface NotificationDataSource {
    fun notificationDao(): NotificationDao
}

interface EventDataSource {
    fun eventDao(): EventDao
}