package com.parbrigal.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.parbrigal.main.controller.DateSettingsItem;
import com.parbrigal.main.controller.Name;
import com.parbrigal.main.controller.OrgStrucSettingsItem;
import com.parbrigal.main.controller.OrgStructureItem;
import com.parbrigal.main.controller.SettingsItem;
import com.parbrigal.main.controller.TypeCodes;


public class QueryDB 
{
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:zaqae";
	

	public void run() throws ClassNotFoundException, IOException, SQLException
	{
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(JDBC_URL);
		
		Statement statement = conn.createStatement();
		
		ResultSet resultSet = statement.executeQuery("select * from wMNames");
		
		while (resultSet.next())
			resultSet.getString(2);
		
		if (statement != null) statement.close();
		if (conn != null) conn.close();
	}
	
	public void clear() throws ClassNotFoundException, IOException, SQLException
	{
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(JDBC_URL);
		
		Statement statement = conn.createStatement();
		
		ResultSet resultSet = statement.executeQuery("truncate table wMNames");
		
		while (resultSet.next())
			resultSet.getString(2);
		
		if (statement != null) statement.close();
		if (conn != null) conn.close();
	}
	
	public List<Name> getNames() throws ClassNotFoundException, IOException, SQLException
	{
		List<Name> names = new ArrayList<Name>();
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(JDBC_URL);
		
		Statement statement = conn.createStatement();
		
		ResultSet eResultSet = statement.executeQuery("select * from e_Names");
		
		while (eResultSet.next())
			names.add(new Name(eResultSet.getInt(1),eResultSet.getString(2),eResultSet.getBoolean(3) ? "AA" : "Non-AA",eResultSet.getString(4)));
		
		if (statement != null) statement.close();
		if (conn != null) conn.close();
		
		return names;
	}
	
	public List<Name> getSurnames() throws ClassNotFoundException, IOException, SQLException
	{
		List<Name> names = new ArrayList<Name>();
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(JDBC_URL);
		
		Statement statement = conn.createStatement();
		
		ResultSet eResultSet = statement.executeQuery("select * from e_Surnames");
		
		while (eResultSet.next())
			names.add(new Name(eResultSet.getInt(1),eResultSet.getString(2),eResultSet.getBoolean(3) ? "AA" : "Non-AA","N/A"));
		
		if (statement != null) statement.close();
		if (conn != null) conn.close();
		
		return names;
	}
	
	public void setOrgStructureTableData(TypeCodes type,String newOrgStruc) throws ClassNotFoundException, SQLException
	{
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(JDBC_URL);
		String insertSQL = null;
		switch (type)
		{
			case COST_CENTRES :
			{
				insertSQL = ("insert into e_CostCentres (name) values (?)");
				break;
			}
			case DEPARTMENTS :
			{
				insertSQL = ("insert into e_Departments (name) values (?)");
				break;
			}
			case DIVISIONS :
			{
				insertSQL = ("insert into e_Divisions (name) values (?)");
				break;
			}
			case PAY_POINTS :
			{
				insertSQL = ("insert into e_PayPoints (name) values (?)");
				break;
			}
			case JOB_TITLES :
			{
				insertSQL = ("insert into e_JobTitles (name) values (?)");
				break;
			}
			case JOB_GRADES :
			{
				insertSQL = ("insert into e_JobGrades (name) values (?)");
				break;
			}
		}
		
		PreparedStatement ps = conn.prepareStatement(insertSQL);
		ps.setString(1,newOrgStruc);
		ps.execute();
		conn.commit();
		if (ps != null) ps.close();
		if (conn != null) conn.close();
	}
	
