package com.niit.Dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.Model.Cart;

@Repository("cartDAO")

public class CartDaoImpl implements CartDao {
	@Autowired
	SessionFactory sessionFactory;

	public CartDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public boolean addCart(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	public boolean updateCart(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;	
		}

	}

	public boolean deleteCart(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;	
		}
	}

	public Cart getCartItem(int cartitemId) {
		Session session=sessionFactory.openSession();
		Cart cart=(Cart)session.get(Cart.class,cartitemId);
		session.close();
		return cart;
	}

	public List<Cart> getCartItems(String username) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart where username=:username and status='NP'");
		query.setParameter("username",username);
		@SuppressWarnings("unchecked")
		List<Cart> listCartItem=query.list();
		session.close();
		return listCartItem;
	}

}
