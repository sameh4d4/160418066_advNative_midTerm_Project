package com.example.advnative_project_uts_160418066.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Dokter::class), version =  1)
abstract class DokterDatabase :RoomDatabase(){
    abstract fun dokterDao():DokterDao

    companion object{
        @Volatile private var instance: DokterDatabase?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            DokterDatabase::class.java, "newdokterdb")
            .addMigrations()
            .build()

        operator fun invoke(context: Context) {
            if(instance !=null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }
    }
}