package com.spring.dao;

import java.util.List;

import com.spring.model.Note;

public interface NoteDao {
	public boolean createNote(Note note);

	public boolean deleteNote(int noteId);

	public List<Note> getAllNotesByUserId(String userId);

	public Note getNoteById(int noteId) throws ClassNotFoundException;

	public boolean UpdateNote(Note note);
}
