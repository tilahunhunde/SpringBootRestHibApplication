package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.dao.CategoryDao;
import com.spring.model.Category;

public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDAO;
	
	public CategoryServiceImpl(CategoryDao categoryDAO) {
		super();
		this.categoryDAO = categoryDAO;
	}


	@Override
	public boolean createCategory(Category category) {
		if(categoryDAO.createCategory(category)) 
			return true;
		else
			return false;

	}

	@Override
	public boolean deleteCategory(int id) {
		if(categoryDAO.deleteCategory(id))
			return true;
		else
			return false;
	}

	@Override
	public Category updateCategory(Category category, int id) throws ClassNotFoundException {
		categoryDAO.updateCategory(category);
		Category updatedCategory = getCategoryById(id);
		if(updatedCategory==null)
			throw new ClassNotFoundException("CategoryNotFoundException");
		else
			return category;

	}

	@Override
	public Category getCategoryById(int id) throws ClassNotFoundException {
		Category category = categoryDAO.getByid(id);
		if(category==null)
			throw new ClassNotFoundException("CategoryNotFoundException");
		else
			return category;
	}

	@Override
	public List<Category> getAllCategoryByUserId(String userId) {
		return categoryDAO.getAllCategoryByUserId(userId);
	}

}
