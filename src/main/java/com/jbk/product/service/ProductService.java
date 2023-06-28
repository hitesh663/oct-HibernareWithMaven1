package com.jbk.product.service;

import java.util.List;

import com.jbk.product.dao.ProductDao;
import com.jbk.product.entity.Product;

public class ProductService {
	private ProductDao dao = new ProductDao();

	public String saveProduct(Product product) {
		String msg = dao.saveProduct(product);
		return msg;

	}

	public Product getProductById(int productId) {
		return dao.getProductById(productId);

	}

	public String deleteProductById(int productId) {
		return dao.deleteProductById(productId);

	}

	public List<Product> getAllProducts() {

		return dao.getAllProducts();
	}

	public List<Product> restrictionEx() {

		return dao.restrictionEx();
	}

	public List<Product> restrictionEx2() {

		return dao.restrictionEx2();
	}
	
	public List<Product> restrictionEx3() {

		return dao.restrictionEx3();
	}
	
	public double sumOfProductPrice() {
		return dao.sumOfProductPrice() ;
		
	}

}
