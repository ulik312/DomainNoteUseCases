package com.sbor.domainnoteusecases.domain.usecases

import com.sbor.domainnoteusecases.domain.model.Note
import com.sbor.domainnoteusecases.domain.repository.NoteRepository
import javax.inject.Inject

class CreateNoteUseCase @Inject constructor
    (private val noteRepository: NoteRepository
) {

    operator fun invoke(note: Note) = noteRepository.createNote(note)
}