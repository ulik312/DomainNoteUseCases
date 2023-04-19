package com.sbor.domainnoteusecases.data.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sbor.domainnoteusecases.data.local.NoteDao

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase: RoomDatabase(){

    abstract fun noteDao(): NoteDao
}