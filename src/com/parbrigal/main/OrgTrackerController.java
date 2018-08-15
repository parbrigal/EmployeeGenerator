package com.parbrigal.main;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.parbrigal.config.ViewManager;
import com.parbrigal.main.controller.ConnectionManager;
import com.parbrigal.main.controller.OrgStructureItem;
import com.parbrigal.main.controller.TypeCodes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

public class OrgTrackerController implements Initializable
{
	
	@FXML
	private ComboBox<TypeCodes> type;
	
	@FXML
	private Button get;

	@FXML
	private Button add;
	
	@FXML
	private Button update;
	
	@FXML
	private Button delete;
	
	@FXML
	private ListView<OrgStructureItem> table;
	
	
	@FXML 
	private TextField text;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		
		type.setItems( FXCollections.observableArrayList( TypeCodes.values()));
		type.setPromptText("Select an Org Structure Type");
		
		add.setDisable(true);
		delete.setDisable(true);
		update.setDisable(true);
		get.setVisible(false);
		
		
		type.valueProperty().addListener(new ChangeListener<TypeCodes>() {

			@Override
			public void changed(ObservableValue<? extends TypeCodes> observable, TypeCodes oldValue,TypeCodes newValue) 
			{
				table.getItems().clear();
				get.setVisible(true);
				text.setText("");
				add.setDisable(true);
				delete.setDisable(true);
				update.setDisable(true);
			}
		});
		
		 table.setCellFactory(new Callback<ListView<OrgStructureItem>, ListCell<OrgStructureItem>>(){
			 
	            @Override
	            public ListCell<OrgStructureItem> call(ListView<OrgStructureItem> p) 
	            {
	                 
	                ListCell<OrgStructureItem> cell = new ListCell<OrgStructureItem>()
	                {
	 
	                    @Override
	                    protected void updateItem(OrgStructureItem t, boolean bln) {
	                        super.updateItem(t, bln);
	                        if (t != null) {
	                            setText(t.getName());
	                        }
	                        else
	                        {
	                        	setText("");
	                        }
	                    }
	 
	                };
	                 
	                return cell;
	            }
	        });
	
