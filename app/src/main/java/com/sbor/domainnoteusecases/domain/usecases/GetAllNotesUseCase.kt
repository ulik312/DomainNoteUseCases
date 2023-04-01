package com.sbor.domainnoteusecases.domain.usecases

import com.sbor.domainnoteusecases.domain.model.Note
import com.sbor.domainnoteusecases.domain.repository.NoteRepository

class GetAllNotesUseCase(private val noteRepository: NoteRepository) {
    fun getAllNotes(): List<Note> = noteRepository.getAllNotes()
}