	public void deleteOrgStructure(TypeCodes type,int orgStruc) throws ClassNotFoundException, SQLException
	{
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(JDBC_URL);
		String insertSQL = null;
		switch (type)
		{
			case COST_CENTRES :
			{
				insertSQL = ("delete from e_CostCentres where id = (?)");
				break;
			}
			case DEPARTMENTS :
			{
				insertSQL = ("delete from e_Departments where id = (?)");
				break;
			}
			case DIVISIONS :
			{
				insertSQL = ("delete from e_Divisions where id =  (?)");
				break;
			}
			case PAY_POINTS :
			{
				insertSQL = ("delete from e_PayPoints where id = (?)");
				break;
			}
			case JOB_TITLES :
			{
				insertSQL = ("delete from e_JobTitles where id = (?)");
				break;
			}
			case JOB_GRADES :
			{
				insertSQL = ("delete from e_JobTitles where id = (?)");
				break;
			}
		}
		
		PreparedStatement ps = conn.prepareStatement(insertSQL);
		ps.setInt(1,orgStruc);
		ps.execute();
		conn.commit();
		if (ps != null) ps.close();
		if (conn != null) conn.close();
	}
	
	public List<OrgStructureItem> getOrgStructureTableData(TypeCodes type) throws ClassNotFoundException, SQLException
	{
		List<OrgStructureItem> lst = new ArrayList<OrgStructureItem>();
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(JDBC_URL);
		
		Statement statement = conn.createStatement();
		ResultSet rslt = null;
		switch (type)
		{
			case COST_CENTRES :
			{
				rslt = statement.executeQuery("select * from e_CostCentres");
				break;
			}
			case DEPARTMENTS :
			{
				rslt = statement.executeQuery("select * from e_Departments");
				break;
			}
			case DIVISIONS :
			{
				rslt = statement.executeQuery("select * from e_Divisions");
				break;
			}
			case PAY_POINTS :
			{
				rslt = statement.executeQuery("select * from e_PayPoints");
				break;
			}
			case JOB_GRADES :
			{
				rslt = statement.executeQuery("select * from e_JobGrades");
				break;
			}
			case JOB_TITLES :
			{
				rslt = statement.executeQuery("select * from e_JobTitles");
				break;
			}
		}
		
		if (rslt != null)
		{
		
			while (rslt.next())
				lst.add(new OrgStructureItem(rslt.getInt(1),rslt.getString(2)));
		}	
		
		if (statement != null) statement.close();
		if (conn != null) conn.close();
		
		return lst;
	}
	
