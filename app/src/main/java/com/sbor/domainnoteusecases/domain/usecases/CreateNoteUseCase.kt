package com.sbor.domainnoteusecases.domain.usecases

import com.sbor.domainnoteusecases.domain.model.Note
import com.sbor.domainnoteusecases.domain.repository.NoteRepository

class CreateNoteUseCase(private val noteRepository: NoteRepository) {
    fun createNote(note:Note) = noteRepository.createNote(note)
}