package com.niit.BackEndTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.ProductDao;
import com.niit.Model.Product;

public class ProductTest {
	static ProductDao productDAO;
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit");
		configApplnContext.refresh();
		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		
		productDAO=(ProductDao)configApplnContext.getBean("productDao");
	}
	
	@Test
	public void addproductTest()
	{
		Product product=new Product();
		product.setProductId(102);
		product.setProductName("Desktop");
		product.setProductDesc("all kinds of desktops ");
		product.setCatId(1001);
		product.setPrice(10000);
		product.setStock(20);
		product.setSupplierId(123);
		
		assertTrue(productDAO.addProduct(product));
	}
	
	@Ignore
	@Test
	public void updateproductTest()
	{
		Product product=new Product();
		product.setProductId(1002);
		product.setProductName("JMShirt");
		product.setProductDesc("John Miller Shirt with Best Price");
		product.setCatId(1002);
		product.setPrice(20000);
		product.setStock(10);
		product.setSupplierId(124);
		
		assertTrue(productDAO.updateProduct(product));
	}
	@Ignore
	@Test
	public void deleteproductTest()
	{
		Product product=new Product();
		product.setProductId(1002);
		assertTrue(productDAO.deleteProduct(product));
	}
	@Ignore
	@Test
	public void retrieveproductTest()
	{
		List<Product> listproduct=productDAO.retrieveProducts();
		assertNotNull("Problem in Retriving ",listproduct);
		this.show(listproduct);
	}
	
	@Ignore
	@Test
	public void show(List<Product> listproduct)
	{
		for(Product product:listproduct)
		{
			System.out.println("Supplier ID:"+product.getSupplierId());
			System.out.println("Category ID:"+product.getCatId());
			System.out.println("product ID:"+product.getProductId());
			System.out.println("product Name:"+product.getProductName());
			System.out.println("price:"+product.getPrice());
			System.out.println("Stock:"+product.getStock());
			System.out.println("Product Descprition"+product.getProductDesc());
		}
	}
	
	@Ignore
	@Test
	public void getproductTest()
	{
		Product product=productDAO.getProduct(101);
		assertNotNull("Problem in Getting:",product);
		System.out.println("Supplier ID:"+product.getSupplierId());
		System.out.println("Category ID:"+product.getCatId());
		System.out.println("product ID:"+product.getProductId());
		System.out.println("product Name:"+product.getProductName());
		System.out.println("price:"+product.getPrice());
		System.out.println("Stock:"+product.getStock());
		System.out.println("Product Descprition"+product.getProductDesc());
	}

}
