package com.spring.dao;

import java.util.List;

import com.spring.model.Category;

public interface CategoryDao {
	public boolean createCategory(Category category);

	public boolean deleteCategory(int noteId);

	public boolean updateCategory(Category category);
	public List<Category> getAllCategoryByUserId(String userId);
	public Category getByid(int id) throws ClassNotFoundException;

}
