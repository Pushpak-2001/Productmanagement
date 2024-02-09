package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.Dealerdao;
import com.product.model.Dealer;

@Service
public class Dealerservice
{
	@Autowired
	private Dealerdao dealerdao;
	
	public List<Dealer> showAllDealers()
	{
		return dealerdao.showAllDealers();
	}
	public int saveDealer(Dealer d)
	{
		return dealerdao.saveDealer(d);
	}
	public Dealer showDealer(String email,String pwd)
	{
		return dealerdao.login(email,pwd);
	}

}
