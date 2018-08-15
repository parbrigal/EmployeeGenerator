package com.parbrigal.main.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ExcelFile {
	
	public void masterInfoToExcel(List<Employee> employees, File file)
	{
	    try
	    {
	      FileWriter excel = new FileWriter(file);
	      StringBuilder heading = new StringBuilder();
	      heading.append("**Employee Number,"); //0
	      heading.append("Nature of Employee,");//1
	      heading.append("Surname,");//2
	      heading.append("First Name,");//3
	      heading.append("Initials,");//4
	      heading.append("Title,");//5
	      heading.append("Preferred Name,");//6
	      heading.append("Gender,");//7
	      heading.append("Affirmative,");//8
	      heading.append("ID Number,");//9
	      heading.append("Passport Number,"); //10
	      heading.append("Issue Date,"); //11
	      heading.append("Expiry Date,"); //12
	      heading.append("Country of Citizenship,"); //13
	      heading.append("Date Of Birth,");//14
	      heading.append("Place of Birth,");//15
	      heading.append("Company Number,");//16
	      heading.append("Income Tax Number,");//17
	      heading.append("Revenue Office,");//18
	      heading.append("Marital Status,");//19
	      heading.append("Home Phone Number,");//20
	      heading.append("Work Phone Number,"); //21
	      heading.append("Cell Number Private,");//22
	      heading.append("E-Mail,");//23
	      heading.append("E-Mail Payslip Advice,");//24
	      heading.append("E-Mail Password,");//25
	      heading.append("Alternate E-Mail Address,"); //26
	      heading.append("Foreign National,"); //27
	      heading.append("Nationality,");//28
	      heading.append("Home Language,");//29
	      heading.append("Religion,");//30
	      heading.append("Ethnic Persuasion,");//31
	      heading.append("Number of Dependants,");//32
	      heading.append("Disabled,");//33
	      heading.append("Nature of Disability,");//34
	      heading.append("Payment Method,");//35
	      heading.append("Bank Acc. No.,");//36
	      heading.append("Bank Acc. Type,");//37
	      heading.append("Bank Branch Code,");//38
	      heading.append("Bank Ref. No.,");//39
	      heading.append("Daily Limit,");//40
	      heading.append("Monthly Limit,");//41
	      heading.append("Account Holders Relationship,");//42
	      heading.append("Employment Type,");//43
	      heading.append("Employment Date,");//44
	      heading.append("Engagement Date,");//45
	      heading.append("First Pay Interval Date,");//46
	      heading.append("IRP5 Start Date,");//47
	      heading.append("Job Grade Name,");//48
	      heading.append("Job Grade Effective Date,");//49
	      heading.append("Job Title,");//50
	      heading.append("Job Title Effective Date,");//51
	      heading.append("Probation Start Date,"); //52
	      heading.append("Probation Period Type,"); //53
	      heading.append("Probation Period,"); //54
	      heading.append("Probation End Date,"); //55
	      heading.append("Internal Phone Number,"); //56
	      heading.append("Cost Centre Name,");//57
	      heading.append("Department Name,");//58
	      heading.append("Division Name,");//59
	      heading.append("Pay Point Description,");//60
	      heading.append("Retirement Date,");//61
	      heading.append("Retirement Reason,"); //62
	      heading.append("Alternate Job Grade,"); //63
	      heading.append("Alternate Job Grade Effective Date,");//64
	      heading.append("Industry Employment Types,");//65
	      heading.append("Industry Wage Category,");//66
	      heading.append("Working Hours in Month,");
	      heading.append("Working Hours in Day,");
	      heading.append("Working Days in Week,");
	      heading.append("Working Hours in Pay Period,"); //70
	      heading.append("Shift Worker,");
	      heading.append("Hours per Shift,");
	      heading.append("Shifts per Pay Period,");
	      heading.append("Shifts per Month,");
	      heading.append("Shifts per Annum,"); //75
	      heading.append("Payment Rate,");
	      heading.append("UIF Overridden,");	
	      heading.append("UIF Override Reason,");
	      heading.append("Skills Levy Exempted,");
	      heading.append("Skills Levy Exemption Reason,"); //80
	      heading.append("Voluntary Tax Overdeduct,");
	      heading.append("Voluntary Tax Overdeduct Effective Date,");	
	      heading.append("Voluntary Tax Overdeduct Amount,");
	      heading.append("Tax Override Method,");
	      heading.append("Tax Directive Number,"); //85
	      heading.append("Tax Override Effective Date,");
	      heading.append("Tax Override Percentage,");
	      heading.append("Override Amount,");	
	      heading.append("Exclude from Bonus Provision for GL Purposes,");
	      heading.append("Exclude from Leave Provision for GL Purposes,"); //90
	      heading.append("SMS Nett Pay,"); //91
	      heading.append("Cell Number Business,");//92
	      heading.append("Agency,");//93
	      excel.write(heading.toString());

	      excel.write("\n");
	      
	      for (int i = 0; i < employees.size(); i++)
	      {
	        for (Iterator iterator = employees.iterator(); iterator.hasNext();)
	        {
	          Employee emp = (Employee)iterator.next();
	          

	          excel.write(emp.getEmpNo() + ",");//1
	          excel.write("A" + ",");//2
	          excel.write(emp.getSurname() + ",");//3
	          excel.write(emp.getName() + ",");
	          excel.write(emp.getInitials() + ",");
	          excel.write(convertTitletoAPI(emp.getTitle()) + ",");
	          excel.write(",");
	          excel.write(String.valueOf(convertGendertoAPI(emp.getGender())));
	          excel.write(",");
	          excel.write(emp.getAffirmativeActionStatus());
	          excel.write(",");
	          excel.write(emp.getIdNumber());
	          excel.write(",");
	          excel.write(emp.getPassportNumber());
	          excel.write(",");
	          excel.write(emp.getPassPortIssueDate());
	          excel.write(",");
	          excel.write(emp.getPassPortExpiryDate());
	          excel.write(",");
	          excel.write(emp.getPassPortCountry());
	          excel.write(",");
	          excel.write(emp.getDateOfBirth());
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(emp.getTaxNumber());
	          excel.write(",");
	          excel.write(",");
	          excel.write(String.valueOf(emp.getMaritalStatus()));
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(emp.getNationality());
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(String.valueOf(emp.getEthnicity()));
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write("1");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(emp.getEmploymentStatus());
	          excel.write(",");
	          excel.write(emp.getEmploymentDate());
	          excel.write(",");
	          excel.write(emp.getEngagementDate());
	          excel.write(",");
	          excel.write(emp.getFirstPayInterval());
	          excel.write(",");
	          excel.write(emp.getIrp5Date());
	          excel.write(",");
	          excel.write(emp.getJobGrade());
	          excel.write(",");
	          excel.write(emp.getJobGradeEffectiveDate());
	          excel.write(",");
	          excel.write(emp.getJobTitle());
	          excel.write(",");
	          excel.write(emp.getJobTitleEffectiveDate());
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          if (emp.isIncludeCostCentre()) {
	            excel.write(emp.getCostCentre());
	            excel.write(",");
	          }
	          else  
	          {
	            excel.write(",");
	          }
	          if (emp.isIncludeDepartment()) {
	            excel.write(emp.getDepartment());
	            excel.write(",");
	          }
	          else 
	          {
	            excel.write(",");
	          }
	          if (emp.isIncludeDivision()) {
	            excel.write(emp.getDivision());
	            excel.write(",");
	          }
	          else  
	          {
	            excel.write(",");
	          }
	          if (emp.isIncludePayPoint()) 
	          {
	            excel.write(emp.getPayPoint());
	            excel.write(",");
	          }
	          else
	          {
	            excel.write(",");
	          }
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(emp.getPaymentRate());
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write(",");
	          excel.write("\n");
	        }
	        
	        excel.close();
	      }
	    } catch (IOException e) {
	      System.out.println(e);
	    }
	}
//	  
//	  public static void packageInfoToExcel(List<Employee> employees, File file) {
//	    try {
//	      FileWriter excel = new FileWriter(file);
//	      
//	      excel.write("Employee Number,Pay Rate,Payment Rate,Package Amendment Reason,Package Amend,Equity Promotion,Comments,Interface Code,Value,Taxable,Quantity");
//	      
//	      excel.write("\n");
//	      
//	      for (int i = 0; i < employees.size(); i++)
//	      {
//	        for (Iterator iterator = employees.iterator(); iterator.hasNext();)
//	        {
//	          Employee emp = (Employee)iterator.next();
//	          
//	          excel.write(emp.getEmpNo());
//	          excel.write(",");
//	          excel.write(emp.getRateOfPay());
//	          excel.write(",");
//	          excel.write(emp.getPaymentRate());
//	          excel.write(",");
//	          excel.write(",");
//	          excel.write(",");
//	          excel.write(",");
//	          excel.write(",");
//	          excel.write(",");
//	          excel.write(",");
//	          excel.write(",");
//	          excel.write("\n");
//	        }
//	        
//	        excel.close();
//	      }
//	    } catch (IOException e) {
//	      System.out.println(e);
//	    }
//	  }
//	  
	  private int convertGendertoAPI(String gender)
	  {
	    int genderCode = 0;
	    if (gender.equals("Male")) {
	      genderCode = 1;
	    }
	    if (gender.equals("Female")) {
	      genderCode = 2;
	    }
	    return genderCode;
	  }
  
	  private static int convertTitletoAPI(String title)
	  {
	    int titleNumber = 0;
	    
	    if (title.equals("Mr")) {
	      titleNumber = 1;
	    }
	    else if (title.equals("Mrs")) {
	      titleNumber = 2;
	    }
	    else if (title.equals("Ms")) {
	      titleNumber = 3;
	    }
	    else if (title.equals("Miss")) {
	      titleNumber = 4;
	    }
	    else if (title.equals("Prof")) {
	      titleNumber = 5;
	    }
	    else if (title.equals("Hon")) {
	      titleNumber = 6;
	    }
	    else if (title.equals("Dr")) {
	      titleNumber = 8;
	    }
	    return titleNumber;
	  }
}
