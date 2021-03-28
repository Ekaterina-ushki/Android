package com.example.login.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.login.models.Pegasus

@Database(entities = arrayOf(Pegasus::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pegasusDAO(): PegasusDAO

    companion object {
        fun createDb(contex: Context) =
            Room.databaseBuilder(contex, AppDatabase::class.java, "login").build()

    }
}
