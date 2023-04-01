package com.sbor.domainnoteusecases.data.local

import androidx.room.*
import com.sbor.domainnoteusecases.data.model.NoteEntity


@Dao
interface NoteDao {
    //CRUD
    //C - create
    //R - read
    //U - update
    //D - delete
    @Insert
    suspend fun createNotes(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
    suspend fun getAllNotes(): List<NoteEntity>

    @Update
    suspend fun editNotes(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNotes(noteEntity: NoteEntity)
}