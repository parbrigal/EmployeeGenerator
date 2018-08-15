package com.parbrigal.main.controller;

import java.io.Serializable;

public class Employee
  implements Serializable
{
  private static final long serialVersionUID = -2626768973154894882L;
  private String affirmativeActionStatus;
  private String empNo;
  private String name;
  private String surname;
  private String initials;
  private String title;
  private String idNumber;
  private String taxNumber;
  private String gender;
  private String dateOfBirth;
  private int age;
  private int maritalStatus;
  private String nationality;
  private int ethnicity;
  private String passPortIssueDate;
  private String passPortExpiryDate;
  private String passportNumber;
  private String passPortCountry;
  private int employmentStatus;
  private int paymentRate;
  private int rateOfPay;
  private boolean includeCostCentre;
  private boolean includeDepartment;
  private boolean includeDivision;
  private boolean includePayPoint;
  private String costCentre;
  private String department;
  private String division;
  private String payPoint;
  String employmentDate;
  String engagementDate;
  String irp5Date;
  String firstPayInterval;
  String jobGrade;
  String jobTitle;
  String jobTitleEffectiveDate;
  String jobGradeEffectiveDate;
  
  
  public Employee(String affirmativeActionStatus, String empNo, String name, String surname, String initials, String gender, String title, String idNumber, String taxNumber, String dateOfBirth, int age, int maritalStatus, String nationality, int ethnicity, int employmentStatus, int paymentRate, String passPortIssueDate, String passPortExpiryDate, String passportNumber, String passPortCountry, int rateOfPay,boolean includeCostCentre,String costCentre,boolean includeDepartment,String department,boolean includeDivision,String division, boolean includePayPoint, String payPoint,String employmentDate,String engagementDate,String irp5Date,String firstPayInterval,String jobTitle,String jobGrade,String jobTitleEffectiveDate,String jobGradeEffectiveDate)
  {
    this.affirmativeActionStatus = affirmativeActionStatus;
    this.empNo = empNo;
    this.name = name;
    this.surname = surname;
    this.initials = initials;
    this.gender = gender;
    this.title = title;
    this.idNumber = idNumber;
    this.taxNumber = taxNumber;
    this.dateOfBirth = dateOfBirth;
    this.age = age;
    this.maritalStatus = maritalStatus;
    this.nationality = nationality;
    this.ethnicity = ethnicity;
    this.passPortIssueDate = passPortIssueDate;
    this.passPortExpiryDate = passPortExpiryDate;
    this.passportNumber = passportNumber;
    this.passPortCountry = passPortCountry;
    this.employmentStatus = employmentStatus;
    this.paymentRate = paymentRate;
    this.rateOfPay = rateOfPay;
    this.includeCostCentre = includeCostCentre;
    this.costCentre = costCentre;
    this.includeDepartment = includeDepartment;
    this.department = department;
    this.includeDivision = includeDivision;
    this.division = division;
    this.includePayPoint = includePayPoint;
    this.payPoint = payPoint;
    this.jobGrade = jobGrade;
    this.jobTitle = jobTitle;
    this.jobTitleEffectiveDate = jobTitleEffectiveDate;
    this.jobGradeEffectiveDate = jobTitleEffectiveDate;
    this.employmentDate = employmentDate;
    this.engagementDate = engagementDate;
    this.irp5Date = irp5Date;
    this.firstPayInterval = firstPayInterval;
    
  }
  
  public String getEmpNo() {
    return empNo;
  }
  
  public void setEmpNo(String empNo) {
    this.empNo = empNo;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getSurname() {
    return surname;
  }
  
  public void setSurname(String surname) {
    this.surname = surname;
  }
  
  public String getIdNumber() {
    return idNumber;
  }
  
  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }
  
  public String getTaxNumber() {
    return taxNumber;
  }
  
  public void setTaxNumber(String taxNumber) {
    this.taxNumber = taxNumber;
  }
  
  public String getAffirmativeActionStatus() {
    return affirmativeActionStatus;
  }
  
  public void setAffirmativeActionStatus(String affirmativeActionStatus) {
    this.affirmativeActionStatus = affirmativeActionStatus;
  }
  
  public String getInitials() {
    return initials;
  }
  
  public void setInitials(String initials) {
    this.initials = initials;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getGender() {
    return gender;
  }
  
  public void setGender(String gender) {
    this.gender = gender;
  }
  
  
  
  public String getDateOfBirth() {
	return dateOfBirth;
  }

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

public int getAge()
  {
    return age;
  }
  
  public void setAge(int age) {
    this.age = age;
  }
  
  public int getMaritalStatus() {
    return maritalStatus;
  }
  
  public void setMaritalStatus(int maritalStatus) {
    this.maritalStatus = maritalStatus;
  }
  
  public String getNationality() {
    return nationality;
  }
  
  public void setNationality(String nationality) {
    this.nationality = nationality;
  }
  
  public int getEthnicity() {
    return ethnicity;
  }
  
  public void setEthnicity(int ethnicity) {
    this.ethnicity = ethnicity;
  }
  
  public String getPassPortIssueDate() {
    return passPortIssueDate;
  }
  
  public void setPassPortIssueDate(String passPortIssueDate) {
    this.passPortIssueDate = passPortIssueDate;
  }
  
  public String getPassPortExpiryDate()
  {
    return passPortExpiryDate;
  }
  
  public void setPassPortExpiryDate(String passPortExpiryDate) {
    this.passPortExpiryDate = passPortExpiryDate;
  }
  
  public String getPassportNumber() {
    return passportNumber;
  }
  
  public void setPassportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
  }
  
  public String getPassPortCountry()
  {
    return passPortCountry;
  }
  
  public void setPassPortCountry(String passPortCountry) {
    this.passPortCountry = passPortCountry;
  }
  
  public int getEmploymentStatus() {
    return employmentStatus;
  }
  
  public void setEmploymentStatus(int employmentStatus) {
    this.employmentStatus = employmentStatus;
  }
  
  public int getPaymentRate() {
    return paymentRate;
  }
  
  public void setPaymentRate(int paymentRate) {
    this.paymentRate = paymentRate;
  }
  
  public int getRateOfPay() {
    return rateOfPay;
  }
  
  public void setRateOfPay(int rateOfPay) {
    this.rateOfPay = rateOfPay;
  }

  public String getCostCentre() {
	return costCentre;
  }

  public void setCostCentre(String costCentre) {
	  this.costCentre = costCentre;
  }

  public String getDepartment() {
	return department;
  }

  public String getDivision() {
	return division;
  }

  public String getPayPoint() {
		return payPoint;
  }
	
  public void setDepartment(String department) {
		this.department = department;
  }
	
  public void setDivision(String division) {
		this.division = division;
  }
	
  public void setPayPoint(String payPoint) {
		this.payPoint = payPoint;
  }

  public String getEmploymentDate() {
	  return employmentDate;
  }

  public String getEngagementDate() {
	  return engagementDate;
  }

  public String getIrp5Date() {
	  return irp5Date;
  }

  public String getFirstPayInterval() {
	  return firstPayInterval;
  }

  public void setEmploymentDate(String employmentDate) {
	  this.employmentDate = employmentDate;
  }
	
  public void setEngagementDate(String engagementDate) {
	  this.engagementDate = engagementDate;
  }
	
  public void setIrp5Date(String irp5Date) {
	  this.irp5Date = irp5Date;
  }
	
  public void setFirstPayInterval(String firstPayInterval) {
	  this.firstPayInterval = firstPayInterval;
  }

  public String getJobGrade() {
	  return jobGrade;
  }

	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setJobGrade(String jobGrade) {
		this.jobGrade = jobGrade;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobTitleEffectiveDate() {
		return jobTitleEffectiveDate;
	}

	public String getJobGradeEffectiveDate() {
		return jobGradeEffectiveDate;
	}

	public void setJobTitleEffectiveDate(String jobTitleEffectiveDate) {
		this.jobTitleEffectiveDate = jobTitleEffectiveDate;
	}

	public void setJobGradeEffectiveDate(String jobGradeEffectiveDate) {
		this.jobGradeEffectiveDate = jobGradeEffectiveDate;
	}

	public boolean isIncludeCostCentre() {
		return includeCostCentre;
	}

	public void setIncludeCostCentre(boolean includeCostCentre) {
		this.includeCostCentre = includeCostCentre;
	}

	public boolean isIncludeDepartment() {
		return includeDepartment;
	}

	public boolean isIncludeDivision() {
		return includeDivision;
	}

	public boolean isIncludePayPoint() {
		return includePayPoint;
	}

	public void setIncludeDepartment(boolean includeDepartment) {
		this.includeDepartment = includeDepartment;
	}

	public void setIncludeDivision(boolean includeDivision) {
		this.includeDivision = includeDivision;
	}

	public void setIncludePayPoint(boolean includePayPoint) {
		this.includePayPoint = includePayPoint;
	}

  
}
