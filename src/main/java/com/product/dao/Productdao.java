package com.product.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.product.model.Manufacturer;
import com.product.model.Product;

@Repository
public class Productdao 
{
	@Autowired
	public HibernateTemplate hbtemp;

	public HibernateTemplate getHbtemp() {
		return hbtemp;
	}

	public void setHbtemp(HibernateTemplate hbtemp) {
		this.hbtemp = hbtemp;
	}
	
	@Transactional
	public void addProduct(Product product)
	{
		hbtemp.saveOrUpdate(product);
	}
	
	public List<Product> getAllProduct()
	{
		return hbtemp.loadAll(Product.class);
	}
	
	public Product getProduct(int pid)
	{	
		return  hbtemp.get(Product.class,pid);
	}
	
	@Transactional
	public void deleteProduct(int pid)
	{
		hbtemp.delete(hbtemp.get(Product.class, pid));
	}
	
	public List<Product> getProductByName(String str)
	{
		String qry = "from Product where productComp like :str";
		
		List<Product> p = (List<Product>) hbtemp.execute(s->{
			Query q  = s.createQuery(qry);
			q.setString("str", "%"+str+"%");
			return q.list();
			
		});
		
		return p;
		
	}
	public List<Product> getProductPagination(int pageno)
	{
		Session session = hbtemp.getSessionFactory().openSession();
		Query qry = session.createQuery("from Product");

		int page=(pageno-1)*3;
		
		qry.setFirstResult(page);
		qry.setMaxResults(3);
		
		return qry.list();
		
	}
	
	public void saveProductSales(int sales,int pid)
	{
		Product p = getProduct(pid);
		int psales = p.getSales();
		int totalSales = psales+sales;
		
		Session session = hbtemp.getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		Query qry = session.createQuery("update Product set sales=:s where productId=:id");
		
		qry.setParameter("s", totalSales);
		qry.setParameter("id", pid);
		
		 qry.executeUpdate();
		tx.commit();
	}
	

}
