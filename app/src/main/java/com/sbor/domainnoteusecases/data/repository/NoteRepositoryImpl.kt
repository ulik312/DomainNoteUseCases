package com.sbor.domainnoteusecases.data.repository

import com.sbor.domainnoteusecases.data.base.BaseRepository
import com.sbor.domainnoteusecases.data.local.NoteDao
import com.sbor.domainnoteusecases.data.mappers.toEntity
import com.sbor.domainnoteusecases.data.mappers.toNote
import com.sbor.domainnoteusecases.domain.model.Note
import com.sbor.domainnoteusecases.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao) : NoteRepository,
    BaseRepository() {

    override fun createNote(note: Note) = doRequest {
        noteDao.createNotes(note.toEntity())
    }


    override fun getAllNotes() = doRequest {
        noteDao.getAllNotes().map { it.toNote() }
    }

    override fun editNote(note: Note) = doRequest{
        noteDao.editNotes(note.toEntity())

    }

    override fun deleteNote(note: Note) = doRequest {
        noteDao.deleteNotes(note.toEntity())
    }

}