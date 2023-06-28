package com.jbk.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.jbk.product.config.HibernateUtility;
import com.jbk.product.entity.Product;

public class ProductDao {

	private SessionFactory sessionFactory;

	public ProductDao() {
		sessionFactory = HibernateUtility.getSessionFactory();
	}

	public String saveProduct(Product product) {
		Session session = null;
		boolean isAdded = false;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Product dbproduct = session.get(Product.class, product.getProductId());
			if (dbproduct == null) {
				session.save(product); // alt+shift+l for serializable
				transaction.commit();
				isAdded = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		if (isAdded) {
			return "Saved !!";
		} else {
			return "Already Exist";
		}
	}

	public Product getProductById(int productId) {
		Session session = null;
		Product product = null;
		try {
			session = sessionFactory.openSession();
			product = session.get(Product.class, productId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return product;
	}

	public String deleteProductById(int productId) {
		Session session = null;
		String msg = null;

		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Product product = session.get(Product.class, productId);
			if (product != null) {
				session.delete(product);
				transaction.commit();
				msg = "deleted";

			} else {
				msg = "product does not exist with Id = " + productId;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return msg;
	}

	public List<Product> getAllProducts() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);

			// criteria.addOrder(Order.desc("productPrice"));

			criteria.setFirstResult(0);
			criteria.setMaxResults(3);

			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}

		return list;
	}

	public List<Product> restrictionEx() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);

			Criterion crt = Restrictions.eq("productName", "pen");

			criteria.add(crt);

			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return list;
	}

	public List<Product> restrictionEx2() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);

			// Map<String, Object> map = new HashMap<>();
			// map.put("productName", "pen");
			// map.put("productPrice", 12.2d);
			// Criterion crt = Restrictions.allEq(map);
			// criteria.add(crt);

			Criterion name = Restrictions.eq("productName", "pen");
			Criterion price = Restrictions.eq("productPrice", 121d);
			// criteria.add(Restrictions.and(name,price));//for same product
			// criteria.add(Restrictions.or(name,price));// for 2 products or multiple
			// products

			// criteria.add(Restrictions.between("productPrice", 1d, 500d));

			// criteria.add(Restrictions.in("productPrice", 45000d,500d,121d));

			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return list;
	}

	public List<Product> restrictionEx3() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);

			criteria.add(Restrictions.like("productName", "%o%"));

			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return list;

	}

	public double sumOfProductPrice() {
		Session session = null;
		double sum = 0;
		try {
			session = sessionFactory.openSession();
			
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.sum("productPriceh"));
			List<Double> list = criteria.list();
			sum = list.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return sum;
	}

}
