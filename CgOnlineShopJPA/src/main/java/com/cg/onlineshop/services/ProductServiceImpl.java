package com.cg.onlineshop.services;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshop.daos.ProductDAO;
import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;
import com.cg.onlineshop.exceptions.ProductServiceDownException;
import com.cg.onlineshop.pojos.Product;

@Service(value="productService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public Product acceptProductDetails(Product product) throws ProductServiceDownException {
		return productDAO.save(product);
	}

	@Override
	public List<Product> getAllProductDetails() throws ProductServiceDownException {
		return productDAO.findAll();
	}

	@Override
	public Product getProductDetails(int id) throws ProductDetailsNotFoundException, ProductServiceDownException {
		Optional<Product> optional = productDAO.findById(id);
		Supplier<ProductDetailsNotFoundException> supplier = () -> new ProductDetailsNotFoundException("Product Details not Found");
		return optional.orElseThrow(supplier);
	}

	@Override
	public void removeProdcutDetails(int id) throws ProductDetailsNotFoundException, ProductServiceDownException {
		productDAO.deleteById(id);
	}
	
}