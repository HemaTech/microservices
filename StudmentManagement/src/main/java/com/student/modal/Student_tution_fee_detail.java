package com.student.modal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student_tution_fee_detail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int fee_amount;
	private Date paid_on;
	private String receipt_no;

	private int fee_type;

	
	  @ManyToOne(optional =false)
	  
	  @JoinColumn(name = "fee_type",referencedColumnName = "id",  insertable = false,updatable = false)
	  private Fee fee;
	 
	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "student_id", nullable = false)
	 * 
	 * private Student student;
	 */
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	


	public int getFee_amount() {
		return fee_amount;
	}

	public void setFee_amount(int fee_amount) {
		this.fee_amount = fee_amount;
	}

	public Date getPaid_on() {
		return paid_on;
	}

	public void setPaid_on(Date paid_on) {
		this.paid_on = paid_on;
	}

	public String getReceipt_no() {
		return receipt_no;
	}

	public void setReceipt_no(String receipt_no) {
		this.receipt_no = receipt_no;
	}

	public int getFee_type() {
		return fee_type;
	}

	public void setFee_type(int fee_type) {
		this.fee_type = fee_type;
	}

	/*
	 * public Student getStudent() { return student; }
	 * 
	 * public void setStudent(Student student) { this.student = student; }
	 */

	

	

}
