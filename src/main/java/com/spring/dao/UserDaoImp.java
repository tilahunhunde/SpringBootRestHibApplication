package com.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.model.User;

public class UserDaoImp implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean registerUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		session.flush();
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		if(getUserById(user.getUserId())==null) {
			return false;
		}else {
		sessionFactory.getCurrentSession().clear();
		sessionFactory.getCurrentSession().update(user);
		sessionFactory.getCurrentSession().flush();
		return true;
		}
	}


	@Override
	public boolean deleteUser(int UserId) {
		if(getUserById(UserId)==null) {
			return false;
		}else {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getUserById(UserId));
		session.flush();
		return true;
		}

	}

	@Override
	public User getUserById(int UserId) {
		Session session = sessionFactory.getCurrentSession();
		User user =session.get(User.class, UserId);
		session.flush();
		return user;
	}

}
