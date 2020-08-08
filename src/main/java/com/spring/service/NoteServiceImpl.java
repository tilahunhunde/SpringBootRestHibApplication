package com.spring.service;

import java.util.List;

import com.spring.dao.CategoryDao;
import com.spring.dao.NoteDao;
import com.spring.model.Category;
import com.spring.model.Note;

public class NoteServiceImpl implements NoteService {
	private NoteDao noteDAO;
	private CategoryDao categoryDAO;
	

	public NoteServiceImpl(NoteDao noteDAO, CategoryDao categoryDAO) {
		super();
		this.noteDAO = noteDAO;
		this.categoryDAO = categoryDAO;
	}

	@Override
	public boolean createNote(Note note) throws ClassNotFoundException {
		Category category = note.getCategory();
		try {
			if(category!=null)
				categoryDAO.getByid(category.getId());
		}catch(ClassNotFoundException cnf) {
			throw new  ClassNotFoundException("CategoryNotFoundException");
		}
		
		return noteDAO.createNote(note);
		
	}

	@Override
	public boolean deleteNote(int noteId) {
		boolean deletedNote = noteDAO.deleteNote(noteId);
		if(!deletedNote)
			return false;
		else
			return true;
	}

	@Override
	public List<Note> getAllNotesByUserId(String userId) {
		return noteDAO.getAllNotesByUserId(userId);
	}

	@Override
	public Note getNoteById(int noteId) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Note note = noteDAO.getNoteById(noteId);
		if(note==null)
			throw new ClassNotFoundException("NoteNotFoundException");
		else
		return note;
	}

	@Override
	public Note updateNote(Note note, int id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Note noteFound = noteDAO.getNoteById(id);
		Category category = note.getCategory();
		if(noteFound==null) {
			throw new ClassNotFoundException("NoteNotFoundException");
		}else {
			noteDAO.UpdateNote(noteFound);
		}
		try {
			if(category!=null)
				categoryDAO.getByid(category.getId());
		}catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		
		return note;

	}

}
