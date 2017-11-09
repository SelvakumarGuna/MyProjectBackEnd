package com.niit.Dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.niit.Model.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean addCategory(Category category) {
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.save(category);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public List<Category> retrieveCategory() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		@SuppressWarnings("unchecked")
		List<Category> listCategory=query.list();
		session.close();
		return listCategory;
	}

	public boolean deleteCategory(Category category) {
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.delete(category);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);	
		return false;
		}
	}

	public Category getCategory(int catId) {
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,catId);
		session.close();
		return category;
	}

	public boolean updateCategory(Category category) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

}
