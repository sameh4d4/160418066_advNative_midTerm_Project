package com.example.advnative_project_uts_160418066.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Departemen::class), version =  3)
abstract class DepartementDatabase: RoomDatabase() {
    abstract fun departemenDao(): DepartemenDao

    companion object {
        @Volatile private var instance: DepartementDatabase?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            DepartementDatabase::class.java, "newdepartementdb")
            .addMigrations()
            .build()

        operator fun invoke(context: Context) {
            if(instance!=null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }

    }
}