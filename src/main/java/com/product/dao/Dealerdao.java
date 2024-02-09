package com.product.dao;

import java.util.List;

import javax.persistence.QueryHint;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.product.model.Dealer;
import com.product.model.Manufacturer;

@Component
public class Dealerdao 
{
	@Autowired
	private HibernateTemplate hbtemp;
	
	public HibernateTemplate getHbtemp() {
		return hbtemp;
	}

	public void setHbtemp(HibernateTemplate hbtemp) {
		this.hbtemp = hbtemp;
	}
	
	public List<Dealer> showAllDealers()
	{
		return hbtemp.loadAll(Dealer.class);
	}
	
	@Transactional
	public int saveDealer(Dealer d)
	{
		return (int) hbtemp.save(d);
	}
	
	public Dealer login(String email,String pwd)
	{
		String qry = "from Dealer where email=:email and pwd=:pwd";
		
		Dealer dl = (Dealer) hbtemp.execute(s->{
			Query q  = s.createQuery(qry);
			q.setString("email", email);
			q.setString("pwd", pwd);
			return q.uniqueResult();
			
		});
		
		return dl;
		
	}
	
	public Dealer getDealerByName(String name)
	{
		String qry = "from Dealer where uname=:name";
		
		Dealer dl = (Dealer) hbtemp.execute(s->{
			Query q  = s.createQuery(qry);
			q.setString("name", name);
			return q.uniqueResult();
			
		});
		
		return dl;
		
	}

}
