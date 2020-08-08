package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.dao.UserDao;
import com.spring.model.User;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDAO;
	
	public UserServiceImpl() {
		super();
		this.userDAO = userDAO;
	}

	@Override
	public boolean registerUser(User user) throws Exception {
		// TODO Auto-generated method stub
		if(userDAO.registerUser(user)) 
			return true;
		else 
			throw new Exception("UserAlreadyExistException");
	}

	@Override
	public User updateUser(User user, int id) throws Exception {
		// TODO Auto-generated method stub
		userDAO.updateUser(user);
		User newUser = getUserById(id);
		if(newUser==null)
			throw new Exception();
		else 
			return user;
	}

	@Override
	public boolean deleteUser(int UserId) {
		boolean deleteUser = userDAO.deleteUser(UserId);
		if(!deleteUser) {
			return false;
		}else {
			return true;
		}		

	}

	@Override
	public User getUserById(int userId) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		User user = userDAO.getUserById(userId);
		if(user==null)
			throw new ClassNotFoundException("UserNotFoundException");
		else
			return user;
	}

}
