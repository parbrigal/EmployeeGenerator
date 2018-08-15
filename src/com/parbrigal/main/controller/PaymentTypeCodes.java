package com.parbrigal.main.controller;

public enum PaymentTypeCodes 
{
	  HOURLY(1,"Hourly"),
	  DAILY(2,"Daily"),
	  MONTHLY(3,"Monthly");
	
	  int id;
	  String type;
	  
	  PaymentTypeCodes(int id,String type)
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
	
	public static PaymentTypeCodes getCodeFromInt(int code)
	{
		for (PaymentTypeCodes codes : PaymentTypeCodes.values())
		{
			if (codes.getId() == code)
			{
				return codes;
			}
		}
		return null;
	}
	  
	  
}
