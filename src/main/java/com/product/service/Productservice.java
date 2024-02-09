package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.Productdao;
import com.product.model.Product;

@Service
public class Productservice 
{
	@Autowired
	private Productdao productdao;
	public void saveProduct(Product product)
	{
		productdao.addProduct(product);
	}
	public List<Product> showAllProducts()
	{
		return productdao.getAllProduct();
	}
	public Product showProduct(int id)
	{
		return productdao.getProduct(id);
	}
	public void removeProduct(int id)
	{
		productdao.deleteProduct(id);
	}

}
