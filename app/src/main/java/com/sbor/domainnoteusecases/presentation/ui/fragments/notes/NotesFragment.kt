package com.sbor.domainnoteusecases.presentation.ui.fragments.notes

import android.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.sbor.domainnoteusecases.R
import com.sbor.domainnoteusecases.databinding.FragmentNotesBinding
import com.sbor.domainnoteusecases.domain.model.Note
import com.sbor.domainnoteusecases.presentation.ui.base.BaseFragment
import com.sbor.domainnoteusecases.presentation.ui.fragments.notes.adapter.NoteAdapter
import com.sbor.domainnoteusecases.presentation.utils.UIState
import com.sbor.domainnoteusecases.presentation.utils.buildAndShow
import com.sbor.domainnoteusecases.presentation.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NotesFragment : BaseFragment(R.layout.fragment_notes) {

    private val viewModel: NotesViewModel by viewModels()
    private val binding by viewBinding(FragmentNotesBinding::bind)
    private val adapterNotes by lazy { NoteAdapter(this::onClick, this::onLongClick) }
    private var title = ""

    override fun initialize() {
        binding.rvHome.adapter = adapterNotes
    }

    override fun setupRequests() {
        viewModel.getAllNotes()
    }

    override fun setupSubscribers() {
        viewModel.getAllNotesState.collectUIState(
            state = {
                binding.progressCircular.isVisible = it is UIState.Loading
            },
            onSuccess = {
                adapterNotes.submitList(it)
            }
        )

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.deleteNotesState.collect { state ->
                    when (state) {
                        is UIState.Loading -> {}
                        is UIState.Success -> {
                            setupRequests()
                        }
                        else -> {}
                    }
                }
            }
        }
    }

    override fun setupListeners() {
        binding.fabHome.setOnClickListener {
            findNavController().navigate(R.id.addEditNotesFragment)
        }
    }

    private fun onClick(note: com.sbor.domainnoteusecases.domain.model.Note) {
        findNavController().navigate(R.id.addEditNotesFragment, bundleOf(EDIT to note))
    }

    private fun onLongClick(note: com.sbor.domainnoteusecases.domain.model.Note) {
        title = note.title
        AlertDialog.Builder(context)
            .setTitle("Are you sure you want to delete $title?")
            .buildAndShow(
                positiveButtonAction = {
                    viewModel.deleteNote(note)
                },
                negativeButtonAction = {}
            )
    }

    companion object {
        const val EDIT = "note"
    }
}