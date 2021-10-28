package com.student.modal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student_attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "academic_year_id", referencedColumnName = "id",insertable =false, updatable =false)
    private Academic_year academic_year;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "attendance_type", referencedColumnName = "id",insertable =false, updatable =false)
    private Attendance attendance;
	
	
	
	
	
	
	private int attendance_type;
	private int academic_year_id;
	private int attendance_month;
	private int attendance_year;
	private Date attendance_date;
	private boolean is_present;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getAttendance_type() {
		return attendance_type;
	}

	public void setAttendance_type(int attendance_type) {
		this.attendance_type = attendance_type;
	}

	public int getAcademic_year_id() {
		return academic_year_id;
	}

	public void setAcademic_year_id(int academic_year_id) {
		this.academic_year_id = academic_year_id;
	}

	public int getAttendance_month() {
		return attendance_month;
	}

	public void setAttendance_month(int attendance_month) {
		this.attendance_month = attendance_month;
	}

	public int getAttendance_year() {
		return attendance_year;
	}

	public void setAttendance_year(int attendance_year) {
		this.attendance_year = attendance_year;
	}

	public Date getAttendance_date() {
		return attendance_date;
	}

	public void setAttendance_date(Date attendance_date) {
		this.attendance_date = attendance_date;
	}

	public boolean isIs_present() {
		return is_present;
	}

	public void setIs_present(boolean is_present) {
		this.is_present = is_present;
	}

	
}
