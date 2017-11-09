package com.niit.BackEndTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.SupplierDao;
import com.niit.Model.Supplier;

public class SupplierTest {
	
	static SupplierDao SupplierDAO;
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit");
		configApplnContext.refresh();
		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		
		SupplierDAO=(SupplierDao)configApplnContext.getBean("SupplierDao");
	}
	
	@Ignore
	@Test
	public void addSupplierTest()
	{
		Supplier Supplier=new Supplier();
		Supplier.setSupplierId(102);
		Supplier.setSupplierName("Rockstar");
		Supplier.setSupplierAddress("11D,Anand Apartments,Rajaji Street,Guduvancherry");
		
		assertTrue(SupplierDAO.addSupplier(Supplier));
	}
	
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier Supplier=new Supplier();
		Supplier.setSupplierId(102);
		Supplier.setSupplierName("Gta");
		Supplier.setSupplierAddress("97D,Cuddalore main road,Bhuvanagiri,TN");
		
		assertTrue(SupplierDAO.updateSupplier(Supplier));
	}
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier Supplier=new Supplier();
		Supplier.setSupplierId(1002);
		assertTrue(SupplierDAO.deleteSupplier(Supplier));
	}
	@Ignore
	@Test
	public void retrieveSupplierTest()
	{
		List<Supplier> listSupplier=SupplierDAO.retrieveSupplier();
		assertNotNull("Problem in Retriving ",listSupplier);
		this.show(listSupplier);
	}
	
	@Ignore
	@Test
	public void show(List<Supplier> listSupplier)
	{
		for(Supplier Supplier:listSupplier)
		{
			System.out.println("Supplier ID:"+Supplier.getSupplierId());
			System.out.println("Supplier Name:"+Supplier.getSupplierName());
		}
	}
	
	@Ignore
	@Test
	public void getSupplierTest()
	{
		Supplier Supplier=SupplierDAO.getSupplier(101);
		assertNotNull("Problem in Getting:",Supplier);
		System.out.println("Supplier ID:"+Supplier.getSupplierId());
		System.out.println("Supplier Name:"+Supplier.getSupplierName());
		System.out.println("Supplier Description  = "+Supplier.getSupplierAddress());
	}
}
