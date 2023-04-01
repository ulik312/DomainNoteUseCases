package com.sbor.domainnoteusecases.data.repository

import com.sbor.domainnoteusecases.data.local.NoteDao
import com.sbor.domainnoteusecases.data.mappers.toEntity
import com.sbor.domainnoteusecases.data.mappers.toNote
import com.sbor.domainnoteusecases.domain.model.Note
import com.sbor.domainnoteusecases.domain.repository.NoteRepository

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {
    override fun createNote(note: Note) {
        noteDao.createNotes(note.toEntity())

    }

    override fun getAllNotes(): List<Note> {
        return noteDao.getAllNotes().map { it.toNote() }
    }

    override fun editNote(note: Note) {
        noteDao.editNotes(note.toEntity())

    }

    override fun deleteNote(note: Note) {
        noteDao.deleteNotes(note.toEntity())
    }

}