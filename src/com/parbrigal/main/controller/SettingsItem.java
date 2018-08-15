package com.parbrigal.main.controller;

public class SettingsItem {
	
	private int id;
	private String userName;
	private int dateType;
	private boolean passportDetail;
	private boolean includeCostCentre;
	private boolean includeDepartment;
	private boolean includeDivision;
	private boolean includePaypoint;
	private int paymentRate;
	private int employmentType;
	
	private DateSettingsItem dateSettingsItem;
	private OrgStrucSettingsItem costCentreSettingsItem;
	private OrgStrucSettingsItem departmentSettingsItem;
	private OrgStrucSettingsItem divSettingsItem;
	private OrgStrucSettingsItem paypointSettingsItem;
	private OrgStrucSettingsItem jobTitleSettingsItem;
	private OrgStrucSettingsItem jobGradeSettingsItem;
	
	
	public SettingsItem(int id,String userName,int dateType, boolean passportDetail, boolean includeCostCentre,
			boolean includeDepartment, boolean includeDivision, boolean includePaypoint,int paymentRate,int employmentType) {
		super();
		this.id = id;
		this.dateType = dateType;
		this.userName = userName;
		this.passportDetail = passportDetail;
		this.includeCostCentre = includeCostCentre;
		this.includeDepartment = includeDepartment;
		this.includeDivision = includeDivision;
		this.includePaypoint = includePaypoint;
		this.paymentRate = paymentRate;
		this.employmentType = employmentType;
	}
	public int getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	
	
	public int getDateType() {
		return dateType;
	}
	public void setDateType(int dateType) {
		this.dateType = dateType;
	}
	public boolean isPassportDetail() {
		return passportDetail;
	}
	public boolean isIncludeCostCentre() {
		return includeCostCentre;
	}
	public boolean isIncludeDepartment() {
		return includeDepartment;
	}
	public boolean isIncludePaypoint() {
		return includePaypoint;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassportDetail(boolean passportDetail) {
		this.passportDetail = passportDetail;
	}
	public void setIncludeCostCentre(boolean includeCostCentre) {
		this.includeCostCentre = includeCostCentre;
	}
	public void setIncludeDepartment(boolean includeDepartment) {
		this.includeDepartment = includeDepartment;
	}
	
	public boolean isIncludeDivision() {
		return includeDivision;
	}
	public void setIncludeDivision(boolean includeDivision) {
		this.includeDivision = includeDivision;
	}
	public void setIncludePaypoint(boolean includePaypoint) {
		this.includePaypoint = includePaypoint;
	}
	
	public int getPaymentRate() {
		return paymentRate;
	}
	public int getEmploymentType() {
		return employmentType;
	}
	public void setPaymentRate(int paymentRate) {
		this.paymentRate = paymentRate;
	}
	public void setEmploymentType(int employmentType) {
		this.employmentType = employmentType;
	}
	public DateSettingsItem getDateSettingsItem() {
		return dateSettingsItem;
	}
	public void setDateSettingsItem(DateSettingsItem dateSettingsItem) {
		this.dateSettingsItem = dateSettingsItem;
	}
	public OrgStrucSettingsItem getCostCentreSettingsItem() {
		return costCentreSettingsItem;
	}
	public void setCostCentreSettingsItem(OrgStrucSettingsItem costCentreSettingsItem) {
		this.costCentreSettingsItem = costCentreSettingsItem;
	}
	public OrgStrucSettingsItem getDepartmentSettingsItem() {
		return departmentSettingsItem;
	}
	public void setDepartmentSettingsItem(OrgStrucSettingsItem departmentSettingsItem) {
		this.departmentSettingsItem = departmentSettingsItem;
	}
	public OrgStrucSettingsItem getDivSettingsItem() {
		return divSettingsItem;
	}
	public OrgStrucSettingsItem getPaypointSettingsItem() {
		return paypointSettingsItem;
	}
	public void setDivSettingsItem(OrgStrucSettingsItem divSettingsItem) {
		this.divSettingsItem = divSettingsItem;
	}
	public void setPaypointSettingsItem(OrgStrucSettingsItem paypointSettingsItem) {
		this.paypointSettingsItem = paypointSettingsItem;
	}
	public OrgStrucSettingsItem getJobTitleSettingsItem() {
		return jobTitleSettingsItem;
	}
	public void setJobTitleSettingsItem(OrgStrucSettingsItem jobTitleSettingsItem) {
		this.jobTitleSettingsItem = jobTitleSettingsItem;
	}
	public OrgStrucSettingsItem getJobGradeSettingsItem() {
		return jobGradeSettingsItem;
	}
	public void setJobGradeSettingsItem(OrgStrucSettingsItem jobGradeSettingsItem) {
		this.jobGradeSettingsItem = jobGradeSettingsItem;
	}
	
	
	
	
	
	
	
	
	
}
