package com.parbrigal.main;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.parbrigal.config.ViewManager;
import com.parbrigal.main.controller.ConnectionManager;
import com.parbrigal.main.controller.DateSettingsItem;
import com.parbrigal.main.controller.EmploymentTypeCodes;
import com.parbrigal.main.controller.HierarchyCodes;
import com.parbrigal.main.controller.OrgStrucSettingsItem;
import com.parbrigal.main.controller.OrgStructureItem;
import com.parbrigal.main.controller.PaymentTypeCodes;
import com.parbrigal.main.controller.SettingsItem;
import com.parbrigal.main.controller.TypeCodes;
import com.parbrigal.main.controller.Utility;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;

public class ExportSettingsController implements Initializable{
	
	@FXML
	private Button okButton;
	
	@FXML
	private Button cancelButton;
	
	@FXML
	private RadioButton fixed;
	
	@FXML
	private RadioButton random;
	
	@FXML 
	private CheckBox includePassportDetail;
	
	@FXML
	private ComboBox<PaymentTypeCodes> paymentTypes;
	
	@FXML
	private ComboBox<EmploymentTypeCodes> employmentTypes;
	
	@FXML 
	private CheckBox includeCostCentre;
	
	@FXML
	private CheckBox includeDepartment;
	
	@FXML 
	private CheckBox includeDivision;
	
	@FXML
	private CheckBox includePaypoint;
	
	@FXML
	private Spinner<HierarchyCodes> ccSpinner;
	
	@FXML
	private Spinner<HierarchyCodes> depSpinner;
	
	@FXML
	private Spinner<HierarchyCodes> divSpinner;
	
	@FXML
	private Spinner<HierarchyCodes> ppSpinner;
	
	@FXML
	private Spinner<HierarchyCodes> jtSpinner;
	
	@FXML
	private Spinner<HierarchyCodes> jgSpinner;
	
	@FXML
	private ComboBox<OrgStructureItem> ccFixed;
	
	@FXML
	private ComboBox<OrgStructureItem> depFixed;
	
	@FXML
	private ComboBox<OrgStructureItem> divFixed;
	
	@FXML
	private ComboBox<OrgStructureItem> ppFixed;
	
	@FXML
	private ComboBox<OrgStructureItem> jtFixed;
	
	@FXML
	private ComboBox<OrgStructureItem> jgFixed;
	
	@FXML
	private DatePicker employmentDate;
	
	@FXML
	private DatePicker engagementDate;
	
	@FXML
	private DatePicker firstPayInterval;
	
	@FXML
	private DatePicker irp5StartDate;
	
	@FXML
	private DatePicker jobGradeEffectiveDate;
	
	@FXML
	private DatePicker jobTitleEffectiveDate;
	
	@FXML
	private Label firstPayIntervalL;
	
	@FXML
	private Label irp5StartDateL;
	
	@FXML
	private Label engagementDateL;
	
	@FXML
	private Label employmentDateL;
	
	@FXML
	private Label startDateL;
	
	@FXML
	private Label endDateL;
	
	@FXML
	private DatePicker startDate;
	
	@FXML
	private DatePicker endDate;
	
	SettingsItem set = null;
	
	private List<OrgStructureItem> costCentres;
	private List<OrgStructureItem> departments;
	private List<OrgStructureItem> divisions;
	private List<OrgStructureItem> paypoints;
	private List<OrgStructureItem> jobTitles;
	private List<OrgStructureItem>  jobGrades;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		ccSpinner.setVisible(false);
		depSpinner.setVisible(false);
		divSpinner.setVisible(false);
		ppSpinner.setVisible(false);
		
		ccFixed.setVisible(false);
		depFixed.setVisible(false);
		divFixed.setVisible(false);
		ppFixed.setVisible(false);
		jtFixed.setVisible(false);
		jgFixed.setVisible(false);
		
		List<String> paymentTypeList = new ArrayList<String>();
		paymentTypeList.add("Hourly");
		paymentTypeList.add("Daily");
		paymentTypeList.add("Monthly");
		
		employmentTypes.setItems(FXCollections.observableArrayList(EmploymentTypeCodes.values()));
		paymentTypes.setItems(FXCollections.observableArrayList(PaymentTypeCodes.values()));
		
