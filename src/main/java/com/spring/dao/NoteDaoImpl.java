package com.spring.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.model.Note;

public class NoteDaoImpl implements NoteDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean createNote(Note note) {
		Session session =sessionFactory.getCurrentSession();
		session.save(note);
		session.flush();
		return true;
	}

	@Override
	public boolean deleteNote(int noteId) {
		boolean flag = true;
		try {
			if(getNoteById(noteId)==null) {
				flag = false;
			}else {
				Session session = sessionFactory.getCurrentSession();
				session.delete(getNoteById(noteId));
				session.flush();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return flag;
		
	}

	@Override
	public List<Note> getAllNotesByUserId(String userId) {
		String hql = "FROM Note note where createdBy =  :userId ";
        Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("userId", userId);
		List result = query.getResultList();
		return result;

	}

	@Override
	public Note getNoteById(int noteId) throws ClassNotFoundException {
		Session session = sessionFactory.getCurrentSession();
		Note note =session.get(Note.class, noteId);
		if(note==null)
			throw new ClassNotFoundException("NoteNotFoundException");
		else {
			session.flush();
			return note;
		}
	}

	@Override
	public boolean UpdateNote(Note note) {
		boolean flag=true;
		try {
			if(getNoteById(note.getId())==null) {
				flag=false;
			}else {
				sessionFactory.getCurrentSession().clear();
				sessionFactory.getCurrentSession().update(note);
				sessionFactory.getCurrentSession().flush();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return flag;
	}
	}


