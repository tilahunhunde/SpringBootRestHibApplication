package com.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.model.Category;

public class CategoryDaoImpl implements CategoryDao {


	/*
	 * Create a new category
	 */

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean createCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.save(category);
		session.flush();
		return true;

	}


	@Override
	public boolean deleteCategory(int id) {
		boolean flag = true;
		try {
			if(getByid(id)==null) {
				flag = false;
			}else {
				Session session = sessionFactory.getCurrentSession();
				session.delete(getByid(id));
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
	public boolean updateCategory(Category category) {
		boolean flag = true;
		try {
			if(getByid(category.getId())==null) {
				flag = false;
			}else {
				sessionFactory.getCurrentSession().clear();
				sessionFactory.getCurrentSession().update(category);
				sessionFactory.getCurrentSession().flush();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return flag;
	}
	

	@Override
	public List<Category> getAllCategoryByUserId(String userId) {
		String hql = "From Category category where categoryCreatedBy = :userId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("userId", userId);
		List result = query.getResultList();
		return result;
	}


	@Override
	public Category getByid(int id) throws ClassNotFoundException {
		Session session = sessionFactory.getCurrentSession();
		Category category = session.get(Category.class, id);
		if(category==null)
			throw new ClassNotFoundException("CategoryNotFoundException");
		else {
			session.flush();
			return category;
	}


	


}
}
