package com.parbrigal.main.controller;

import java.sql.Date;

public class DateSettingsItem {
	
	private int id;
	private Date employmentDate;
	private Date engagementDate;
	private Date irp5Date;
	private Date firstPayInterval;
	private Date startDate;
	private Date endDate;
	private Date jobGradeEffectiveDate;
	private Date jobTitleEffectiveDate;
	
	
	public DateSettingsItem()
	{
		
	}
	
	public DateSettingsItem(int id, Date employmentDate, Date engagementDate, Date irp5Date, Date firstPayInterval,
			Date startDate, Date endDate,Date jobGradeEffectiveDate,Date jobTitleEffectiveDate) {
		super();
		this.id = id;
		this.employmentDate = employmentDate;
		this.engagementDate = engagementDate;
		this.irp5Date = irp5Date;
		this.firstPayInterval = firstPayInterval;
		this.startDate = startDate;
		this.endDate = endDate;
		this.jobGradeEffectiveDate =jobGradeEffectiveDate;
		this.jobTitleEffectiveDate = jobTitleEffectiveDate;
	}
	public int getId() {
		return id;
	}
	public Date getEmploymentDate() {
		return employmentDate;
	}
	public Date getEngagementDate() {
		return engagementDate;
	}
	public Date getIrp5Date() {
		return irp5Date;
	}
	public Date getFirstPayInterval() {
		return firstPayInterval;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEmploymentDate(Date employmentDate) {
		this.employmentDate = employmentDate;
	}
	public void setEngagementDate(Date engagementDate) {
		this.engagementDate = engagementDate;
	}
	public void setIrp5Date(Date irp5Date) {
		this.irp5Date = irp5Date;
	}
	public void setFirstPayInterval(Date firstPayInterval) {
		this.firstPayInterval = firstPayInterval;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getJobGradeEffectiveDate() {
		return jobGradeEffectiveDate;
	}

	public Date getJobTitleEffectiveDate() {
		return jobTitleEffectiveDate;
	}

	public void setJobGradeEffectiveDate(Date jobGradeEffectiveDate) {
		this.jobGradeEffectiveDate = jobGradeEffectiveDate;
	}

	public void setJobTitleEffectiveDate(Date jobTitleEffectiveDate) {
		this.jobTitleEffectiveDate = jobTitleEffectiveDate;
	}
	
	
	
	
	
	
	
	
	
}
