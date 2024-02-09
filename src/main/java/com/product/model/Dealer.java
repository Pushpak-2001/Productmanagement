package com.product.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Dealer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int dealerId;
	
	private String uname;
	private String pwd;
	private String mobile;
	private String email;
	
	@ManyToMany(mappedBy = "dealer",fetch = FetchType.EAGER)
	private List<Product> product;

	public Dealer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dealer(int dealerId, String uname, String pwd, String mobile, String email,
			List<Product> product) {
		super();
		this.dealerId = dealerId;
		this.uname = uname;
		this.pwd = pwd;
		this.mobile = mobile;
		this.email = email;
		this.product = product;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Dealer [dealerId=" + dealerId + ", uname=" + uname + ", pwd="
				+ pwd + ", mobile=" + mobile + ", email=" + email + ", product=" + product + "]";
	}

	
	
	

}
