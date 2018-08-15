package com.parbrigal.main.controller;



import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.parbrigal.model.CountryCodes;
import com.parbrigal.model.GenEmployeeDetail;


public class EmployeeCreator implements Iterable<Employee>
{
	  private List<Employee> employees = new ArrayList<Employee>();
	  int minAge = 18;
	  int maxAge = 65;
	  
	  private boolean includeCostCentre;
	  private boolean fixedCostCentre;
	  
	  private boolean includeDepartment;
	  private boolean fixedDepartment;
	  
	  private boolean includeDivision;
	  private boolean fixedDivision;
	  
	  private boolean includePayPoint;
	  private boolean fixedPayPoint;
	  
	  private boolean fixedJobTitle;
	  private boolean fixedJobGrade;
	  
	  private boolean randomDate;
  
	  public EmployeeCreator()
	  {
		  
	  }
  
	  public EmployeeCreator(String incEmpNo, int no, boolean incRateOfPayYN, int minRateOfPay, int maxRateOfPay) throws ClassNotFoundException, IOException, SQLException
	  {
		 Utility.prepare();
		 
		 SettingsItem settings = ConnectionManager.getSettings();
		 String affirmativeActionStatus = null;
		 String name = "";
	     String surname = "";
	     String empNo = "";
	     String costCentre = "";
	     String department = "";
	     String division = "";
	     String payPoint = "";
	     String employmentDate ="";
	     String engagementDate="";
	     String irp5Date="";
	     String firstPayInterval="";
	     String jobTitle="";
	     String jobGrade="";
	     String jobTitleEffectiveDate = "";
	     String jobGradeEffectiveDate = "";
	     
	     randomDate = settings.getDateType() == 1;
	     
	     if (settings.isIncludeCostCentre())
	     {
	    	 includeCostCentre = true;
	    	 if (settings.getCostCentreSettingsItem().isFixed())
	    	 {
	    		 fixedCostCentre = true;
	    		 OrgStructureItem cc = Utility.getOrgStructureItem(TypeCodes.COST_CENTRES, settings.getCostCentreSettingsItem().getFixedValue());
	    		 costCentre = cc.getName();
	    	 }
	     }
	     
	     if (settings.isIncludeDepartment())
	     {
	    	 includeDepartment = true;
	    	 if (settings.getDepartmentSettingsItem().isFixed())
	    	 {
	    		 fixedDepartment = true;
	    		 OrgStructureItem dep = Utility.getOrgStructureItem(TypeCodes.DEPARTMENTS, settings.getDepartmentSettingsItem().getFixedValue());
	    		 department = dep.getName();
	    	 }
	     }
	     
	     if (settings.isIncludeDivision())
	     {
	    	 includeDivision = true;
	    	 if (settings.getDivSettingsItem().isFixed())
	    	 {
	    		 fixedDivision = true;
	    		 OrgStructureItem div = Utility.getOrgStructureItem(TypeCodes.DIVISIONS, settings.getDivSettingsItem().getFixedValue());
	    		 department = div.getName();
	    	 }
	     }
	     
	     if (settings.isIncludePaypoint())
	     {
	    	 includePayPoint = true;
	    	 if (settings.getPaypointSettingsItem().isFixed())
	    	 {
	    		 fixedPayPoint = true;
	    		 OrgStructureItem pp = Utility.getOrgStructureItem(TypeCodes.PAY_POINTS, settings.getPaypointSettingsItem().getFixedValue());
	    		 payPoint = pp.getName();
	    	 }
	     }
	     
	     if (settings.getJobGradeSettingsItem().isFixed())
	     {
	    	 fixedJobGrade = true;
	    	 OrgStructureItem jg = Utility.getOrgStructureItem(TypeCodes.JOB_GRADES, settings.getJobGradeSettingsItem().getFixedValue());
    		 jobGrade = jg.getName();
	     }
	     
	     if (settings.getJobTitleSettingsItem().isFixed())
	     {
	    	 fixedJobTitle = true;
	    	 OrgStructureItem jt = Utility.getOrgStructureItem(TypeCodes.JOB_TITLES, settings.getJobTitleSettingsItem().getFixedValue());
    		 jobTitle = jt.getName();
	     }
	     
	     for (int x = 0; x < no; x++)
	     {
	    	 affirmativeActionStatus = GenEmployeeDetail.getAffirm();
	    	 empNo = GenEmployeeDetail.getAlphIncrement(incEmpNo) + (GenEmployeeDetail.getDigIncrement(incEmpNo) + x);
	
	      
	    	 String idNumber = GenEmployeeDetail.getID(minAge, maxAge);
	      
	    	 String taxNumber = GenEmployeeDetail.getTax();
	    	 String gender = GenEmployeeDetail.getGender(idNumber);
	    	 String title = GenEmployeeDetail.getTitle(gender);
	    	 String dob = GenEmployeeDetail.getDOB(idNumber);
	    	 int age = GenEmployeeDetail.getAge(dob);
	    	 int maritalStatus = GenEmployeeDetail.getMaritalStatus();
	    	 String nationality = GenEmployeeDetail.getNationality(idNumber);
	    	 int ethnicity = GenEmployeeDetail.getEthnicPersuasion(affirmativeActionStatus);
	      
	    	 if ((affirmativeActionStatus.equals("N") & gender.equals("Male"))) 
	    	 {
	    		 name = GenEmployeeDetail.readRandomName(affirmativeActionStatus, gender);
	    		 surname = GenEmployeeDetail.readRandomSurname(affirmativeActionStatus);
	    	 }
	    	 else if ((affirmativeActionStatus.equals("N") & gender.equals("Female"))) 
	    	 {
	    		 name = GenEmployeeDetail.readRandomName(affirmativeActionStatus, gender);
	    		 surname = GenEmployeeDetail.readRandomSurname(affirmativeActionStatus);
	    	 }
	    	 else if ((affirmativeActionStatus.equals("Y") & gender.equals("Female"))) {
	        name = GenEmployeeDetail.readRandomName(affirmativeActionStatus, gender);
	        surname = GenEmployeeDetail.readRandomSurname(affirmativeActionStatus);
	      }
	      else if ((affirmativeActionStatus.equals("Y") & gender.equals("Male"))) {
	    	  name = GenEmployeeDetail.readRandomName(affirmativeActionStatus, gender);
	    	  surname = GenEmployeeDetail.readRandomSurname(affirmativeActionStatus);
	      }
	      
	
	      String initials = GenEmployeeDetail.ReadInitial(name);
	      
	      String passPortIssueDate = "";
	      String passPortExpiryDate = "";
	      String passPortNo = "";
	      CountryCodes passPortCode = null;
	      String passPortCountry = "";
	      
	      if (settings.isPassportDetail())
	      {
	    	  passPortIssueDate = GenEmployeeDetail.passPortIssueDate();
	    	  passPortExpiryDate = GenEmployeeDetail.passPortExpirydate(passPortIssueDate);
	    	  passPortCode = GenEmployeeDetail.getPassPortCountryCode();
	    	  passPortNo = passPortCode + GenEmployeeDetail.getPassportNo();
	    	  passPortCountry = String.valueOf(passPortCode);
	      }
	      
	      int paymentRate = GenEmployeeDetail.getPaymentRate(PaymentTypeCodes.getCodeFromInt(settings.getPaymentRate()));
	      
	      if ((minRateOfPay == 0) && (maxRateOfPay == 0)) 
	      {
	    	  minRateOfPay = 5000;
	    	  maxRateOfPay = 20000;
	      }
	      
	      int rateOfPay = GenEmployeeDetail.getRateOfPay(incRateOfPayYN, minRateOfPay, maxRateOfPay);
	      
	      int employmentType = GenEmployeeDetail.getEmploymentStatus(EmploymentTypeCodes.getCodeFromInt(settings.getEmploymentType()));
	      
	      
	      if (includeCostCentre)
	      {
	    	  if (!fixedCostCentre)
	    	  {
	    		  Random randomCC = new Random();
	    		  int ccId = randomCC.nextInt(Utility.getCostCentres().size()) + 0;
	    		  OrgStructureItem cc= Utility.getCostCentres().get(ccId);
	    		  costCentre = cc.getName();
	    	  }
	      }
	      
	      if (includeDepartment)
	      {
	    	  if (!fixedDepartment)
	    	  {
	    		  Random randomDep = new Random();
	    		  int depId = randomDep.nextInt(Utility.getDepartments().size()) + 0;
	    		  OrgStructureItem dep= Utility.getCostCentres().get(depId);
	    		  department = dep.getName();
	    	  }
	      }
	      if (includeDivision)
	      {
	    	  if (!fixedDivision)
	    	  {
	    		  Random randomDiv = new Random();
	    		  int divId = randomDiv.nextInt(Utility.getDivisions().size()) + 0;
	    		  OrgStructureItem div = Utility.getDivisions().get(divId);
	    		  division = div.getName();
	    	  }
	      }
	      if (includePayPoint)
	      {
	    	  if (!fixedPayPoint)
	    	  {
	    		  Random randomP = new Random();
	    		  int ppId = randomP.nextInt(Utility.getPayPoints().size()) + 0;
	    		  OrgStructureItem pp = Utility.getDivisions().get(ppId);
	    		  payPoint = pp.getName();
	    	  }
	      }
	      
	      if (!fixedJobGrade)
    	  {
    		  Random randomP = new Random();
    		  int ppId = randomP.nextInt(Utility.getJobGrades().size()) + 0;
    		  OrgStructureItem pp = Utility.getJobGrades().get(ppId);
    		  payPoint = pp.getName();
    	  }
	      
	      if (!fixedJobTitle)
    	  {
    		  Random randomP = new Random();
    		  int ppId = randomP.nextInt(Utility.getJobtitles().size()) + 0;
    		  OrgStructureItem pp = Utility.getJobtitles().get(ppId);
    		  payPoint = pp.getName();
    	  }
	      
	      if (randomDate)
	      {
	    	  String rd = GenEmployeeDetail.getRandomDate(settings.getDateSettingsItem().getStartDate(), settings.getDateSettingsItem().getEndDate());
	    	  employmentDate = rd;
	    	  engagementDate = rd;
	    	  irp5Date = rd;
	    	  firstPayInterval = rd;
	    	  jobGradeEffectiveDate = rd;
	    	  jobTitleEffectiveDate = rd;
	      }
	      else
	      {
	    	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
	    	  
	    	  employmentDate = settings.getDateSettingsItem().getEmploymentDate().toLocalDate().format(formatter);
	    	  engagementDate = settings.getDateSettingsItem().getEngagementDate().toLocalDate().format(formatter);
	    	  irp5Date = settings.getDateSettingsItem().getIrp5Date().toLocalDate().format(formatter);
	    	  firstPayInterval = settings.getDateSettingsItem().getFirstPayInterval().toLocalDate().format(formatter);
	    	  jobTitleEffectiveDate = settings.getDateSettingsItem().getJobTitleEffectiveDate().toLocalDate().format(formatter);
	    	  jobGradeEffectiveDate = settings.getDateSettingsItem().getJobGradeEffectiveDate().toLocalDate().format(formatter);
	      }
	      
	      Employee employee = new Employee(affirmativeActionStatus, empNo, name, surname, initials, gender, title, idNumber, taxNumber, dob, age, maritalStatus, nationality, ethnicity, employmentType, paymentRate, passPortIssueDate, passPortExpiryDate, passPortNo, passPortCountry, rateOfPay,includeCostCentre,costCentre,includeDepartment,department,includeDivision,division,includePayPoint,payPoint,employmentDate,engagementDate,irp5Date,firstPayInterval,jobTitle,jobGrade,jobTitleEffectiveDate,jobGradeEffectiveDate);
	      
	      employees.add(employee);
	    } 
	    
	  }
  
  
  public List<Employee> getEmployees()
  {
    return employees;
  }
  
  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }
  
  public void clearEmployees() {
    employees.clear();
  }
  
  public int getEmployeesCount() {
    return employees.size();
  }
  
  public Iterator<Employee> iterator()
  {
    return new EmployeeIterator(employees);
  }
  
  public void populateNames() throws ClassNotFoundException, IOException, SQLException
  {
	  GenEmployeeDetail.populateNames();
  }
}
