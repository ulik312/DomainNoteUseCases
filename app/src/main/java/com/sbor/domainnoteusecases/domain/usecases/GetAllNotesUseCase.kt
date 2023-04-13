package com.sbor.domainnoteusecases.domain.usecases

import com.sbor.domainnoteusecases.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    operator fun invoke() = noteRepository.getAllNotes()
}