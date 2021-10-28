package com.student.modal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class Student_admission_detail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	
	//@SequenceGenerator(initialValue = 1000000, name = "admission_id", sequenceName = "admission_id_seq")
	@Column(unique = true, name = "admission_id",insertable = true,updatable = false)
	private String admissionid;
	
	@Column(unique = true, name = "hallticket_no")
	private String hallticketno;
	
	@Column(unique = true, name = "board_generated_admission_no")
	private String board_generated_admission_no;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	

	public String getBoard_generated_admission_no() {
		return board_generated_admission_no;
	}

	public void setBoard_generated_admission_no(String board_generated_admission_no) {
		this.board_generated_admission_no = board_generated_admission_no;
	}

	public String getAdmissionid() {
		return admissionid;
	}

	public void setAdmissionid(String admissionid) {
		this.admissionid = admissionid;
	}

	public String getHallticketno() {
		return hallticketno;
	}

	public void setHallticketno(String hallticketno) {
		this.hallticketno = hallticketno;
	}

	

}
