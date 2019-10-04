package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subcategories")
public class SubCategory implements Comparable<SubCategory>{
	@GeneratedValue
	@Id
	@Column(name="subcategory_id", length=10)
	private int subCategoryId;
	@Column(name="subcategory_name", length=30)
	private String subCategoryName;
	
	public SubCategory() {
	}

	public SubCategory(int subCategoryId, String subCategoryName) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	@Override
	public String toString() {
		return "SubCategory [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + "]";
	}

	@Override
	public int compareTo(SubCategory sc) {
		// TODO Auto-generated method stub
		if(this.subCategoryId > sc.subCategoryId) {
			return 1;
		}else if(this.subCategoryId < sc.subCategoryId){
			return -1;
		}else {
			return 0;
		}
	}

}
