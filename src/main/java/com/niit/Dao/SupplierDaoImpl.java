package com.niit.Dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import com.niit.Model.Category;
import com.niit.Model.Supplier;

public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addSupplier(Supplier supplier) {
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.save(supplier);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean deleteSupplier(Supplier supplier) {
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.delete(supplier);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);	
		return false;
		}
	}

	public List<Supplier> retrieveSupplier() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier=query.list();
		session.close();
		return listSupplier;
	}

	public boolean updateSupplier(Supplier supplier) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	public Supplier getSupplier(int supplierId) {
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Category.class,supplierId);
		session.close();
		return supplier;
	}

}
