package com.cg.onlineshop.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cg.onlineshop.daos.ProductDAO;
import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;
import com.cg.onlineshop.exceptions.ProductServiceDownException;
import com.cg.onlineshop.pojos.Product;
import com.cg.onlineshop.services.ProductService;
import com.cg.onlineshop.services.ProductServiceImpl;

public class MainClass {
	public static void main(String[] args) {
		try {

			//name the folder holding onlineShopbeans.xml to resources
			@SuppressWarnings("resources") 
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("onlineShopBeans.xml");
			ProductService productService = applicationContext.getBean(ProductService.class,"productService");
			
			//save product
			Product product = productService.acceptProductDetails(new Product( 15000, 1, "Good Product", "ABC"));
			System.out.println("inserted product :- "+product);
			System.out.println(product.getId());
			
			Product product2 = productService.acceptProductDetails(new Product(29000, 1, "Okay Product", "DEF"));
			System.out.println("inserted product :- "+product2);
			System.out.println(product2.getId());
			
			//search 
			product = productService.getProductDetails(1);
			System.out.println("Searched Product :- "+product);
			
			//update
			Product product3 = new Product(2,30000,1,"Okay Product","GHI");
			Product t = productService.acceptProductDetails(product3);
			System.out.println("updated product " + t);
			
			//update
			Product product4 = productService.acceptProductDetails(new Product(1, 15000, 5, "THE WORST!!", "ABC"));
			System.out.println("updated product :- "+product4);
			System.out.println(product4.getId());
			
			//save
			Product product5 = productService.acceptProductDetails(new Product(22, 2, "Great Product", "ABC"));
			System.out.println("saved product :- "+product5);
			System.out.println(product5.getId());
			
			//create - expect id of 4
			Product product6 = productService.acceptProductDetails(new Product(22, 2, "Great Product", "ABC"));
			System.out.println("saved product :- "+product6);
			System.out.println(product6.getId());
			
			//test remove
			productService.removeProdcutDetails(2);
			System.out.println("successful deletion");
			//productService.removeProdcutDetails(6); //catch

			
		} catch (ProductServiceDownException | ProductDetailsNotFoundException e) {
	
			e.printStackTrace();
		}
		

	}
}
