package com.parbrigal.main.controller;

public enum TypeCodes {
	
	  COST_CENTRES("Cost Centres"), 
	  DEPARTMENTS("Departments"), 
	  DIVISIONS("Divisions"), 
	  PAY_POINTS("Pay Points"),
	  JOB_TITLES("Job Titles"),
	  JOB_GRADES("Job Grades");
	
	
	  String type;
	  
	  TypeCodes(String type)
	  {
	    this.type = type;
	  }
	  
	  @Override
	  public String toString() {
	    return type;
	  }
	  
}
