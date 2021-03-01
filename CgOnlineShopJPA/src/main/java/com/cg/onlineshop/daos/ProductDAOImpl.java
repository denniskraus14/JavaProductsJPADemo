/*
package com.cg.onlineshop.daos;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import com.cg.onlineshop.exceptions.ProductDetailsNotFoundException;
import com.cg.onlineshop.pojos.Product;

public class ProductDAOImpl implements ProductDAO{
	
	private EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("PsUnit") ;

	@Override
	public Product save(Product product) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(product); //this is used to insert new entities to the table
		entityManager.getTransaction().commit();
		entityManager.close();
		return product;
	}
	
	@Override
	public boolean update(Product product) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Optional<Product> o = getProduct(product.getId());
		if(o.isEmpty()) {
			return false;
		}
		else{
			//set attributes to product's attributes
			Product temp = o.get();
			temp.setId(product.getId());
			temp.setPrice(product.getPrice());
			temp.setDescription(product.getDescription());
			temp.setName(product.getName());
			temp.setStarRating(product.getStarRating());
			
			//save to db
			em.merge(temp); //we use merge to update existing observations with detached entity
			System.out.println(temp.toString());
			em.getTransaction().commit();
			em.close();
		}
		return true;
	}
	
	@Override
	public boolean delete(int id) throws ProductDetailsNotFoundException{
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Optional<Product> o = getProduct(id);
		if(o.isEmpty()) {
			throw new ProductDetailsNotFoundException();
		}
		else {
			Product temp = o.get();
			em.remove(em.contains(temp) ? temp : em.merge(temp));
			em.getTransaction().commit();
			em.close();
			return true;
		}
	}

	@Override
	public Optional<Product> getProduct(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Product product = entityManager.find(Product.class, id);
		return Optional.ofNullable(product);
	}

	@Override
	public List<Product> getProducts() {
		return null;
	}
}*/