package com.sbor.domainnoteusecases.domain.usecases

import com.sbor.domainnoteusecases.domain.model.Note
import com.sbor.domainnoteusecases.domain.repository.NoteRepository

class DeleteNoteUseCase(private val noteRepository: NoteRepository) {
    fun deleteNote(note: Note) = noteRepository.deleteNote(note)
}