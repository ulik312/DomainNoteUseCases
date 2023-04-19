package com.sbor.domainnoteusecases.domain.repository

import com.sbor.domainnoteusecases.domain.model.Note
import com.sbor.domainnoteusecases.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun createNote(note: Note): Flow<Resource<Unit>>

    fun getAllNotes(): Flow<Resource<List<Note>>>

    fun editNote(note: Note): Flow<Resource<Unit>>

    fun delete(note: Note): Flow<Resource<Unit>>
}
