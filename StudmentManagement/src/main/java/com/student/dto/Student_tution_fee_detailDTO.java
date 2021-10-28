package com.student.dto;

import java.util.Date;


public class Student_tution_fee_detailDTO {

	
	
	private int fee_amount;
	private Date paid_on;
	private String receipt_no;

	private int fee_type;
	private String challen_no;
	private String fee_type_name;

   
	public int getFee_type() {
		return fee_type;
	}

	public void setFee_type(int fee_type) {
		this.fee_type = fee_type;
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

	public String getFee_type_name() {
		return fee_type_name;
	}

	public void setFee_type_name(String fee_type_name) {
		this.fee_type_name = fee_type_name;
	}

	public String getChallen_no() {
		return challen_no;
	}

	public void setChallen_no(String challen_no) {
		this.challen_no = challen_no;
	}

}
