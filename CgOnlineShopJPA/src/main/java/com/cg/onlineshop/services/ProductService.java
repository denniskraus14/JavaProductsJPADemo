package com.cg.onlineshop.services;

import java.util.List;

import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;
import com.cg.onlineshop.exceptions.ProductServiceDownException;
import com.cg.onlineshop.pojos.Product;

public interface ProductService {
	public Product acceptProductDetails(Product product) throws ProductServiceDownException;
	public List<Product>  getAllProductDetails()throws ProductServiceDownException;
	public Product getProductDetails(int id)throws ProductDetailsNotFoundException, ProductServiceDownException;
	public void removeProdcutDetails(int id) throws ProductDetailsNotFoundException, ProductServiceDownException;
}