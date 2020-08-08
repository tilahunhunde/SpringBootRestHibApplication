package com.spring.dao;

import com.spring.model.User;

public interface UserDao {
	public boolean registerUser(User user);

	public boolean updateUser(User user);

	public User getUserById(int UserId);

	public boolean deleteUser(int UserId);

}
