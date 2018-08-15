package com.parbrigal.main.controller;

public enum EmploymentTypeCodes {
	  
	  ALL_PERMANENT(1,"Fixed"),
	  ALL_TEMPS(2,"Random"),
	  ALL_CASUALS(3,"All Casuals"),
	  MOSTLY_PERMANENT(4,"Mostly Permanent"),
	  ALL_RANDOM(5,"All Random"),; 
	
	  int id;
	  String type;
	  
	  EmploymentTypeCodes(int id,String type)
	  {
		this.id = id;
	    this.type = type;
	  }
	  
	  @Override
	  public String toString() {
	    return type;
	  }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static EmploymentTypeCodes getCodeFromInt(int code)
	{
		for (EmploymentTypeCodes codes : EmploymentTypeCodes.values())
		{
			if (codes.getId() == code)
			{
				return codes;
			}
		}
		return null;
	}
	  
	  
}
