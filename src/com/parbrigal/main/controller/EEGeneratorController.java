package com.parbrigal.main.controller;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EEGeneratorController implements Initializable
{
	
	@FXML
	private TextField noOfEmployees;
	
	@FXML
	private TextField incrementEENo;
	
	@FXML
	private TableView<Employee> table;
	
	@FXML 
	private TableColumn<Employee,String> eeNo;
	
	@FXML 
	private TableColumn<Employee,String> name;
	
	@FXML 
	private TableColumn<Employee,String> surname;
	
	@FXML 
	private TableColumn<Employee,String> initials;
	
	@FXML 
	private TableColumn<Employee,String> title;
	
	@FXML 
	private TableColumn<Employee,String> idNumber;	
	
	@FXML 
	private TableColumn<Employee,String> gender;	
	
	@FXML 
	private TableColumn<Employee,String> age;	
	
	@FXML 
	private TableColumn<Employee,String> taxNo;	
	
	@FXML
	private Button generate;
	
	@FXML
	private Button clear;
	
	@FXML
	private Button export;
	
	@FXML
	private MenuItem exportSettings;
	
	@FXML
	private MenuItem about;
	
	@FXML
	private MenuItem nameTracker;
	
	@FXML
	private MenuItem quickId;
	
	@FXML
	private MenuItem orgTracker;
	
	@FXML 
	private ImageView magnify;
	
	@FXML 
	Label welcome;
	
	final ObservableList<Employee> data = FXCollections.observableArrayList();
	
	
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		
		magnify.setVisible(false);
		
		eeNo.setCellValueFactory(new PropertyValueFactory<Employee, String>("empNo"));
		name.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
		surname.setCellValueFactory(new PropertyValueFactory<Employee, String>("surname"));
		title.setCellValueFactory(new PropertyValueFactory<Employee, String>("title"));
		idNumber.setCellValueFactory(new PropertyValueFactory<Employee, String>("idNumber"));
		initials.setCellValueFactory(new PropertyValueFactory<Employee, String>("initials"));
		gender.setCellValueFactory(new PropertyValueFactory<Employee, String>("gender"));
		age.setCellValueFactory(new PropertyValueFactory<Employee, String>("age"));
		taxNo.setCellValueFactory(new PropertyValueFactory<Employee, String>("taxNumber"));
		
		table.getItems().setAll(data);
		table.setPlaceholder(new Label("No Employees Generated"));
		
		table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> 
		{
		    if (newSelection != null) 
		    {
		        magnify.setVisible(true);
		    }
		});
		
		ConnectionManager.connect();
		
		
		try {
			SettingsItem item = ConnectionManager.getSettings();
			if (!item.getUserName().equals("default"))
			{
				welcome.setText("Hi, " + item.getUserName() + "!");
			}	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void generate()
	{
		if (!validate())
			return;
		
		data.clear();
		
		EmployeeCreator start = new EmployeeCreator();
		try 
		{
			start.populateNames();
		} 
		catch (ClassNotFoundException | IOException | SQLException e2) {
			// TODO Auto-generated catch block
			showAlert("Bad Connection");
		}
		EmployeeCreator creator = null;
		try {
			creator = new EmployeeCreator(incrementEENo.getText(), Integer.valueOf(noOfEmployees.getText()), false, 1000, 120000);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			showAlert(e.getMessage());
		}
		for (Employee ee : creator.getEmployees())
		{
			data.add(ee);
		}
		
		table.getItems().setAll(data);
		
 	}
	
	private boolean validate()
	{
		if (incrementEENo.getText().isEmpty())
		{
			showAlert("Employee's need a starting Employee Number.");
			return false;
		}
		
		if (noOfEmployees.getText().isEmpty())
		{
			showAlert("No of employees to generate cannot be empty.");
			return false;
		}
		
		try
		{
			int i = Integer.valueOf(noOfEmployees.getText());
		}
		catch (Exception e)
		{
			showAlert("No of employees needs to be a number.");
			return false;
		}
		
		int i = Integer.valueOf(noOfEmployees.getText());
		if (i > 100000)
		{
			showAlert("Well, technically, you can generate this many employees, but I draw the line at 100 000");
			return false;
		}
			
	
		return true;
		
	}
	
	public void showNameTracker()
	{
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/com/parbrigal/view/NameTracker.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Stage stage = new Stage();
         stage.setTitle("Name Tracker");
         
         Scene scene = new Scene(root, 344, 393);
         scene.getStylesheets().add(getClass().getResource("/com/parbrigal/view/css/JMetroThemeLightWindow.css").toExternalForm());
         stage.setScene(scene);
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.initStyle(StageStyle.UTILITY);
         stage.initOwner(table.getScene().getWindow());
         stage.centerOnScreen();
         stage.show();
	}
	
	public void showQuickID()
	{
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/com/parbrigal/view/QuickId.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Stage stage = new Stage();
         stage.setTitle("Quick ID");
         Scene scene = new Scene(root,420,83);
         scene.getStylesheets().add(getClass().getResource("/com/parbrigal/view/css/JMetroThemeLightWindow.css").toExternalForm());
         stage.setScene(scene);
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.initOwner(table.getScene().getWindow());
         stage.centerOnScreen();
         stage.show();
	}
	
	public void showOrgTracker()
	{
		Parent root = null;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("/com/parbrigal/view/OrgTracker.fxml"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Stage stage = new Stage();
         Scene scene = new Scene(root,400,461);
         scene.getStylesheets().add(getClass().getResource("/com/parbrigal/view/css/JMetroThemeLight.css").toExternalForm());
  
         stage.setScene(scene);
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.initStyle(StageStyle.UTILITY);
         stage.initOwner(table.getScene().getWindow());
         stage.centerOnScreen();
         stage.show();
	}
	
	private void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(message);

		alert.showAndWait();
	}
	
	public void clearTables()
	{
		try {
			ConnectionManager.clear();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void exportSettings()
	{
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/com/parbrigal/view/ExportSettings.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Stage stage = new Stage();
         //stage.setTitle("Export Settings");
         Scene scene = new Scene(root, 802, 783);
         scene.getStylesheets().add(getClass().getResource("/com/parbrigal/view/css/JMetroThemeLightDialog.css").toExternalForm());
         stage.setScene(scene);
         stage.initStyle(StageStyle.UTILITY);
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.initOwner(table.getScene().getWindow());
         stage.centerOnScreen();
         stage.show();
	}
	
	public void about()
	{
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/com/parbrigal/view/About.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Stage stage = new Stage();
         //stage.setTitle("Export Settings");
         Scene scene = new Scene(root);
         scene.getStylesheets().add(getClass().getResource("/com/parbrigal/view/css/JMetroThemeLightDialog.css").toExternalForm());
         stage.setScene(scene);
         stage.initStyle(StageStyle.UTILITY);
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.initOwner(table.getScene().getWindow());
         stage.centerOnScreen();
         stage.show();
	}
	
	public void startExport()
	{
		final FileChooser directoryChooser = new FileChooser();
		directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		//directoryChooser.setInitialFileName(value);
		//File selectedDirectory = null;
		directoryChooser.setInitialFileName("Master Info");
		directoryChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		//directoryChooser.getExtensionFilters().addAll(new ExtensionFilter("Excel Files", "*.xls"));
		File selectedDirectory = directoryChooser.showSaveDialog(null);
		
		if (selectedDirectory != null)
		{
			if (data != null)
			{	
				ExcelFile exc = new ExcelFile();
				exc.masterInfoToExcel(data, selectedDirectory);
			}	
		}
		
	}
	
	public void showEmployeeDetails()
	{
		getFields(table.getSelectionModel().getSelectedItem());
	}
	
	
	
	private void getFields(Employee ee) {
		Stage stage = new Stage();
        //stage.setTitle("Export Settings");
		ScrollPane s1 = new ScrollPane();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
        
      
        
	    Class<?> componentClass = ee.getClass();
	    Field[] fields = componentClass.getDeclaredFields();
	    
	    int x = 0;
	    for (Field f : fields)
	    {
	    	x++;
	    	f.setAccessible(true);
	    	if (f.getName().equalsIgnoreCase("serialversionUID"))
	    		continue;
	    	
	    	Label label = new Label();
	    	
	    	String camel = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(f.getName()),' ');
	    	String upper = camel.substring(0,1).toUpperCase() + camel.substring(1);
	    	label.setText(upper);
	    	
	    	Object value = null;
	    	try {
				value = PropertyUtils.getProperty(ee, f.getName());
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	TextField text = new TextField();
	    	if (value instanceof String)
	    		text.setText(value == null ? "" : (String) value);
	    	else if (value instanceof Boolean)
	    		text.setText((boolean) value ? "Y" : "N");
	    	else if (value instanceof Integer)
	    		text.setText(String.valueOf(value));
			
	    	grid.add(label,0,x);
	    	grid.add(text,1,x);
	    	
	    }
	    s1.setContent(grid);
	    Scene scene = new Scene(s1, 500, 275);
	    scene.getStylesheets().add(getClass().getResource("/com/parbrigal/view/css/JMetroThemeLightWindow.css").toExternalForm());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(table.getScene().getWindow());
        stage.centerOnScreen();
        stage.show();
	}
	
	public void clear()
	{
		table.getItems().clear();
		magnify.setVisible(false);
	}
	
	

}
