package com.althaafridha.noteapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.althaafridha.noteapp.data.NotesRepository
import com.althaafridha.noteapp.data.local.entity.Notes
import com.althaafridha.noteapp.data.local.room.NotesDao
import com.althaafridha.noteapp.data.local.room.NotesDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application): AndroidViewModel(application) {
	private val notesDao: NotesDao = NotesDatabase.getDatabase(application).notesDao()
	private val notesRepository: NotesRepository = NotesRepository(notesDao)

	val sortByHighPriority: LiveData<List<Notes>> = notesRepository.sortByHighPriority
	val sortByLowPriority: LiveData<List<Notes>> = notesRepository.sortByLowPriority

	fun getAllNote() : LiveData<List<Notes>> = notesRepository.getAllNote

	fun insertNotes(notes: Notes){
		viewModelScope.launch(Dispatchers.IO) {
			notesRepository.insertNotes(notes)
		}
	}

	fun searchNotesByQuery(query: String) : LiveData<List<Notes>> {
		return notesRepository.searchNoteByQuery(query)
	}

	fun updateNote(notes: Notes){
		viewModelScope.launch {
			notesRepository.updateNote(notes)
		}
	}

	fun deleteAllData() {
		viewModelScope.launch(Dispatchers.IO){
			notesRepository.deleteAllData()
		}
	}

	fun deleteNote(notes: Notes){
		viewModelScope.launch(Dispatchers.IO) {
			notesRepository.deleteNote(notes)
		}
	}
}