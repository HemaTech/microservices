package com.student.modal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Student implements Serializable {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int gender_id;
	private int medium_id;
	private String father_name;

	@Column(unique = true, name = "uid_no")
	private String uid;

	private String address;
	private String mobile_no;
	private String pincode;

	private int admission_year;
	private int course_id;
	private int branch_id;
	private int actual_fee;
	@Column(nullable = false,columnDefinition = "int default 0")
	private int previous_fee;
	private int academic_year;

	@Column(nullable = false,columnDefinition = "int default 0")
	private int promotion_status;
	
	private String bord_generated_admission_no;

	@Temporal(TemporalType.DATE)
	private Date registered_on;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Medium getMedium() {
		return medium;
	}

	public void setMedium(Medium medium) {
		this.medium = medium;
	}

	@ManyToOne(optional = false)

	@JoinColumn(name = "branch_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Branch branch;

	@ManyToOne(optional = false)

	@JoinColumn(name = "gender_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Gender gender;

	@ManyToOne(optional = false)

	@JoinColumn(name = "medium_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Medium medium;
	  
	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Course course;
	  
	  
	  
	  
	@OneToOne(cascade = CascadeType.ALL)

	@JoinColumn(name = "st_admission_id", referencedColumnName = "id")
	private Student_admission_detail student_admission_detail;

	public Student_admission_detail getStudent_admission_detail() {
		return student_admission_detail;
	}

	public void setStudent_admission_detail(Student_admission_detail student_admission_detail) {
		this.student_admission_detail = student_admission_detail;
	}
	
	@OneToMany(cascade = CascadeType.ALL)

	@JoinColumn(name = "student_id",nullable = false)
	private List<Student_attendance> student_attendance;

	public List<Student_attendance> getStudent_attendance() {
		return student_attendance;
	}

	public void setStudent_attendance(List<Student_attendance> student_attendance) {
		this.student_attendance = student_attendance;
	}
	  
	
	@OneToMany(cascade=CascadeType.ALL)

	@JoinColumn(name = "student_id" ,nullable = false)
	private List<Student_tution_fee_detail> student_tution_fee_detail;

	public List<Student_tution_fee_detail> getStudent_tution_fee_detail() {
		return student_tution_fee_detail;
	}

	public void setStudent_tution_fee_detail(List<Student_tution_fee_detail> student_tution_fee_detail) {
		this.student_tution_fee_detail = student_tution_fee_detail;
	}
	 

	//@OneToOne(cascade = CascadeType.ALL)

	//@JoinColumn(name = "student_id" ,nullable = false)
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_host_id", referencedColumnName = "id")
	private Student_hostel student_hostel;

	
	
	
	
	@OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL)
	 @JoinColumn(name = "course_comp_id", referencedColumnName = "id" )
	private Course_completion course_completion;

	public Course_completion getCourse_completion() {
		return course_completion;
	}

	public void setCourse_completion(Course_completion course_completion) {
		this.course_completion = course_completion;
	}

	
	@OneToMany(cascade = CascadeType.ALL)

	@JoinColumn(name = "student_id" ,nullable = false)
	private List<Certificate_student_info> certificate_student_info;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender_id() {
		return gender_id;
	}

	public void setGender_id(int gender_id) {
		this.gender_id = gender_id;
	}

	public int getMedium_id() {
		return medium_id;
	}

	public void setMedium_id(int medium_id) {
		this.medium_id = medium_id;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getAdmission_year() {
		return admission_year;
	}

	public void setAdmission_year(int admission_year) {
		this.admission_year = admission_year;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public int getActual_fee() {
		return actual_fee;
	}

	public void setActual_fee(int actual_fee) {
		this.actual_fee = actual_fee;
	}

	public String getBord_generated_admission_no() {
		return bord_generated_admission_no;
	}

	public void setBord_generated_admission_no(String bord_generated_admission_no) {
		this.bord_generated_admission_no = bord_generated_admission_no;
	}

	public Date getRegistered_on() {
		return registered_on;
	}

	public void setRegistered_on(Date registered_on) {
		this.registered_on = registered_on;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Certificate_student_info> getCertificate_student_info() {
		return certificate_student_info;
	}

	public void setCertificate_student_info(List<Certificate_student_info> certificate_student_info) {
		this.certificate_student_info = certificate_student_info;
	}

	public int getAcademic_year() {
		return academic_year;
	}

	public void setAcademic_year(int academic_year) {
		this.academic_year = academic_year;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public int getPrevious_fee() {
		return previous_fee;
	}

	public void setPrevious_fee(int previous_fee) {
		this.previous_fee = previous_fee;
	}

	public int getPromotion_status() {
		return promotion_status;
	}

	public void setPromotion_status(int promotion_status) {
		this.promotion_status = promotion_status;
	}

	public Student_hostel getStudent_hostel() {
		return student_hostel;
	}

	public void setStudent_hostel(Student_hostel student_hostel) {
		this.student_hostel = student_hostel;
	}

}
