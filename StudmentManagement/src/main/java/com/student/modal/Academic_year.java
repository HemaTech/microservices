package com.student.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Academic_year {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String academic_year_name;
	
	 @Column(nullable = true)
	private int promotion_id;
	 
	 
	/*
	 * @Column(nullable = true) private int academic_year;
	 */
	 
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcademic_year_name() {
		return academic_year_name;
	}

	public void setAcademic_year_name(String academic_year_name) {
		this.academic_year_name = academic_year_name;
	}

	public int getPromotion_id() {
		return promotion_id;
	}

	public void setPromotion_id(int promotion_id) {
		this.promotion_id = promotion_id;
	}

	

}
