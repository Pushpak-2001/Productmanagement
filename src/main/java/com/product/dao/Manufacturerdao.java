package com.product.dao;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.product.model.Manufacturer;

@Component
public class Manufacturerdao 
{
	@Autowired
	private HibernateTemplate hbtemp;
	
	public HibernateTemplate getHbtemp() {
		return hbtemp;
	}

	public void setHbtemp(HibernateTemplate hbtemp) {
		this.hbtemp = hbtemp;
	}
	
	@Transactional
	public int saveManufacturer(Manufacturer mnf)
	{
		return (int) hbtemp.save(mnf);
	}
	
	public Manufacturer login(String email,String pwd)
	{
		String qry = "from Manufacturer where email=:email and pwd=:pwd";
		
		Manufacturer mnf = (Manufacturer) hbtemp.execute(s->{
			Query q  = s.createQuery(qry);
			q.setString("email", email);
			q.setString("pwd", pwd);
			return q.uniqueResult();
			
		});
		
		return mnf;
		
	}

}
