package com.parbrigal.config;

import java.sql.Date;
import java.time.LocalDate;

import com.parbrigal.main.EEGenerator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ViewManager {
	
	public static void showAlert(String message)
	{
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(message);

		alert.showAndWait();
	}
	
	public static LocalDate getLocalDate(Date date)
	{
		if (date == null)
			return LocalDate.now() ;
		
		return date.toLocalDate();
	}
	
	public static Date getDate(LocalDate localDate)
	{
		return java.sql.Date.valueOf(localDate);
	}
	
	   
    public void newStage(){
    	   try
    	   {
    	   Stage primaryStage = new Stage();
    	   Parent root = FXMLLoader.load(getClass().getResource("/com/parbrigal/view/EEGenerator.fxml"));
			Scene scene = new Scene(root);
			//#3d4956
			scene.getStylesheets().add(getClass().getResource("/com/parbrigal/view/css/JMetroThemeLight.css").toExternalForm());
			primaryStage.setTitle("Employee Generator MK-II");
			primaryStage.getIcons().add(new Image(EEGenerator.class.getResourceAsStream("/com/parbrigal/view/images/generate2.png"))); 
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
    	   }
    	   catch (Exception e)
    	   {
    		   e.printStackTrace();
    	   }
       
    
    }
	
	

}
