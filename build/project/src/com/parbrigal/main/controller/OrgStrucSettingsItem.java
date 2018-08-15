package com.parbrigal.main.controller;

public class OrgStrucSettingsItem {
	
	private int id;
	private boolean fixed;
	private int fixedValue;
	
	public OrgStrucSettingsItem()
	{
		
	}
	
	public OrgStrucSettingsItem(int id, boolean fixed, int fixedValue) 
	{
		this.id = id;
		this.fixed = fixed;
		this.fixedValue = fixedValue;
	}

	public int getId() {
		return id;
	}

	public boolean isFixed() {
		return fixed;
	}

	public int getFixedValue() {
		return fixedValue;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

	public void setFixedValue(int fixedValue) {
		this.fixedValue = fixedValue;
	}
	
	
	
	

}
