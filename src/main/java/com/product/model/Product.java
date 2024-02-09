package com.product.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	@NotBlank(message = "Product company can't be blank !!") 
	@Size(min=3,max=20,message="Product company must be between 3-20 characters !!")
	private String productComp;
	
	@NotBlank(message = "Product Category can't be blank !!") 
	@Size(min=3,max=20,message="Product Category must be between 3-20 characters !!")
	private String productCategory;
	
	@NotBlank(message = "Product description can't be blank !!")
	private String productDesc;
	
	private Double productPrice;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String startdt;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String enddt;
	
	private int sales;
	 
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Dealer> dealer;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}








	public Product(int productId, @NotBlank(message = "Product company can't be blank !!") String productComp,
			@NotBlank(message = "Product Category can't be blank !!") String productCategory,
			@NotBlank(message = "Product description can't be blank !!") String productDesc, Double productPrice,
			String startdt, String enddt, int sales, List<Dealer> dealer) {
		super();
		this.productId = productId;
		this.productComp = productComp;
		this.productCategory = productCategory;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.startdt = startdt;
		this.enddt = enddt;
		this.sales = sales;
		this.dealer = dealer;
	}








	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}



	public String getProductComp() {
		return productComp;
	}






	public void setProductComp(String productComp) {
		this.productComp = productComp;
	}






	public String getProductCategory() {
		return productCategory;
	}






	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}






	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public List<Dealer> getDealer() {
		return dealer;
	}

	public void setDealer(List<Dealer> dealer) {
		this.dealer = dealer;
	}



	public String getStartdt() {
		return startdt;
	}



	public void setStartdt(String startdt) {
		this.startdt = startdt;
	}



	public String getEnddt() {
		return enddt;
	}



	public void setEnddt(String enddt) {
		this.enddt = enddt;
	}






	public int getSales() {
		return sales;
	}








	public void setSales(int sales) {
		this.sales = sales;
	}








	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productComp=" + productComp + ", productCategory="
				+ productCategory + ", productDesc=" + productDesc + ", productPrice=" + productPrice + ", startdt="
				+ startdt + ", enddt=" + enddt + ", dealer=" + dealer + "]";
	}






	@Override
	public int hashCode() {
		
		return this.productCategory.hashCode() + this.productComp.hashCode() + this.productDesc.hashCode();
	}






	@Override
	public boolean equals(final Object obj) 
	{
		if(obj==null)
		{
			return false;
		}
		if(!Product.class.isInstance(obj))
		{
			return false;
		}
		
		Product p = (Product) obj;
		
		return 
			     this.productComp.equals(p.productComp)
				&& this.productCategory.equals(p.productCategory)
				&& this.productDesc.equals(p.productDesc);
	}
	
	
	

}
