package net.perfectsolution.backend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;


@Entity
public class About {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Please enter the Description")
	@Column(name = "description_en")
	private String descriptionEn;
	
	@NotBlank(message = "Please enter the Description")
	@Column(name = "description_ar")
	private String descriptionAr;
	
	@NotBlank(message = "Please enter the Mission")
	@Column(name = "mission_en")
	private String missionEn;
	
	@NotBlank(message = "Please enter the Mission")
	@Column(name = "mission_ar")
	private String missionAr;
	
	@NotBlank(message = "Please enter the Vision")
	@Column(name = "vision_en")
	private String visionEn;
	
	@NotBlank(message = "Please enter the Vision")
	@Column(name = "vision_ar")
	private String visionAr;
	
	/*
	@Column(name = "top_img_url")
	private String topImgUrl;
	
	@Column(name = "desc_img_url")
	private String descImgUrl;
	 */
	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
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

	
	public String getMissionEn() {
		return missionEn;
	}

	
	public void setMissionEn(String missionEn) {
		this.missionEn = missionEn;
	}

	
	public String getMissionAr() {
		return missionAr;
	}

	
	public void setMissionAr(String missionAr) {
		this.missionAr = missionAr;
	}

	
	public String getVisionEn() {
		return visionEn;
	}

	
	public void setVisionEn(String visionEn) {
		this.visionEn = visionEn;
	}

	
	public String getVisionAr() {
		return visionAr;
	}

	
	public void setVisionAr(String visionAr) {
		this.visionAr = visionAr;
	}


	@Override
	public String toString() {
		return "About [id=" + id + ", descriptionEn=" + descriptionEn + ", descriptionAr=" + descriptionAr + ", missionEn=" + missionEn + ", missionAr=" + missionAr + ", visionEn=" + visionEn + ", visionAr=" + visionAr
				+ "]";
	}

	/*
	public String getTopImgUrl() {
		return topImgUrl;
	}

	
	public void setTopImgUrl(String topImgUrl) {
		this.topImgUrl = topImgUrl;
	}

	
	public String getDescImgUrl() {
		return descImgUrl;
	}

	
	public void setDescImgUrl(String descImgUrl) {
		this.descImgUrl = descImgUrl;
	}
*/

	
	
}
