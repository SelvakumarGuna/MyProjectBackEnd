package com.niit.BackEndTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.CartDao;
import com.niit.Model.Cart;

public class CartTest {
	
static CartDao cartDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit");
		annotationConfigAppContext.refresh();
		
		cartDAO=(CartDao)annotationConfigAppContext.getBean("cart");
	}
	
	@Ignore
	@Test
	public void addCartTest()
	{
		Cart cart=new Cart();
		cart.setCartItemId(1);
		cart.setOrderId(1002);
		cart.setProductId(1004);
		cart.setQuantity(3);
		cart.setPrice(550);
		cart.setUsername("Vinod");
		cart.setStatus("NP");
		
		assertTrue("Problem in Adding CartItem",cartDAO.addCart(cart));
	}
	
	@Ignore
	@Test 
	public void updateCartTest()
	{
		Cart cart=new Cart();
		cart.setCartItemId(2);
		cart.setOrderId(1001);
		cart.setProductId(1002);
		cart.setQuantity(5);
		cart.setPrice(1500);
		cart.setUsername("Gagan");
		cart.setStatus("NP");
		assertTrue("Problem in Updating CartItem",cartDAO.updateCart(cart));
	}
	@Ignore
	@Test
	public void deleteCartTest()
	{
		Cart cart=new Cart();
		cart.setCartItemId(2);
		cart.setOrderId(1001);
		cart.setProductId(1002);
		cart.setQuantity(5);
		cart.setPrice(1500);
		cart.setUsername("Gagan");
		cart.setStatus("NP");
		
		assertTrue("Problem in Deletion CartItem",cartDAO.deleteCart(cart));
	}
	@Ignore
	@Test
	public void getCartItemsTest()
	{
		String username="Gagan";
		List<Cart> listCartItems=cartDAO.getCartItems(username);
		assertNotNull("Problem in Listing CartItem",listCartItems);
		this.showCartItem(listCartItems);
	}
	
	public void showCartItem(List<Cart> listCartItem)
	{
		for(Cart cart:listCartItem)
		{
			System.out.println("Order Id:"+cart.getOrderId());
			System.out.println("Product Id :"+cart.getProductId());
		}
	}

}
