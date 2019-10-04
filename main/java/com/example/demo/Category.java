package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category implements Comparable<Category>{
	@GeneratedValue
	@Id
	@Column(name="category_id", length=10)
	private int categoryId;
	@Column(name="category_name", length=30)
	private String categoryName;
	
	public Category() {
	}

	public Category(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
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
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

	@Override
	public int compareTo(Category c) {
		// TODO Auto-generated method stub
		if(this.categoryId > c.categoryId) {
			return 1;
		}else if(this.categoryId < c.categoryId){
			return -1;
		}else {
			return 0;
		}
	}

}
