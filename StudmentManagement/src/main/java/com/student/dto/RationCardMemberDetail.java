/*
 * package com.student.dto;
 * 
 * import java.io.Serializable; import java.util.Date;
 * 
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.Id; import javax.persistence.Table;
 * 
 * @Entity //@Table(name = "ration_card_member_detail")
 * 
 * @Table(name = "ration_card_member_detail")
 * 
 * public class RationCardMemberDetail implements Serializable {
 * 
 * @Id
 * 
 * @Column(name = "member_id") private String memberId;
 * 
 * @Column(name = "gender_type_gt_type_id") private int genderTypeGTTypeId;
 * 
 * @Column(name = "relationship_rs_code") private int relationshipRSCode;
 * 
 * @Column(name = "ration_card_id",insertable = false, updatable = false)
 * private int rationCardId;
 * 
 * @Column(name = "uid_no") private String uid;
 * 
 * @Column(name = "mtemp") private String mtemp;
 * 
 * @Column(name = "member_name_ll") private String memberNameLL;
 * 
 * @Column(name = "member_name_en") private String memberNameEn;
 * 
 * @Column(name = "mother_name_en") private String motherNameEn;
 * 
 * @Column(name = "mother_name_ll") private String motherNameLL;
 * 
 * @Column(name = "father_name_en") private String fatherNameEn;
 * 
 * @Column(name = "father_name_ll") private String fatherNameLL;
 * 
 * @Column(name = "member_dob") private Date memberDOB;
 * 
 * @Column(name = "member_age") private int memberAge=0;
 * 
 * @Column(name = "active") private int active;
 * 
 * @Column(name = "spouse_en") private String spouseEn;
 * 
 * @Column(name = "spouse_ll") private String spouseLL;
 * 
 * @Column(name = "epic_no") private String epicNo;
 * 
 * @Column(name = "nationality") private String nationality;
 * 
 * @Column(name = "bank_code") private String bankCode;
 * 
 * @Column(name = "branch_code") private String branchCode;
 * 
 * @Column(name = "account_number") private String accNo;
 * 
 * @Column(name = "hyd_mem_reason") private String reason;
 * 
 * @Column(name = "status") private String status;
 * 
 * @Column(name="mobile_no") private String mobileno;
 * 
 * @Column(name="eid_uid_name") private String eiduidname;
 * 
 * @Column(name="annual_income") private Integer annualincome;
 * 
 * @Column(name="occupation_code") private Integer occupationcode;
 * 
 * @Column(name = "seeding_date") private java.util.Date seedingdate;
 * 
 * @Column(name = "cidr_reason") private String rejectionreason;
 * 
 * 
 * @Column(name = "nfsa_rs_code") private int nfsarscode;
 * 
 * public String getRejectionreason() { return rejectionreason; }
 * 
 * public void setRejectionreason(String rejectionreason) { this.rejectionreason
 * = rejectionreason; }
 * 
 * public String getMtemp() { return mtemp; }
 * 
 * public void setMtemp(String mtemp) { this.mtemp = mtemp; }
 * 
 * public java.util.Date getSeedingdate() { return seedingdate; }
 * 
 * public void setSeedingdate(java.util.Date seedingdate) { this.seedingdate =
 * seedingdate; }
 * 
 * public Integer getOccupationcode() { return occupationcode; }
 * 
 * public void setOccupationcode(Integer occupationcode) { this.occupationcode =
 * occupationcode; }
 * 
 * public Integer getAnnualincome() { return annualincome; }
 * 
 * public void setAnnualincome(Integer annualincome) { this.annualincome =
 * annualincome; }
 * 
 * public String getMemberId() { return memberId; }
 * 
 * public void setMemberId(String memberId) { this.memberId = memberId; }
 * 
 * public int getGenderTypeGTTypeId() { return genderTypeGTTypeId; }
 * 
 * public void setGenderTypeGTTypeId(int genderTypeGTTypeId) {
 * this.genderTypeGTTypeId = genderTypeGTTypeId; }
 * 
 * public int getRelationshipRSCode() { return relationshipRSCode; }
 * 
 * public void setRelationshipRSCode(int relationshipRSCode) {
 * this.relationshipRSCode = relationshipRSCode; }
 * 
 * public String getMemberNameLL() { return memberNameLL; }
 * 
 * public void setMemberNameLL(String memberNameLL) { this.memberNameLL =
 * memberNameLL; }
 * 
 * public String getMemberNameEn() { return memberNameEn; }
 * 
 * public void setMemberNameEn(String memberNameEn) { this.memberNameEn =
 * memberNameEn; }
 * 
 * public String getMotherNameEn() { return motherNameEn; }
 * 
 * public void setMotherNameEn(String motherNameEn) { this.motherNameEn =
 * motherNameEn; }
 * 
 * public String getMotherNameLL() { return motherNameLL; }
 * 
 * public void setMotherNameLL(String motherNameLL) { this.motherNameLL =
 * motherNameLL; }
 * 
 * public String getFatherNameEn() { return fatherNameEn; }
 * 
 * public void setFatherNameEn(String fatherNameEn) { this.fatherNameEn =
 * fatherNameEn; }
 * 
 * public String getFatherNameLL() { return fatherNameLL; }
 * 
 * public void setFatherNameLL(String fatherNameLL) { this.fatherNameLL =
 * fatherNameLL; }
 * 
 * public Date getMemberDOB() { return memberDOB; }
 * 
 * public void setMemberDOB(Date memberDOB) { this.memberDOB = memberDOB; }
 * 
 * public int getMemberAge() { return memberAge; }
 * 
 * public void setMemberAge(int memberAge) { this.memberAge = memberAge; }
 * 
 * public int getActive() { return active; }
 * 
 * public void setActive(int active) { this.active = active; }
 * 
 * 
 * public String getSpouseEn() { return spouseEn; }
 * 
 * public void setSpouseEn(String spouseEn) { this.spouseEn = spouseEn; }
 * 
 * public String getSpouseLL() { return spouseLL; }
 * 
 * public void setSpouseLL(String spouseLL) { this.spouseLL = spouseLL; }
 * 
 * public int getRationCardId() { return rationCardId; }
 * 
 * public void setRationCardId(int rationCardId) { this.rationCardId =
 * rationCardId; }
 * 
 * @Column(name = "authorized") private Integer authorized;
 * 
 *//**
	 * @return the authorized
	 */
