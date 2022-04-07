package com.althaafridha.noteapp.data

import androidx.lifecycle.LiveData
import com.althaafridha.noteapp.data.local.entity.Notes
import com.althaafridha.noteapp.data.local.room.NotesDao

class NotesRepository(private val notesDao: NotesDao){

	val getAllNote: LiveData<List<Notes>> = notesDao.getAllNote()

	val sortByHighPriority: LiveData<List<Notes>> = notesDao.sortByHighPriority()
	val sortByLowPriority: LiveData<List<Notes>> = notesDao.sortByLowPriority()

	suspend fun insertNotes(notes: Notes) {
		notesDao.addNote(notes)
	}

	fun searchNoteByQuery(query: String): LiveData<List<Notes>> {
		return notesDao.searchNoteByQuery(query)
	}

	suspend fun updateNote(notes: Notes){
		return notesDao.updateNote(notes)
	}

	suspend fun deleteAllData(){
		notesDao.deleteAllData()
	}

	suspend fun deleteNote(notes: Notes){
		notesDao.deleteNote(notes)
	}
}