package com.sbor.domainnoteusecases.di

import android.content.Context
import androidx.room.Room
import com.sbor.domainnoteusecases.data.local.NoteDao
import com.sbor.domainnoteusecases.data.local.NoteDataBase
import com.sbor.domainnoteusecases.data.repository.NoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NoteAppModule {
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context)= Room.databaseBuilder(context, NoteDataBase::class.java,"note_db"
    )
    @Provides
    fun provideNoteDao(noteDataBase: NoteDataBase) = noteDataBase.noteDao()
    @Provides
    fun provideNoteRepository(noteDao: NoteDao):NoteRepositoryImpl{
        return NoteRepositoryImpl(noteDao)
    }
}