package net.perfectsolution.backend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Service {

	/*
	 *Private fields 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name_en")
	private String nameEn;
	@Column(name = "name_ar")
	private String nameAr;
	@Column(name = "description_en")
	private String descriptionEn;
	@Column(name = "description_ar")
	private String descriptionAr;
	private String code;
	@Column(name = "is_active")
	private boolean isActive;
	
	public Service(){
		//defualt constructor
		this.code = "SER" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
