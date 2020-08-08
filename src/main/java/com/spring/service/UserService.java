package com.spring.service;

import com.spring.model.User;

public interface UserService {
	public boolean registerUser(User user) throws Exception; 

	public User updateUser(User user, int id) throws Exception;

	public boolean deleteUser(int UserId);

	public User getUserById(int userId) throws ClassNotFoundException;

}