		try 
		{
			costCentres = ConnectionManager.getOrgStructureData(TypeCodes.COST_CENTRES);
			departments = ConnectionManager.getOrgStructureData(TypeCodes.DEPARTMENTS);
			divisions = ConnectionManager.getOrgStructureData(TypeCodes.DIVISIONS);
			paypoints = ConnectionManager.getOrgStructureData(TypeCodes.PAY_POINTS);
			jobTitles = ConnectionManager.getOrgStructureData(TypeCodes.JOB_TITLES);
			jobGrades = ConnectionManager.getOrgStructureData(TypeCodes.JOB_GRADES);
			
			ccFixed.setItems( FXCollections.observableArrayList(costCentres));
			depFixed.setItems( FXCollections.observableArrayList(departments));
			divFixed.setItems( FXCollections.observableArrayList(divisions));
			ppFixed.setItems( FXCollections.observableArrayList(paypoints));
			jtFixed.setItems( FXCollections.observableArrayList(jobTitles));
			jgFixed.setItems( FXCollections.observableArrayList(jobGrades));
		} 
		catch (ClassNotFoundException | IOException | SQLException e) 
		{
			ViewManager.showAlert("Could not load cost centres/departments/divisions/paypoints");
		}
		
		ToggleGroup dateGroup = new ToggleGroup();
		fixed.setToggleGroup(dateGroup);
		random.setToggleGroup(dateGroup);
		
		ObservableList<HierarchyCodes> typeSelect = FXCollections.observableArrayList(HierarchyCodes.values());
		SpinnerValueFactory<HierarchyCodes> ccValueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<HierarchyCodes>(typeSelect);
		ccValueFactory.setValue(HierarchyCodes.RANDOM);
		SpinnerValueFactory<HierarchyCodes> depValueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<HierarchyCodes>(typeSelect); 
		depValueFactory.setValue(HierarchyCodes.RANDOM);
		SpinnerValueFactory<HierarchyCodes> divValueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<HierarchyCodes>(typeSelect);
		divValueFactory.setValue(HierarchyCodes.RANDOM);
		SpinnerValueFactory<HierarchyCodes> ppValueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<HierarchyCodes>(typeSelect);
		ppValueFactory.setValue(HierarchyCodes.RANDOM);
		SpinnerValueFactory<HierarchyCodes> jtValueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<HierarchyCodes>(typeSelect);
		jtValueFactory.setValue(HierarchyCodes.RANDOM);
		SpinnerValueFactory<HierarchyCodes> jgValueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<HierarchyCodes>(typeSelect);
		jgValueFactory.setValue(HierarchyCodes.RANDOM);
		
		ccSpinner.setValueFactory(ccValueFactory);
		depSpinner.setValueFactory(depValueFactory);
		divSpinner.setValueFactory(divValueFactory);
		ppSpinner.setValueFactory(ppValueFactory);
		jtSpinner.setValueFactory(jtValueFactory);
		jgSpinner.setValueFactory(jgValueFactory);
		
