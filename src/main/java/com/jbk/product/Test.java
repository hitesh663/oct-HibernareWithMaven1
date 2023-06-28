package com.jbk.product;

import java.util.List;
import java.util.Scanner;

import com.jbk.product.entity.Product;
import com.jbk.product.service.ProductService;
import com.jbk.product.utility.ProductUtility;

public class Test {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ProductService service = new ProductService();
		int choice;
		char ch;

		do {
			System.out.println("*****in controller *****");
			System.out.println("Press 1 for save product");
			System.out.println("Press 2 for get product");
			System.out.println("Press 3 for delete product");
			System.out.println("Press 4 for update product");
			System.out.println("print 5 for all products");
			System.out.println("press 6 for restriction example");
			System.out.println("press 7 for restriction ex 2");
			System.out.println("press 8 for restrictions ex 3");
			System.out.println("press 9 for projections Ex");

			choice = scanner.nextInt();

			switch (choice) {

			case 1: {
				Product product = ProductUtility.prepareProductData(scanner);
				String msg = service.saveProduct(product);
				System.out.println(msg);
				break;
			}

		
			
			
			
			case 2: {
				System.out.println("Enter product Id");
				int productId = scanner.nextInt();
				Product product = service.getProductById(productId);
				if (product != null) {
					System.out.println(product);
				} else {
					System.out.println("Product not found.");
				}

				break;
			}

			
			
			
			
			case 3: {
				System.out.println("Enter Product Id");
				int productId = scanner.nextInt();
				String msg = service.deleteProductById(productId);
				System.out.println(msg);

				break;
			}

			
			
			
			case 4: {
				System.out.println("update");
				break;
			}

			
			
			
			
			case 5: {
				List<Product> list = service.getAllProducts();
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				}
				else {
					System.out.println("Product not Found");
				}
				break;
			}
			
			
			
			
			case 6: {
				List<Product> list = service.restrictionEx();
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				}
				else {
					System.out.println("Product not Found");
				}
				
				break;
			}
			
			
			
			
			
			
			case 7: {
				List<Product> list = service.restrictionEx2();
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				}
				else {
					System.out.println("Product not Found");
				}
				
				break;
			}
			
			
			
			
			
			
			case 8: {
				List<Product> list = service.restrictionEx3();
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				}
				else {
					System.out.println("Product not Found");
				}
				
				break;
			}
			
			
			
			
			case 9: {
				double sum = service.sumOfProductPrice();
				System.out.println(sum);
				break;
			}



			
			
			
			
			default:
				System.out.println("invalid choice !!");
				break;
			}

			System.out.println("Do you want to continue y/n");
			ch = scanner.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');
		System.out.println("Terminated");

	}

}
