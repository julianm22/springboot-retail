package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="products1")
public class Product implements Comparable<Product> {
	@GeneratedValue
	@Id
	@Column(name="product_id", length=10)
	private int productId;
	@Column(name="product_name", length=30)
	private String productName;
	@Column(name="product_price", length=10)
	private double productPrice;
	@Column(name="description", length=130)
	private String description;
	@Column(name="category_id", length=10)
	private int categoryId;
	@Transient
	private String categoryName;
	
	public Product() {
	}

	public Product(String productName, double productPrice, String description, int categoryId) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.description = description;
		this.categoryId = categoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", description=" + description + ", category=" + categoryName + "]";
	}
	
	@Override
	public int compareTo(Product p) {
		// TODO Auto-generated method stub
		if(this.productId > p.productId) {
			return 1;
		}else if(this.productId < p.productId){
			return -1;
		}else {
			return 0;
		}
	}

}
