package com.spring.service;

import java.util.List;

import com.spring.model.Category;

public interface CategoryService {
	public boolean createCategory(Category category);

	public boolean deleteCategory(int noteId);

	public Category updateCategory(Category category, int id) throws ClassNotFoundException;

	public Category getCategoryById(int id) throws ClassNotFoundException;

	public List<Category> getAllCategoryByUserId(String userId);

}
