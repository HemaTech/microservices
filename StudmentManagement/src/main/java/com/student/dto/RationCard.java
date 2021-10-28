/*
 * package com.student.dto;
 * 
 * import java.io.Serializable; import java.util.Date; import java.util.List;
 * 
 * import javax.persistence.CascadeType; import javax.persistence.Column; import
 * javax.persistence.Entity; import javax.persistence.GeneratedValue; import
 * javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.JoinColumn; import javax.persistence.OneToMany; import
 * javax.persistence.SequenceGenerator; import javax.persistence.Table;
 * 
 * import org.hibernate.annotations.GenericGenerator;
 * 
 * @Entity //@Table(name = "ration_card")
 * 
 * @Table(name = "ration_card")
 * 
 * public class RationCard implements Serializable {
 * 
 * // @Id // @GenericGenerator(name="generator", strategy="increment")
 * // @GeneratedValue(generator="generator") // @Column(name = "id") // private
 * int id;
 * 
 * @Id
 * 
 * @Column(name="id", nullable=false)
 * 
 * @SequenceGenerator(name="my_seq", sequenceName="ration_card_id_seq",
 * allocationSize=1)
 * 
 * @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="my_seq")
 * private Integer id;
 * 
 * @Column(name = "src_no") private String srcNo;
 * 
 * @Column(name = "fps_id") private String fpsId;
 * 
 * @Column(name = "district_code") private String districtCode;
 * 
 * @Column(name = "state_code") private String stateCode;
 * 
 * @Column(name = "rc_active") private int active;
 * 
 * @Column(name = "application_no") private Integer applicationNo;
 * 
 * @Column(name = "modification_date") private Date modification_date;
 * 
 * @Column(name = "application_id") private String applicationId;
 * 
 * @Column(name = "tehsil_code") private String tehsilCode;
 * 
 * @Column(name = "is_temporary") private String temporary;
 * 
 * @Column(name = "type_id") private int typeId;
 * 
 * @Column(name = "valid_upto") private Date validUpto;
 * 
 * @Column(name = "existing_rc_number") private String existingrcnumber;
 * 
 * @Column(name="hyd_no_of_units") private Integer hydnoofunits=0;
 * 
 * @Column(name="plc_code") private String plccode=null;
 * 
 * 
 * @Column(name="meesevaappno") private String meesevaappno=null;
 * 
 * @Column(name="hashval") private String hashval=null;
 * 
 * @Column(name="signature") private String signature=null;
 * 
 * @Column(name = "nfsa_type_id") private int nfsatypeId;
 * 
 * public String getPlccode() { return plccode; }
 * 
 * public void setPlccode(String plccode) { this.plccode = plccode; }
 * 
 * public void setId(Integer id) { this.id = id; }
 * 
 * public void setApplicationNo(Integer applicationNo) { this.applicationNo =
 * applicationNo; }
 * 
 * 
 * public Integer getHydnoofunits() { return hydnoofunits; }
 * 
 * public void setHydnoofunits(Integer hydnoofunits) { this.hydnoofunits =
 * hydnoofunits; }
 * 
 *//**
	 * @return the existingrcnumber
	 */
/*
 * public String getExistingrcnumber() { return existingrcnumber; }
 * 
 *//**
	 * @param existingrcnumber the existingrcnumber to set
	 */
/*
 * public void setExistingrcnumber(String existingrcnumber) {
 * this.existingrcnumber = existingrcnumber; }
 * 
 * @Column(name = "kerosene_fps_id") private String kerosenefpsid;
 * 
 * public String getKerosenefpsid() { return kerosenefpsid; }
 * 
 * public void setKerosenefpsid(String kerosenefpsid) { this.kerosenefpsid =
 * kerosenefpsid; }
 * 
 * @OneToMany(cascade=CascadeType.ALL)
 * 
 * @JoinColumn(name="ration_card_id",nullable=false) List<RationCardAddress>
 * cardAddress;
 * 
 * @OneToMany(cascade=CascadeType.ALL)
 * 
 * @JoinColumn(name="ration_card_id",nullable=false)
 * 
 * @org.hibernate.annotations.Cascade(value =
 * org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
 * List<RationCardMemberDetail> memberDetails;
 * 
 * @OneToMany(cascade=CascadeType.ALL)
 * 
 * @JoinColumn(name="ration_card_id") List<RCUserEnclosures> enclosures;
 * 
 * 
 * 
 *//**
	 * @return the temporary
	 */
