package com.eugene_dolgushev.dates.room.dao

import androidx.room.Dao
import androidx.room.Insert
import com.eugene_dolgushev.dates.room.Event

@Dao
interface EventDao {

    @Insert
    suspend fun insert(event: Event)
}