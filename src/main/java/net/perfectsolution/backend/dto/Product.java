package net.perfectsolution.backend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {

	/*
	 *Private fields 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Please enter the Name")
	@Column(name = "name_en")
	private String nameEn;
	@NotBlank(message = "Please enter the Name")
	@Column(name = "name_ar")
	private String nameAr;
	@NotBlank(message = "Please enter the Description")
	@Column(name = "description_en")
	private String descriptionEn;
	@NotBlank(message = "Please enter the Description")
	@Column(name = "description_ar")
	private String descriptionAr;
	private String code;
	@Column(name = "is_active")
	private boolean active;
	@Column(name = "category_id")
	private int categoryId;
	@Transient
	private MultipartFile file;
	
	
	public Product(){
		//defualt constructor
		this.code = "SER" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	
	
	public int getCategoryId() {
		return categoryId;
	}


	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	public String getDescriptionAr() {
		return descriptionAr;
	}

	public void setDescriptionAr(String descriptionAr) {
		this.descriptionAr = descriptionAr;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