		includeCostCentre.selectedProperty().addListener(new ChangeListener<Boolean>()
		{
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				
				if (newValue)
				{
					ccSpinner.setVisible(true);
				}
				else
				{
					ccSpinner.setVisible(false);
					ccValueFactory.setValue(HierarchyCodes.RANDOM);
					ccFixed.setVisible(false);
				}	
			}
		});
		
		includeDepartment.selectedProperty().addListener(new ChangeListener<Boolean>()
		{
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				
				if (newValue)
				{
					depSpinner.setVisible(true);
				}
				else
				{
					depSpinner.setVisible(false);
					depValueFactory.setValue(HierarchyCodes.RANDOM);
					depFixed.setVisible(false);
				}
				
			}
			
		});
		
		includeDivision.selectedProperty().addListener(new ChangeListener<Boolean>()
		{
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				
				if (newValue)
				{
					divSpinner.setVisible(true);
				}
				else
				{
					divSpinner.setVisible(false);
					divValueFactory.setValue(HierarchyCodes.RANDOM);
					divFixed.setVisible(false);
				}
				
			}
			
		});
		
		includePaypoint.selectedProperty().addListener(new ChangeListener<Boolean>()
		{
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				
				if (newValue)
				{
					ppSpinner.setVisible(true);
				}
				else
				{
					ppSpinner.setVisible(false);
					ppValueFactory.setValue(HierarchyCodes.RANDOM);
					ppFixed.setVisible(false);
				}
			}
			
		});
		
		ccSpinner.valueProperty().addListener(new ChangeListener<HierarchyCodes>()
	    {
			@Override
			public void changed(ObservableValue<? extends HierarchyCodes> observable, HierarchyCodes oldValue, HierarchyCodes newValue) 
			{
				switch (newValue)
				{
					case RANDOM : 
					{	
						ccFixed.setVisible(false);
						break;
					}
					case FIXED :
					{
						ccFixed.setVisible(true);
						break;
					}
				}
			}

		});	
		
		depSpinner.valueProperty().addListener(new ChangeListener<HierarchyCodes>()
	    {
			@Override
			public void changed(ObservableValue<? extends HierarchyCodes> observable, HierarchyCodes oldValue, HierarchyCodes newValue) 
			{
				switch (newValue)
				{
					case RANDOM : 
					{	
						depFixed.setVisible(false);
						break;
					}
					case FIXED :
					{
						depFixed.setVisible(true);
						break;
					}
				}
			}

		});	
		
		divSpinner.valueProperty().addListener(new ChangeListener<HierarchyCodes>()
	    {
			@Override
			public void changed(ObservableValue<? extends HierarchyCodes> observable, HierarchyCodes oldValue, HierarchyCodes newValue) 
			{
				switch (newValue)
				{
					case RANDOM : 
					{	
						divFixed.setVisible(false);
						break;
					}
					case FIXED :
					{
						divFixed.setVisible(true);
						break;
					}
				}
			}

		});	
		
		ppSpinner.valueProperty().addListener(new ChangeListener<HierarchyCodes>()
	    {
			@Override
			public void changed(ObservableValue<? extends HierarchyCodes> observable, HierarchyCodes oldValue, HierarchyCodes newValue) 
			{
				switch (newValue)
				{
					case RANDOM : 
					{	
						ppFixed.setVisible(false);
						break;
					}
					case FIXED :
					{
						ppFixed.setVisible(true);
						break;
					}
				}
			}

		});
		
		jtSpinner.valueProperty().addListener(new ChangeListener<HierarchyCodes>()
	    {
			@Override
			public void changed(ObservableValue<? extends HierarchyCodes> observable, HierarchyCodes oldValue, HierarchyCodes newValue) 
			{
				switch (newValue)
				{
					case RANDOM : 
					{	
						jtFixed.setVisible(false);
						break;
					}
					case FIXED :
					{
						jtFixed.setVisible(true);
						break;
					}
				}
			}

		});
		
		jgSpinner.valueProperty().addListener(new ChangeListener<HierarchyCodes>()
	    {
			@Override
			public void changed(ObservableValue<? extends HierarchyCodes> observable, HierarchyCodes oldValue, HierarchyCodes newValue) 
			{
				switch (newValue)
				{
					case RANDOM : 
					{	
						jgFixed.setVisible(false);
						break;
					}
					case FIXED :
					{
						jgFixed.setVisible(true);
						break;
					}
				}
			}

		});
		
		fixed.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
			{
				employmentDateL.setVisible(true);
				employmentDate.setVisible(true);
				
				engagementDateL.setVisible(true);
				engagementDate.setVisible(true);
				irp5StartDateL.setVisible(true);
				irp5StartDate.setVisible(true);
				firstPayInterval.setVisible(true);
				firstPayIntervalL.setVisible(true);
				
				
				startDate.setVisible(false);
				startDateL.setVisible(false);
				endDateL.setVisible(false);
				endDate.setVisible(false);

				
			}
		});
		
		
		random.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
			{
				employmentDateL.setVisible(false);
				employmentDate.setVisible(false);
				
				engagementDateL.setVisible(false);
				engagementDate.setVisible(false);
				irp5StartDateL.setVisible(false);
				irp5StartDate.setVisible(false);
				firstPayInterval.setVisible(false);
				firstPayIntervalL.setVisible(false);
				
				
				startDate.setVisible(true);
				startDateL.setVisible(true);
				endDateL.setVisible(true);
				endDate.setVisible(true);
				
			}
		});
		
		try 
		{
			set = ConnectionManager.getSettings();
			employmentTypes.setValue(EmploymentTypeCodes.getCodeFromInt(set.getEmploymentType()));
			paymentTypes.setValue(PaymentTypeCodes.getCodeFromInt(set.getPaymentRate()));
			random.selectedProperty().setValue(set.getDateType() == 1);
			fixed.selectedProperty().setValue(set.getDateType() == 2);
			includePassportDetail.selectedProperty().set(set.isPassportDetail());
			includeCostCentre.selectedProperty().set(set.isIncludeCostCentre());
			includeDepartment.selectedProperty().set(set.isIncludeDepartment());
			includeDivision.selectedProperty().set(set.isIncludeDivision());
			includePaypoint.selectedProperty().set(set.isIncludePaypoint());
			
			DateSettingsItem det = set.getDateSettingsItem();
			
			if (set.getDateType() == 2) // fixed
			{
				engagementDate.setValue(ViewManager.getLocalDate(det.getEngagementDate()));
				employmentDate.setValue(ViewManager.getLocalDate(det.getEmploymentDate()));
				irp5StartDate.setValue(ViewManager.getLocalDate(det.getIrp5Date()));
				firstPayInterval.setValue(ViewManager.getLocalDate(det.getFirstPayInterval()));
				jobGradeEffectiveDate.setValue(ViewManager.getLocalDate(det.getJobGradeEffectiveDate()));
				jobTitleEffectiveDate.setValue(ViewManager.getLocalDate(det.getJobTitleEffectiveDate()));
			}
			else
			{
				startDate.setValue(ViewManager.getLocalDate(det.getStartDate()));
				endDate.setValue(ViewManager.getLocalDate(det.getEndDate()));
			}
			
			OrgStrucSettingsItem ccSettings = set.getCostCentreSettingsItem();
			ccSpinner.getValueFactory().setValue(ccSettings.isFixed() ? HierarchyCodes.FIXED : HierarchyCodes.RANDOM);
			ccFixed.setValue(Utility.getOrgStructureItem(costCentres, ccSettings.getFixedValue()));
			
			OrgStrucSettingsItem depSettings = set.getDepartmentSettingsItem();
			depSpinner.getValueFactory().setValue(depSettings.isFixed() ? HierarchyCodes.FIXED : HierarchyCodes.RANDOM);
			depFixed.setValue(Utility.getOrgStructureItem(departments, depSettings.getFixedValue()));
			
			OrgStrucSettingsItem divSettings = set.getDivSettingsItem();
			divSpinner.getValueFactory().setValue(divSettings.isFixed() ? HierarchyCodes.FIXED : HierarchyCodes.RANDOM);
			divFixed.setValue(Utility.getOrgStructureItem(divisions, divSettings.getFixedValue()));
			
			OrgStrucSettingsItem ppSettings = set.getDivSettingsItem();
			ppSpinner.getValueFactory().setValue(ppSettings.isFixed() ? HierarchyCodes.FIXED : HierarchyCodes.RANDOM);
			ppFixed.setValue(Utility.getOrgStructureItem(paypoints, ppSettings.getFixedValue()));
			
			OrgStrucSettingsItem jtSettings = set.getJobTitleSettingsItem();
			jtSpinner.getValueFactory().setValue(jtSettings.isFixed() ? HierarchyCodes.FIXED : HierarchyCodes.RANDOM);
			jtFixed.setValue(Utility.getOrgStructureItem(jobTitles, jtSettings.getFixedValue()));
			
			OrgStrucSettingsItem jgSettings = set.getJobGradeSettingsItem();
			jgSpinner.getValueFactory().setValue(jgSettings.isFixed() ? HierarchyCodes.FIXED : HierarchyCodes.RANDOM);
			jgFixed.setValue(Utility.getOrgStructureItem(jobGrades, jgSettings.getFixedValue()));
			
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			ViewManager.showAlert("Could not restore settings");
		}
		
	}
	
	public void save()
	{
		
		set.setPaymentRate(paymentTypes.getValue().getId());
		set.setEmploymentType(employmentTypes.getValue().getId());
		set.setPassportDetail(includePassportDetail.isSelected());
		set.setIncludeCostCentre(includeCostCentre.isSelected());
		set.setIncludeDepartment(includeDepartment.isSelected());
		set.setIncludeDivision(includeDivision.isSelected());
		set.setIncludePaypoint(includePaypoint.isSelected());
		set.setDateType(fixed.selectedProperty().getValue() ? 2 : 1);
		
		DateSettingsItem det = new DateSettingsItem();
		
		det.setId(set.getId());
		
		
		if (set.getDateType() == 2)
		{
			det.setEmploymentDate(ViewManager.getDate(employmentDate.getValue()));
			det.setEngagementDate(ViewManager.getDate(engagementDate.getValue()));
			det.setIrp5Date(ViewManager.getDate(irp5StartDate.getValue()));
			det.setFirstPayInterval(ViewManager.getDate(firstPayInterval.getValue()));
			det.setStartDate(null);
			det.setEndDate(null);
			
			det.setJobGradeEffectiveDate(ViewManager.getDate(jobGradeEffectiveDate.getValue()));
			det.setJobTitleEffectiveDate(ViewManager.getDate(jobTitleEffectiveDate.getValue()));
		}
		else
		{
			det.setStartDate(ViewManager.getDate(startDate.getValue()));
			det.setEndDate(ViewManager.getDate(endDate.getValue()));
			
			det.setEmploymentDate(null);
			det.setEngagementDate(null);
			det.setIrp5Date(null);
			det.setFirstPayInterval(null);
			det.setJobGradeEffectiveDate(null);
			det.setJobTitleEffectiveDate(null);
		}
		
		set.setDateSettingsItem(det);
		
		
		if (includeCostCentre.isSelected())
		{
			OrgStrucSettingsItem cet = new OrgStrucSettingsItem();
			cet.setId(set.getId());
			cet.setFixed(ccSpinner.getValue() == HierarchyCodes.FIXED ? true : false);
			cet.setFixedValue(ccFixed.getValue() == null ? 0 : !ccFixed.isVisible() ? 0 : ((OrgStructureItem)ccFixed.getValue()).getId());
			
			set.setCostCentreSettingsItem(cet);		
		}
		else
		{
			OrgStrucSettingsItem cet = new OrgStrucSettingsItem();
			cet.setId(set.getId());
			cet.setFixed(false);
			cet.setFixedValue(0);
			set.setCostCentreSettingsItem(cet);	
		}
		
		if (includeDepartment.isSelected())
		{
			OrgStrucSettingsItem ddet = new OrgStrucSettingsItem();
			ddet.setId(set.getId());
			ddet.setFixed(depSpinner.getValue() == HierarchyCodes.FIXED ? true : false);
			ddet.setFixedValue(depFixed.getValue() == null ? 0 : !depFixed.isVisible() ? 0 : ((OrgStructureItem)depFixed.getValue()).getId());
			
			set.setDepartmentSettingsItem(ddet);		
		}
		else
		{
			OrgStrucSettingsItem ddet = new OrgStrucSettingsItem();
			ddet.setId(set.getId());
			ddet.setFixed(false);
			ddet.setFixedValue(0);
			set.setDepartmentSettingsItem(ddet);	
		}
		
		if (includeDivision.isSelected())
		{
			OrgStrucSettingsItem divet = new OrgStrucSettingsItem();
			divet.setId(set.getId());
			divet.setFixed(divSpinner.getValue() == HierarchyCodes.FIXED ? true : false);
			divet.setFixedValue(divFixed.getValue() == null ? 0 : !divFixed.isVisible() ? 0 : ((OrgStructureItem)divFixed.getValue()).getId());
			
			set.setDivSettingsItem(divet);		
		}
		else
		{
			OrgStrucSettingsItem divet = new OrgStrucSettingsItem();
			divet.setId(set.getId());
			divet.setFixed(false);
			divet.setFixedValue(0);
			set.setDivSettingsItem(divet);	
		}
		if (includePaypoint.isSelected())
		{
			OrgStrucSettingsItem ppet = new OrgStrucSettingsItem();
			ppet.setId(set.getId());
			ppet.setFixed(ppSpinner.getValue() == HierarchyCodes.FIXED ? true : false);
			ppet.setFixedValue(ppFixed.getValue() == null ? 0 : !ppFixed.isVisible() ? 0 : ((OrgStructureItem)ppFixed.getValue()).getId());
			
			set.setPaypointSettingsItem(ppet);		
		}
		else
		{
			OrgStrucSettingsItem ppet = new OrgStrucSettingsItem();
			ppet.setId(set.getId());
			ppet.setFixed(false);
			ppet.setFixedValue(0);
			set.setPaypointSettingsItem(ppet);	
			
		}
		
		OrgStrucSettingsItem jtet = new OrgStrucSettingsItem();
		jtet.setId(set.getId());
		jtet.setFixed(jtSpinner.getValue() == HierarchyCodes.FIXED ? true : false);
		jtet.setFixedValue(jtFixed.getValue() == null ? 0 : !jtFixed.isVisible() ? 0 : ((OrgStructureItem)jtFixed.getValue()).getId());
		
		set.setJobTitleSettingsItem(jtet);
		
		OrgStrucSettingsItem jget = new OrgStrucSettingsItem();
		jget.setId(set.getId());
		jget.setFixed(jgSpinner.getValue() == HierarchyCodes.FIXED ? true : false);
		jget.setFixedValue(jgFixed.getValue() == null ? 0 : !jgFixed.isVisible() ? 0 : ((OrgStructureItem)jgFixed.getValue()).getId());
		
		set.setJobGradeSettingsItem(jget);
		
		
		
		
		try 
		{
			ConnectionManager.saveSettings(set);
		} catch (ClassNotFoundException | SQLException e) {
			ViewManager.showAlert("Could not save settings");
		}
	}
	
	public void close()
	{
		cancelButton.getScene().getWindow().hide();
	}
	

}
