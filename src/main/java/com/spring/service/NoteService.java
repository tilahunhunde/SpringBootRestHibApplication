package com.spring.service;

import java.util.List;

import com.spring.model.Note;

public interface NoteService {
	public boolean createNote(Note note) throws ClassNotFoundException;

	public boolean deleteNote(int noteId);

	public List<Note> getAllNotesByUserId(String userId);

	public Note getNoteById(int noteId) throws ClassNotFoundException;

	public Note updateNote(Note note, int id)
			throws ClassNotFoundException;
}