		table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<OrgStructureItem>()
		{
			@Override
			public void changed(ObservableValue<? extends OrgStructureItem> observable, OrgStructureItem oldValue, OrgStructureItem newValue) 
			{
				if (newValue != null)
				{
					text.setText(newValue.getName());
					delete.setDisable(false);
					update.setDisable(false);
					add.setDisable(false);
					add.setText("New");
				}	
			}
			
		});
	}
	
	public void get()
	{
		
		if (type.getValue() == null)
		{	
			ViewManager.showAlert("No Type Selected");
			return;
		}
		try {
			switch (type.getValue())
			{
				case COST_CENTRES:
				{	
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					 add.setDisable(false);
					break;
				}	
				case DEPARTMENTS:
				{	
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					 add.setDisable(false);
					break;
				}	
				case DIVISIONS:
				{	
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					 add.setDisable(false);
					break;
				}	
				case PAY_POINTS:
				{	
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					 add.setDisable(false);
					break;
				}
				case JOB_TITLES:
				{	
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					 add.setDisable(false);
					break;
				}	
				case JOB_GRADES:
				{	
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					 add.setDisable(false);
					break;
				}
				default:
					break;
			}	
		
			} 
			catch (ClassNotFoundException | IOException | SQLException e) 
			{
				ViewManager.showAlert(e.getMessage());
			}
		}
	
	public void add()
	{
		
		if (add.getText().equals("New"))
		{
			add.setText("Add");
			text.setText("");
			table.getSelectionModel().select(null);
			update.setDisable(true);
			delete.setDisable(true);
			return;
		}
		
		if (type.getValue() == null)
		{	
			ViewManager.showAlert("No Type Selected");
			return;
		}
		if (text.getText() == null || text.getText().isEmpty())
		{	
			ViewManager.showAlert("Nothing to save");
			return;
		}
		try {
			switch (type.getValue())
			{
				case COST_CENTRES:
				{	
					 ConnectionManager.setOrgStructureData(type.getValue(),text.getText());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					break;
				}	
				case DEPARTMENTS:
				{	
					 ConnectionManager.setOrgStructureData(type.getValue(),text.getText());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					 add.setDisable(false);
					break;
				}	
				case DIVISIONS:
				{	
					 ConnectionManager.setOrgStructureData(type.getValue(),text.getText());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					 add.setDisable(false);
					break;
				}	
				case PAY_POINTS:
				{	
					 ConnectionManager.setOrgStructureData(type.getValue(),text.getText());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					 add.setDisable(false);
					break;
				}
				case JOB_TITLES:
				{	
					 ConnectionManager.setOrgStructureData(type.getValue(),text.getText());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					 add.setDisable(false);
					break;
				}
				case JOB_GRADES:
				{	
					 ConnectionManager.setOrgStructureData(type.getValue(),text.getText());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					 add.setDisable(false);
					break;
				}
				default:
					break;
					
				
			}	
		
			} 
			catch (ClassNotFoundException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	public void update()
	{
		
		if (type.getValue() == null)
		{	
			ViewManager.showAlert("No Type Selected");
			return;
		}
		if (text.getText() == null || text.getText().isEmpty())
		{	
			ViewManager.showAlert("Nothing to save");
			return;
		}
		try {
			switch (type.getValue())
			{
				case COST_CENTRES:
				{	
					 ConnectionManager.updateOrgStrucData(type.getValue(),table.getSelectionModel().getSelectedItem().getId(),text.getText());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					break;
				}	
				case DEPARTMENTS:
				{	
					 ConnectionManager.updateOrgStrucData(type.getValue(),table.getSelectionModel().getSelectedItem().getId(),text.getText());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					 add.setDisable(false);
					break;
				}	
				case DIVISIONS:
				{	
					ConnectionManager.updateOrgStrucData(type.getValue(),table.getSelectionModel().getSelectedItem().getId(),text.getText());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					 add.setDisable(false);
					break;
				}	
				case PAY_POINTS:
				{	
					ConnectionManager.updateOrgStrucData(type.getValue(),table.getSelectionModel().getSelectedItem().getId(),text.getText());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					 add.setDisable(false);
					break;
				}	
				case JOB_GRADES:
				{	
					ConnectionManager.updateOrgStrucData(type.getValue(),table.getSelectionModel().getSelectedItem().getId(),text.getText());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					 add.setDisable(false);
					break;
				}	
				case JOB_TITLES:
				{	
					ConnectionManager.updateOrgStrucData(type.getValue(),table.getSelectionModel().getSelectedItem().getId(),text.getText());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					 add.setDisable(false);
					break;
				}
				default:
					break;
			}	
		
			} catch (ClassNotFoundException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			text.setText("");
			table.getSelectionModel().select(null);
		}
	
	public void delete()
	{
		
		if (type.getValue() == null)
		{	
			ViewManager.showAlert("No Type Selected");
			return;
		}
		
		if (table.getSelectionModel().getSelectedItem() == null)
		{	
			ViewManager.showAlert("No Entry Selected to delete");
			return;
		}
		
		OrgStructureItem orgStructureItem = table.getSelectionModel().getSelectedItem();
		
		try 
		{
			table.getItems().clear();
			switch (type.getValue())
			{
				case COST_CENTRES:
				{	
					 ConnectionManager.deleteOrgStrucData(type.getValue(),orgStructureItem.getId());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					break;
				}	
				case DEPARTMENTS:
				{	
					 ConnectionManager.deleteOrgStrucData(type.getValue(),orgStructureItem.getId());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					break;
				}	
				case DIVISIONS:
				{	
					 ConnectionManager.deleteOrgStrucData(type.getValue(),orgStructureItem.getId());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					break;
				}	
				case PAY_POINTS:
				{	
					 ConnectionManager.deleteOrgStrucData(type.getValue(),orgStructureItem.getId());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					break;
				}
				case JOB_TITLES:
				{	
					 ConnectionManager.deleteOrgStrucData(type.getValue(),orgStructureItem.getId());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					break;
				}
				case JOB_GRADES:
				{	
					 ConnectionManager.deleteOrgStrucData(type.getValue(),orgStructureItem.getId());
					 ObservableList<OrgStructureItem> items = FXCollections.observableArrayList(ConnectionManager.getOrgStructureData(type.getValue()));
					 table.setItems(items);
					break;
				}
				default:
					break;
			}	
		
			} 
			catch (ClassNotFoundException | IOException | SQLException e) 
			{
				ViewManager.showAlert(e.getMessage());
			}
			text.setText("");
			table.getSelectionModel().select(null);
		}
		
	}

	class OrStructureCellFactory implements Callback<ListView<OrgStructureItem>,ListCell<OrgStructureItem>>
	{

		@Override
		public ListCell<OrgStructureItem> call(ListView<OrgStructureItem> param) {
			return new OrgStructureCell();
		}
		
	}
	
	class OrgStructureCell extends ListCell<OrgStructureItem>
	{
		@Override
		public void updateItem(OrgStructureItem item, boolean empty)
		{
			super.updateItem(item, empty);
			
			int index = this.getIndex();
			
			String name = null;
			
			if (item == null || empty)
			{
			}
			else
			{
				name = item.getName();
			}
			
			this.setText(name);
			setGraphic(null);


		}
		
	}



