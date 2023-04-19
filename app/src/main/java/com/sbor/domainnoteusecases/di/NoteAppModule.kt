package com.sbor.domainnoteusecases.di

import android.content.Context
import androidx.room.Room
import com.sbor.domainnoteusecases.data.local.NoteDao
import com.sbor.domainnoteusecases.data.model.NoteDatabase
import com.sbor.domainnoteusecases.data.repository.NoteRepositoryImpl
import com.sbor.domainnoteusecases.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object NoteAppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(
        context,
        com.sbor.domainnoteusecases.data.model.NoteDatabase::class.java,
        "note_db"
    ).allowMainThreadQueries().build()

    @Provides
    fun provideNoteDao(noteDatabase: com.sbor.domainnoteusecases.data.model.NoteDatabase) = noteDatabase.noteDao()

    @Provides
    fun provideNoteRepository(noteDao: com.sbor.domainnoteusecases.data.local.NoteDao): com.sbor.domainnoteusecases.domain.repository.NoteRepository {
        return com.sbor.domainnoteusecases.data.repository.NoteRepositoryImpl(noteDao)
    }
}