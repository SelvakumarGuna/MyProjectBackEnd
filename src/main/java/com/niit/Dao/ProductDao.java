package com.niit.Dao;

import java.util.List;

import com.niit.Model.Product;

public interface ProductDao {

	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public List<Product> retrieveProducts();
	public boolean updateProduct(Product product);
	public Product getProduct(int productId);
}