/*
 * public Integer getAuthorized() { return authorized; }
 * 
 *//**
	 * @param authorized the authorized to set
	 */
/*
 * public void setAuthorized(Integer authorized) { this.authorized = authorized;
 * }
 * 
 *//**
	 * @return the epicNo
	 */
/*
 * public String getEpicNo() { return epicNo; }
 * 
 *//**
	 * @param epicNo the epicNo to set
	 */
/*
 * public void setEpicNo(String epicNo) { this.epicNo = epicNo; }
 * 
 *//**
	 * @return the nationality
	 */
/*
 * public String getNationality() { return nationality; }
 * 
 *//**
	 * @param nationality the nationality to set
	 */
/*
 * public void setNationality(String nationality) { this.nationality =
 * nationality; }
 *//**
	 * @return the bankCode
	 */
/*
 * public String getBankCode() { return bankCode; }
 *//**
	 * @param bankCode the bankCode to set
	 */
/*
 * public void setBankCode(String bankCode) { this.bankCode = bankCode; }
 *//**
	 * @return the branchCode
	 */
/*
 * public String getBranchCode() { return branchCode; }
 *//**
	 * @param branchCode the branchCode to set
	 */
/*
 * public void setBranchCode(String branchCode) { this.branchCode = branchCode;
 * }
 *//**
	 * @return the accNo
	 */
/*
 * public String getAccNo() { return accNo; }
 *//**
	 * @param accNo the accNo to set
	 *//*
		 * public void setAccNo(String accNo) { this.accNo = accNo; }
		 * 
		 * public String getUid() { return uid; }
		 * 
		 * public void setUid(String uid) { this.uid= uid; }
		 * 
		 * public String getReason() { return reason; }
		 * 
		 * public void setReason(String reason) { this.reason = reason; }
		 * 
		 * public String getStatus() { return status; }
		 * 
		 * public void setStatus(String status) { this.status = status; }
		 * 
		 * public String getMobileno() { return mobileno; }
		 * 
		 * public void setMobileno(String mobileno) { this.mobileno = mobileno; }
		 * 
		 * public String getEiduidname() { return eiduidname; }
		 * 
		 * public void setEiduidname(String eiduidname) { this.eiduidname = eiduidname;
		 * }
		 * 
		 * public int getNfsarscode() { return nfsarscode; }
		 * 
		 * public void setNfsarscode(int nfsarscode) { this.nfsarscode = nfsarscode; }
		 * 
		 * 
		 * 
		 * }
		 */