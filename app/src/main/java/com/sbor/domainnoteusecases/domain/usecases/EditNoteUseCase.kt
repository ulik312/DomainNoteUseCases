package com.sbor.domainnoteusecases.domain.usecases

import com.sbor.domainnoteusecases.domain.model.Note
import com.sbor.domainnoteusecases.domain.repository.NoteRepository

class EditNoteUseCase(private val noteRepository: NoteRepository) {
    fun editNote(note: Note) = noteRepository.editNote(note)
}