package com.eugene_dolgushev.dates.room.dao

import androidx.room.Dao
import androidx.room.Insert
import com.eugene_dolgushev.dates.notifications.Notification

@Dao
interface NotificationDao {

    @Insert
    suspend fun insert(notification: Notification)
}