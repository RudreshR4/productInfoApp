package com.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.Model.Product;

@Component
public class ProductDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createProduct(Product prod) {
		this.hibernateTemplate.saveOrUpdate(prod);
	}
	
	public List<Product> getAllProducts(){
		return this.hibernateTemplate.loadAll(Product.class);
	}
	
	@Transactional
	public void deleteProduct(int pid) {
		Product product = this.hibernateTemplate.get(Product.class, pid);
		this.hibernateTemplate.delete(product);
	}
	
	public Product getProduct(int pid) {
		Product product = this.hibernateTemplate.get(Product.class, pid);
	    return product;
	}
}
