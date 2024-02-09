package com.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manufacturer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mid;
	private String uname;
	private String pwd;
	private String email;
	private String mobile;
	
	public Manufacturer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Manufacturer(int mid, String uname, String pwd, String email, String mobile) {
		super();
		this.mid = mid;
		this.uname = uname;
		this.pwd = pwd;
		this.email = email;
		this.mobile = mobile;
	}


	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
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
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Override
	public String toString() {
		return "Manufacturer [mid=" + mid + ", uname=" + uname + ", pwd=" + pwd + ", email=" + email + ", mobile="
				+ mobile + "]";
	}


	
	
	

}
