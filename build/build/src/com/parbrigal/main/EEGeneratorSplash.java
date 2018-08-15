/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parbrigal.main;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EEGeneratorSplash extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
    	
    	try
    	{
    		
    		Parent root = FXMLLoader.load(getClass().getResource("/com/parbrigal/view/splash.fxml"));
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.getIcons().add(new Image(EEGenerator.class.getResourceAsStream("/com/parbrigal/view/images/EmployeeGenerator.ico"))); 
    		stage.initStyle(StageStyle.UNDECORATED);
    		stage.show();
    	}
    	catch (Exception e)
    	{
    		JOptionPane.showMessageDialog(null, e.getMessage());
    	  
    	}
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
   
    
}