	public SettingsItem getSettings() throws ClassNotFoundException, SQLException
	{
		SettingsItem set = null;
		DateSettingsItem det = null;
		OrgStrucSettingsItem ccSet = null;
		OrgStrucSettingsItem depSet = null;
		OrgStrucSettingsItem divSet = null;
		OrgStrucSettingsItem ppSet = null;
		OrgStrucSettingsItem jtSet = null;
		OrgStrucSettingsItem jgSet = null;
		
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(JDBC_URL);
		
		Statement statement = conn.createStatement();
		ResultSet rslt = null;
		
		rslt = statement.executeQuery("select * from s_UserProperties");
		if (rslt != null)
		{
		
			while (rslt.next())
				set = new SettingsItem(rslt.getInt(1),rslt.getString(2),rslt.getInt(3),rslt.getBoolean(4),rslt.getBoolean(5),rslt.getBoolean(6),rslt.getBoolean(7),rslt.getBoolean(8),rslt.getInt(9),rslt.getInt(10));
		}	
		
		rslt = statement.executeQuery("select * from s_DateSettings");
		if (rslt != null)
		{
		
			while (rslt.next())
				det = new DateSettingsItem(rslt.getInt(1),rslt.getDate(2),rslt.getDate(3),rslt.getDate(4),rslt.getDate(5),rslt.getDate(6),rslt.getDate(7),rslt.getDate(8),rslt.getDate(9));
		}
		set.setDateSettingsItem(det);
		
		rslt = statement.executeQuery("select * from s_CostCentreSettings");
		if (rslt != null)
		{
		
			while (rslt.next())
				ccSet = new OrgStrucSettingsItem(rslt.getInt(1),rslt.getBoolean(2),rslt.getInt(3));
		}
		set.setCostCentreSettingsItem(ccSet);
		
		rslt = statement.executeQuery("select * from s_DepartmentSettings");
		if (rslt != null)
		{
		
			while (rslt.next())
				depSet = new OrgStrucSettingsItem(rslt.getInt(1),rslt.getBoolean(2),rslt.getInt(3));
		}
		set.setDepartmentSettingsItem(depSet);
		
		rslt = statement.executeQuery("select * from s_DivisionSettings");
		if (rslt != null)
		{

			while (rslt.next())
				divSet = new OrgStrucSettingsItem(rslt.getInt(1),rslt.getBoolean(2),rslt.getInt(3));
		}
		set.setDivSettingsItem(divSet);
		
		rslt = statement.executeQuery("select * from s_PaypointSettings");
		if (rslt != null)
		{

			while (rslt.next())
				ppSet = new OrgStrucSettingsItem(rslt.getInt(1),rslt.getBoolean(2),rslt.getInt(3));
		}
		set.setPaypointSettingsItem(ppSet);
		
		
		rslt = statement.executeQuery("select * from s_JobTitleSettings");
		if (rslt != null)
		{

			while (rslt.next())
				jtSet = new OrgStrucSettingsItem(rslt.getInt(1),rslt.getBoolean(2),rslt.getInt(3));
		}
		set.setJobTitleSettingsItem(jtSet);

		
		rslt = statement.executeQuery("select * from s_JobGradeSettings");
		if (rslt != null)
		{

			while (rslt.next())
				jgSet = new OrgStrucSettingsItem(rslt.getInt(1),rslt.getBoolean(2),rslt.getInt(3));
		}
		set.setJobGradeSettingsItem(jgSet);
		
		if (statement != null) statement.close();
		if (conn != null) conn.close();

		return set;
		
	}
	

	
	public void saveSettings(SettingsItem save) throws SQLException, ClassNotFoundException
	{
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(JDBC_URL);
		String insertSQL = null;
		PreparedStatement ps = null;
		
		insertSQL = ("update s_UserProperties set datepreference = (?),passportdetail = (?),includeCostCentre = (?),includeDepartments = (?),includeDivisions = (?),includePaypoint = (?),paymentRate=(?),employmentType=(?) where id = (?)");
			
		
		ps = conn.prepareStatement(insertSQL);
		ps.setInt(1,save.getDateType());
		ps.setBoolean(2,save.isPassportDetail());
		ps.setBoolean(3,save.isIncludeCostCentre());
		ps.setBoolean(4,save.isIncludeDepartment());
		ps.setBoolean(5,save.isIncludeDivision());
		ps.setBoolean(6,save.isIncludePaypoint());
		ps.setInt(7,save.getPaymentRate());
		ps.setInt(8,save.getEmploymentType());
		
		ps.setInt(9,save.getId());
		
		
		ps.execute();
		conn.commit();
		
		insertSQL = ("update s_DateSettings set employmentDate = (?),engagementDate = (?),irp5Date = (?),firstPayInterval = (?),startDate = (?),endDate = (?),jobTitleEffectiveDate = (?),jobGradeEffectiveDate =(?) where userProfile = (?)");
		

		ps = conn.prepareStatement(insertSQL);
		ps.setDate(1,save.getDateSettingsItem().getEmploymentDate());
		ps.setDate(2,save.getDateSettingsItem().getEngagementDate());
		ps.setDate(3,save.getDateSettingsItem().getIrp5Date());
		ps.setDate(4,save.getDateSettingsItem().getFirstPayInterval());
		ps.setDate(5,save.getDateSettingsItem().getStartDate());
		ps.setDate(6,save.getDateSettingsItem().getEndDate());
		ps.setDate(7, save.getDateSettingsItem().getJobTitleEffectiveDate());
		ps.setDate(8, save.getDateSettingsItem().getJobGradeEffectiveDate());
		
		ps.setInt(9,save.getDateSettingsItem().getId());
		
		ps.execute();
		conn.commit();
		
		
		insertSQL = ("update s_CostCentreSettings set fixed = (?),fixedValue = (?) where userProfile = (?)");
		

		ps = conn.prepareStatement(insertSQL);
		ps.setBoolean(1,save.getCostCentreSettingsItem().isFixed());
		ps.setInt(2,save.getCostCentreSettingsItem().getFixedValue());
		ps.setInt(3,save.getCostCentreSettingsItem().getId());
		
		
		ps.execute();
		conn.commit();
		
		insertSQL = ("update s_DepartmentSettings set fixed = (?),fixedValue = (?) where userProfile = (?)");

		ps = conn.prepareStatement(insertSQL);
		ps.setBoolean(1,save.getDepartmentSettingsItem().isFixed());
		ps.setInt(2,save.getDepartmentSettingsItem().getFixedValue());
		ps.setInt(3,save.getDepartmentSettingsItem().getId());
			
		ps.execute();
		conn.commit();
		
		insertSQL = ("update s_DivisionSettings set fixed = (?),fixedValue = (?) where userProfile = (?)");

		ps = conn.prepareStatement(insertSQL);
		ps.setBoolean(1,save.getDivSettingsItem().isFixed());
		ps.setInt(2,save.getDivSettingsItem().getFixedValue());
		ps.setInt(3,save.getDivSettingsItem().getId());
			
		ps.execute();
		conn.commit();
		
		insertSQL = ("update s_PaypointSettings set fixed = (?),fixedValue = (?) where userProfile = (?)");

		ps = conn.prepareStatement(insertSQL);
		ps.setBoolean(1,save.getPaypointSettingsItem().isFixed());
		ps.setInt(2,save.getPaypointSettingsItem().getFixedValue());
		ps.setInt(3,save.getPaypointSettingsItem().getId());
			
		ps.execute();
		conn.commit();
		
		insertSQL = ("update s_JobTitleSettings set fixed = (?),fixedValue = (?) where userProfile = (?)");

		ps = conn.prepareStatement(insertSQL);
		ps.setBoolean(1,save.getJobTitleSettingsItem().isFixed());
		ps.setInt(2,save.getJobTitleSettingsItem().getFixedValue());
		ps.setInt(3,save.getJobTitleSettingsItem().getId());
			
		ps.execute();
		conn.commit();
		
		insertSQL = ("update s_JobGradeSettings set fixed = (?),fixedValue = (?) where userProfile = (?)");

		ps = conn.prepareStatement(insertSQL);
		ps.setBoolean(1,save.getJobGradeSettingsItem().isFixed());
		ps.setInt(2,save.getJobGradeSettingsItem().getFixedValue());
		ps.setInt(3,save.getJobGradeSettingsItem().getId());
			
		ps.execute();
		conn.commit();
			
		if (ps != null) ps.close();
		if (conn != null) conn.close();
		
	}
	
