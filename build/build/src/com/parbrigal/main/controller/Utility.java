package com.parbrigal.main.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Utility 
{
	
	private static List<OrgStructureItem> costCentres;
	private static List<OrgStructureItem> departments;
	private static List<OrgStructureItem> divisions;
	private static List<OrgStructureItem> paypoints;
	private static List<OrgStructureItem> jobtitles;
	private static List<OrgStructureItem> jobGrades;
	
	
	public static OrgStructureItem getOrgStructureItem(List<OrgStructureItem> list,int code)
	{
		for (OrgStructureItem item : list)
		{
			if (item.getId() == code)
			{
				return item;
			}
		}
		return null;
	}
	
	public static OrgStructureItem getOrgStructureItem(TypeCodes type,int code)
	{
		switch (type)
		{
			case COST_CENTRES :
			{
				for (OrgStructureItem item : costCentres)
				{
					if (item.getId() == code)
					{
						return item;
					}
				}
			}
			case DEPARTMENTS :
			{
				for (OrgStructureItem item : departments)
				{
					if (item.getId() == code)
					{
						return item;
					}
				}
			}
			case DIVISIONS :
			{
				for (OrgStructureItem item : divisions)
				{
					if (item.getId() == code)
					{
						return item;
					}
				}
			}
			case PAY_POINTS :
			{
				for (OrgStructureItem item : paypoints)
				{
					if (item.getId() == code)
					{
						return item;
					}
				}
			}
			case JOB_GRADES :
			{
				for (OrgStructureItem item : jobGrades)
				{
					if (item.getId() == code)
					{
						return item;
					}
				}
			}
			case JOB_TITLES :
			{
				for (OrgStructureItem item : jobtitles)
				{
					if (item.getId() == code)
					{
						return item;
					}
				}
			}
		}
		
		return null;
	}
	
	public static void prepare() throws ClassNotFoundException, IOException, SQLException
	{
		costCentres = ConnectionManager.getOrgStructureData(TypeCodes.COST_CENTRES);
		departments = ConnectionManager.getOrgStructureData(TypeCodes.DEPARTMENTS);
		divisions = ConnectionManager.getOrgStructureData(TypeCodes.DIVISIONS);
		paypoints = ConnectionManager.getOrgStructureData(TypeCodes.PAY_POINTS);
		jobGrades = ConnectionManager.getOrgStructureData(TypeCodes.JOB_GRADES);
		jobtitles = ConnectionManager.getOrgStructureData(TypeCodes.JOB_TITLES);
	}

	public static List<OrgStructureItem> getCostCentres() 
	{
		return costCentres;
	}
	public static List<OrgStructureItem> getDepartments() 
	{
		return departments;
	}
	public static List<OrgStructureItem> getDivisions() 
	{
		return divisions;
	}
	public static List<OrgStructureItem> getPayPoints() 
	{
		return paypoints;
	}

	public static List<OrgStructureItem> getJobtitles() {
		return jobtitles;
	}

	public static List<OrgStructureItem> getJobGrades() {
		return jobGrades;
	}


	
	
	
	
	
	
}
