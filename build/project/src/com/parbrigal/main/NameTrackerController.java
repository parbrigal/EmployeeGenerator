package com.parbrigal.main;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.parbrigal.main.controller.ConnectionManager;
import com.parbrigal.main.controller.Name;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class NameTrackerController implements Initializable
{
	
	@FXML
	private TableView<Name> table;
	
	@FXML 
	private TableColumn<Name,String> name;
	
	@FXML 
	private TableColumn<Name,String> gender;
	
	
	@FXML 
	private Spinner<String> spinner;
	
	@FXML 
	private Label total;
	
	ObservableList<Name> data;
	ObservableList<String> typeSelect;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		data = FXCollections.observableArrayList();
		
		name.setCellValueFactory(new PropertyValueFactory<Name, String>("name"));
		gender.setCellValueFactory(new PropertyValueFactory<Name, String>("gender"));
		
		typeSelect = FXCollections.observableArrayList("Surnames","Names");
		
		SpinnerValueFactory<String> valueFactory = //
	               new SpinnerValueFactory.ListSpinnerValueFactory<String>(typeSelect);
	      
	       valueFactory.setValue("Names");
	       
	    spinner.setValueFactory(valueFactory);
	    
	    spinner.valueProperty().addListener(new ChangeListener<String>()
	    {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
			{
				data = FXCollections.observableArrayList();
				switch (newValue)
				{
					case "Names" : 
					{	
						name.setText("Names");
						table.getItems().setAll(data);
						table.refresh();
						total.setText("0");
						break;
					}
					case "Surnames" : 
					{
						name.setText("Surnames");
						table.getItems().setAll(data);
						table.refresh();
						total.setText("0");
						break;
					}
				}
			}

		});	
	}
	
	public void get()
	{
		switch (spinner.getValue())
		{
			case ("Names") :  
			try 
			{
				for (Name name : ConnectionManager.getNames())
				{
					data.add(name);
					
					table.getItems().setAll(data);
					total.setText(String.valueOf(data.size()));
					
				}
			}
			catch (ClassNotFoundException | IOException | SQLException e) {
				showAlert(e.getMessage());
			}
			break;
			case ("Surnames") :  
				try 
				{
					for (Name name : ConnectionManager.getSurnames())
					{
						data.add(name);
						
						table.getItems().setAll(data);
						total.setText(String.valueOf(data.size()));
						
					}
				}
				catch (ClassNotFoundException | IOException | SQLException e) {
					showAlert(e.getMessage());
				}
				break;
		}
 	}
	
	private boolean validate()
	{
		return false;
	
	}
	
	public void showNameTracker()
	{
		Parent root = null;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("NameTracker.fxml"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		 Stage stage = new Stage();
         stage.setTitle("Name Tracker");
         stage.setScene(new Scene(root));
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
			ConnectionManager.drop();
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

}
