package com.eugene_dolgushev.dates.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.eugene_dolgushev.dates.room.Event

@Dao
interface EventDao {

    @Insert
    suspend fun insert(event: Event)

    @Query("Select * from Event")
    fun list(): LiveData<List<Event>>
}