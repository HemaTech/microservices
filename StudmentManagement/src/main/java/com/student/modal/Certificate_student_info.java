package com.student.modal;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "certificate_student_info")
public class Certificate_student_info implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	
	private int certificate_id;

	@Column(name = "action")
	private String action;

	
	@Column(name = "remarks")
	private String remarks;
	
	@Basic(optional = false)
	@Column(name = "generate_time",insertable = false, updatable = false ,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
	@Temporal(TemporalType.TIMESTAMP)
    private Date generateTime;

	@ManyToOne(optional = false)

	@JoinColumn(name = "certificate_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Certificate_master certificate_master;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	
	public Certificate_master getCertificate_master() {
		return certificate_master;
	}

	public void setCertificate_master(Certificate_master certificate_master) {
		this.certificate_master = certificate_master;
	}

	public int getCertificate_id() {
		return certificate_id;
	}

	public void setCertificate_id(int certificate_id) {
		this.certificate_id = certificate_id;
	}

	public Date getGenerateTime() {
		return generateTime;
	}

	public void setGenerateTime(Date generateTime) {
		this.generateTime = generateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	

	

}
