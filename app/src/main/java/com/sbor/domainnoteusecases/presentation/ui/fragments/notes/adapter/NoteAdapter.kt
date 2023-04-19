package com.sbor.domainnoteusecases.presentation.ui.fragments.notes.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sbor.domainnoteusecases.databinding.ItemNotesBinding
import com.sbor.domainnoteusecases.domain.model.Note

class NoteAdapter(
    private var onClick: (com.sbor.domainnoteusecases.domain.model.Note) -> Unit,
    private var onLongClick: (com.sbor.domainnoteusecases.domain.model.Note) -> Unit,
) : ListAdapter<com.sbor.domainnoteusecases.domain.model.Note, NoteAdapter.NoteViewHolder>(DiffUtilNoteItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class NoteViewHolder(private val binding: ItemNotesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(note: com.sbor.domainnoteusecases.domain.model.Note) {
            binding.tvTitle.text = note.title
            binding.tvDesc.text = note.descriptions
            itemView.setOnClickListener {
                onClick(note)
            }
            itemView.setOnLongClickListener {
                onLongClick(note)
                return@setOnLongClickListener true
            }
        }
    }

    private class DiffUtilNoteItemCallback : DiffUtil.ItemCallback<com.sbor.domainnoteusecases.domain.model.Note>() {
        override fun areItemsTheSame(oldItem: com.sbor.domainnoteusecases.domain.model.Note, newItem: com.sbor.domainnoteusecases.domain.model.Note): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: com.sbor.domainnoteusecases.domain.model.Note, newItem: com.sbor.domainnoteusecases.domain.model.Note): Boolean {
            return oldItem == newItem
        }
    }
}
