package com.jbk.product.utility;

import java.util.Scanner;

import com.jbk.product.entity.Product;

public class ProductUtility {
	
	public static Product prepareProductData(Scanner scanner) {
		
		System.out.println("enter product id");
		int productId = scanner.nextInt();
		
		System.out.println("enter product name");
		String productName = scanner.next();
		
		System.out.println("enter product Price");
		double productPrice = scanner.nextDouble();
		
		System.out.println("enter product Mfg ");
		String productMfg = scanner.next();
		
		System.out.println("enter product Category");
		String productCategory = scanner.next();
		
		Product product = new Product(productId, productName, productPrice, productMfg, productCategory);
		
		return product;
	}

}
