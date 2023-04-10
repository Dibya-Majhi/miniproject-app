package com.example.request;

import java.time.LocalDate;


public class SearchRequest {
	
	private Integer CitizenId;
	private String CitizenName;
	private String gender;
	private String planName;
	private String planStatus;
	private String planStartDate;
	private String  planEndDate;
	private Double benefitAmt;
	private String denialReason;
	private LocalDate terminationDate;
	private String terminationRsn;
	public Integer getCitizenId() {
		return CitizenId;
	}
	public void setCitizenId(Integer citizenId) {
		CitizenId = citizenId;
	}
	public String getCitizenName() {
		return CitizenName;
	}
	public void setCitizenName(String citizenName) {
		CitizenName = citizenName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public String getPlanStartDate() {
		return planStartDate;
	}
	public void setPlanStartDate(String planStartDate) {
		this.planStartDate = planStartDate;
	}
	public String getPlanEndDate() {
		return planEndDate;
	}
	public void setPlanEndDate(String planEndDate) {
		this.planEndDate = planEndDate;
	}
	public Double getBenefitAmt() {
		return benefitAmt;
	}
	public void setBenefitAmt(Double benefitAmt) {
		this.benefitAmt = benefitAmt;
	}
	public String getDenialReason() {
		return denialReason;
	}
	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}
	public LocalDate getTerminationDate() {
		return terminationDate;
	}
	public void setTerminationDate(LocalDate terminationDate) {
		this.terminationDate = terminationDate;
	}
	public String getTerminationRsn() {
		return terminationRsn;
	}
	public void setTerminationRsn(String terminationRsn) {
		this.terminationRsn = terminationRsn;
	}
	
	
	
	
}
