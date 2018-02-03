package net.perfectsolution.backend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Category implements Comparable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "category_type")
	private int categoryType;
	@NotBlank(message = "Please enter the Name")
	@Column(name = "name_en")
	private String nameEn;
	@NotBlank(message = "Please enter the Name")
	@Column(name = "name_ar")
	private String nameAr;
	@Column(name = "is_active")
	private boolean active;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCategoryType() {
		return categoryType;
	}
	
	public void setCategoryType(int categoryType) {
		this.categoryType = categoryType;
	}
	
	public String getNameEn() {
		return nameEn;
	}
	
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	
	public String getNameAr() {
		return nameAr;
	}
	
	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Category){
			if (this.getId() > ((Category)obj).getId()){
				return 1;
			}else{
				return -1;
			}
		}else{
			return -1;
		}
	}
	
}
