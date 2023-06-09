package com.sbor.domainnoteusecases.presentation.ui.fragments.notes

import com.sbor.domainnoteusecases.domain.model.Note
import com.sbor.domainnoteusecases.domain.usecases.DeleteUseCase
import com.sbor.domainnoteusecases.domain.usecases.GetAllNotesUseCase
import com.sbor.domainnoteusecases.presentation.ui.base.BaseViewModel
import com.sbor.domainnoteusecases.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getAllNotesUseCase: com.sbor.domainnoteusecases.domain.usecases.GetAllNotesUseCase,
    private val deleteUseCase: com.sbor.domainnoteusecases.domain.usecases.DeleteUseCase,
) : BaseViewModel() {

    private val _getAllNotesState = MutableStateFlow<UIState<List<com.sbor.domainnoteusecases.domain.model.Note>>>(UIState.Empty())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    private val _deleteNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteNotesState = _deleteNoteState.asStateFlow()

    fun deleteNote(note: com.sbor.domainnoteusecases.domain.model.Note) {
        deleteUseCase(note).collectData(_deleteNoteState)
    }

    fun getAllNotes() {
        getAllNotesUseCase().collectData(_getAllNotesState)
    }
}