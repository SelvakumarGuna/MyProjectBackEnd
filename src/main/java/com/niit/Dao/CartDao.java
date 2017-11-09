package com.niit.Dao;

import java.util.List;

import com.niit.Model.Cart;

public interface CartDao 
{
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public Cart getCartItem(int cartitemId); //Single CartItem
	public List<Cart> getCartItems(String username); //Multiple 
}