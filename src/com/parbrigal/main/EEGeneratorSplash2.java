/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parbrigal.main;

import javax.swing.JOptionPane;

import javafx.application.Preloader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EEGeneratorSplash2 extends Preloader {
    
    @Override
    public void start(Stage stage) throws Exception {
    	
    	try
    	{
    		
    		//stage.getIcons().add(new Image(EEGenerator.class.getResourceAsStream("/com/parbrigal/view/images/generate.png"))); 
    		stage.initStyle(StageStyle.UNDECORATED);
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
    
    @Override
    public void handleProgressNotification(ProgressNotification pn) {
  
    }
 
    @Override
    public void handleStateChangeNotification(StateChangeNotification evt) {
        if (evt.getType() == StateChangeNotification.Type.BEFORE_START) {
        }
    }
    
   
    
}
