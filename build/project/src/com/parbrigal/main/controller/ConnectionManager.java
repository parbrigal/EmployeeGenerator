package com.parbrigal.main.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.parbrigal.model.QueryDB;

public class ConnectionManager {
	
	private static QueryDB query;
	public static void connect()
	{
		query = new QueryDB();
	}
	
	
	public static void clear() throws ClassNotFoundException, IOException, SQLException
	{
		query.clear();
	}
	
	public static List<Name> getNames() throws ClassNotFoundException, IOException, SQLException
	{
		return query.getNames();
	}
	
	public static List<Name> getSurnames() throws ClassNotFoundException, IOException, SQLException
	{
		return query.getSurnames();
	}
	
	public static List<OrgStructureItem> getOrgStructureData(TypeCodes type) throws ClassNotFoundException, IOException, SQLException
	{
		return query.getOrgStructureTableData(type);
	}
	
	public static SettingsItem getSettings() throws ClassNotFoundException, SQLException
	{
		return query.getSettings();
	}
	
	public static void saveSettings(SettingsItem item) throws ClassNotFoundException, SQLException
	{
		query.saveSettings(item);
	}
	
	public static void setOrgStructureData(TypeCodes type,String newOrgStruc) throws ClassNotFoundException, IOException, SQLException
	{
		query.setOrgStructureTableData(type, newOrgStruc);
	}
	
	public static void deleteOrgStrucData(TypeCodes type,int id) throws ClassNotFoundException, SQLException
	{
		query.deleteOrgStructure(type, id);
	}
	
	public static void updateOrgStrucData(TypeCodes type,int id,String newName) throws ClassNotFoundException, SQLException
	{
		query.updateOrgStructure(type, id,newName);
	}
	
	public static void drop() throws ClassNotFoundException, IOException, SQLException
	{
		 query.drop();
	}
	

}
