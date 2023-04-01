package com.sbor.domainnoteusecases.domain.repository

import com.sbor.domainnoteusecases.domain.model.Note

interface NoteRepository {
    fun createNote(note: Note)
    fun getAllNotes(): List<Note>
    fun editNote(note: Note)
    fun deleteNote(note: Note)

}