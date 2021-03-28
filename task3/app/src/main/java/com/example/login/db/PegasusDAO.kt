package com.example.login.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

import com.example.login.models.Pegasus

@Dao
interface PegasusDAO {
    @Insert
    fun insert(pegasus: Pegasus)

    @Query("SELECT * FROM pegasus")
    fun getPegasus() : List<Pegasus>

    @Query("DELETE FROM pegasus")
    fun deleteAll()
}