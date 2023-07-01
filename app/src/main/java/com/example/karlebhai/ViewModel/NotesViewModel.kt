package com.example.karlebhai.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.karlebhai.Database.NotesDatabse
import com.example.karlebhai.Models.Notes
import com.example.karlebhai.Repository.NotesRepository

class NotesViewModel(application: Application):AndroidViewModel(application) {
    val repository:NotesRepository
    init {
        val dao = NotesDatabse.getDatabaseInstance(application).myNotesDatabse()
        repository = NotesRepository(dao)
    }

    suspend fun addNotes(notes: Notes) = repository.insertNotes(notes)


    fun getNotes():LiveData<List<Notes>> = repository.getAllNotes()

    fun getLowNotes():LiveData<List<Notes>> = repository.getLowNotes()
    fun getHighNotes():LiveData<List<Notes>> = repository.getHighNotes()
    fun getMediumNotes():LiveData<List<Notes>> = repository.getMediumNotes()

    suspend fun deleteNote(id:Int) = repository.deleteNotes(id)

    suspend fun updateNotes(notes:Notes) = repository.updateNotes(notes)

}