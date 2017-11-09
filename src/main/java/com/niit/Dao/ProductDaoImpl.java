package com.niit.Dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.niit.Model.Product;

public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean deleteProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public List<Product> retrieveProducts() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		@SuppressWarnings("unchecked")
		List<Product> listProducts=query.list();
		session.close();
		return listProducts;
	}

	public boolean updateProduct(Product product) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}
	public Product getProduct(int productId) {
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productId);
		session.close();
		return product;
	}

}
