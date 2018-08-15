package com.parbrigal.main.controller;

public enum HierarchyCodes {
	  
	  FIXED(1,"Fixed"),
	  RANDOM(2,"Random"); 
	
	  int id;
	  String type;
	  
	  HierarchyCodes(int id,String type)
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
	
	public static HierarchyCodes getCodeFromInt(int code)
	{
		for (HierarchyCodes codes : HierarchyCodes.values())
		{
			if (codes.getId() == code)
			{
				return codes;
			}
		}
		return null;
	}
	  
	  
}