/*
 * public String getTemporary() { return temporary; }
 * 
 *//**
	 * @param temporary the temporary to set
	 */
/*
 * public void setTemporary(String temporary) { this.temporary = temporary; }
 * 
 *//**
	 * @return the categoryTypeId
	 */
/*
 * public int getTypeId() { return typeId; }
 * 
 *//**
	 * @param categoryTypeId the categoryTypeId to set
	 */
/*
 * public void setTypeId(int typeId) { this.typeId = typeId; }
 * 
 *//**
	 * @return the validUpto
	 */
/*
 * public Date getValidUpto() { return validUpto; }
 * 
 *//**
	 * @param validUpto the validUpto to set
	 *//*
		 * public void setValidUpto(Date validUpto) { this.validUpto = validUpto; }
		 * 
		 * @Column(name="src_status") private String srcStatus;
		 * 
		 * @Column(name = "urban_rural") private int urbanRural;
		 * 
		 * public Date getModification_date() { return modification_date; }
		 * 
		 * public void setModification_date(Date modification_date) {
		 * this.modification_date = modification_date; }
		 * 
		 * public String getSrcNo() { return srcNo; }
		 * 
		 * public int getUrbanRural() { return urbanRural; }
		 * 
		 * public void setUrbanRural(int urbanRural) { this.urbanRural = urbanRural; }
		 * 
		 * public void setSrcNo(String srcNo) { this.srcNo = srcNo; }
		 * 
		 * public String getFpsId() { return fpsId; }
		 * 
		 * public void setFpsId(String fpsId) { this.fpsId = fpsId; }
		 * 
		 * 
		 * public String getApplicationId() { return applicationId; }
		 * 
		 * public void setApplicationId(String applicationId) { this.applicationId =
		 * applicationId; }
		 * 
		 * public String getDistrictCode() { return districtCode; }
		 * 
		 * public void setDistrictCode(String districtCode) { this.districtCode =
		 * districtCode; }
		 * 
		 * public String getStateCode() { return stateCode; }
		 * 
		 * public void setStateCode(String stateCode) { this.stateCode = stateCode; }
		 * 
		 * 
		 * public int getApplicationNo() { return applicationNo; }
		 * 
		 * public void setApplicationNo(int applicationNo) { this.applicationNo =
		 * applicationNo; }
		 * 
		 * public int getId() { return id; }
		 * 
		 * public void setId(int id) { this.id = id; }
		 * 
		 * public String getTehsilCode() { return tehsilCode; }
		 * 
		 * public void setTehsilCode(String tehsilCode) { this.tehsilCode = tehsilCode;
		 * }
		 * 
		 * public List<RationCardAddress> getCardAddress() { return cardAddress; }
		 * 
		 * public void setCardAddress(List<RationCardAddress> cardAddress) {
		 * this.cardAddress = cardAddress; }
		 * 
		 * public List<RationCardMemberDetail> getMemberDetails() { return
		 * memberDetails; }
		 * 
		 * public void setMemberDetails(List<RationCardMemberDetail> memberDetails) {
		 * this.memberDetails = memberDetails; }
		 * 
		 * public List<RCUserEnclosures> getEnclosures() { return enclosures; }
		 * 
		 * public void setEnclosures(List<RCUserEnclosures> enclosures) {
		 * this.enclosures = enclosures; }
		 * 
		 * public int getActive() { return active; }
		 * 
		 * public void setActive(int active) { this.active = active; }
		 * 
		 * public String getSrcStatus() { return srcStatus; }
		 * 
		 * public void setSrcStatus(String srcStatus) { this.srcStatus = srcStatus; }
		 * 
		 * public String getMeesevaappno() { return meesevaappno; }
		 * 
		 * public void setMeesevaappno(String meesevaappno) { this.meesevaappno =
		 * meesevaappno; }
		 * 
		 * public String getHashval() { return hashval; }
		 * 
		 * public void setHashval(String hashval) { this.hashval = hashval; }
		 * 
		 * public String getSignature() { return signature; }
		 * 
		 * public void setSignature(String signature) { this.signature = signature; }
		 * 
		 * public int getNfsatypeId() { return nfsatypeId; }
		 * 
		 * public void setNfsatypeId(int nfsatypeId) { this.nfsatypeId = nfsatypeId; }
		 * 
		 * }
		 */