	public void updateOrgStructure(TypeCodes type,int orgStruc,String name) throws ClassNotFoundException, SQLException
	{
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(JDBC_URL);
		String insertSQL = null;
		switch (type)
		{
			case COST_CENTRES :
			{
				insertSQL = ("update e_CostCentres set name = (?) where id = (?)");
				break;
			}
			case DEPARTMENTS :
			{
				insertSQL = ("update e_Departments set name = (?) where id = (?)");
				break;
			}
			case DIVISIONS :
			{
				insertSQL = ("update e_Divisions set name = (?) where id = (?)");
				break;
			}
			case PAY_POINTS :
			{
				insertSQL = ("update e_PayPoints set name = (?) where id = (?)");
				break;
			}
			case JOB_TITLES :
			{
				insertSQL = ("update e_JobTitles set name = (?) where id = (?)");
				break;
			}
			case JOB_GRADES :
			{
				insertSQL = ("update e_JobGrades set name = (?) where id = (?)");
				break;
			}
		}
		
		PreparedStatement ps = conn.prepareStatement(insertSQL);
		ps.setString(1,name);
		ps.setInt(2,orgStruc);
		ps.execute();
		conn.commit();
		if (ps != null) ps.close();
		if (conn != null) conn.close();
	}
	
	
	public void drop() throws ClassNotFoundException, IOException, SQLException
	{
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(JDBC_URL);
		
		Statement statement = conn.createStatement();
		
		conn.createStatement().execute("drop table e_Names");
		conn.createStatement().execute("drop table e_Surnames");
		
		
	}
	
	

}
