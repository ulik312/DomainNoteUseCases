package com.sbor.domainnoteusecases.data.mappers

import com.sbor.domainnoteusecases.data.model.NoteEntity
import com.sbor.domainnoteusecases.domain.model.Note

fun Note.toEntity() = NoteEntity(
    id, title, description
)
fun NoteEntity.toNote() = Note(
    id, title, description
)