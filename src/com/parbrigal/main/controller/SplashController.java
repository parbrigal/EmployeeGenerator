package com.parbrigal.main.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.parbrigal.config.ViewManager;
import com.parbrigal.model.BootstrapDB;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class SplashController implements Initializable {
   
    @FXML
    private ImageView imgLoading;
    
    @FXML 
    private Label lblClose;
    Stage stage;
 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	try
    	{
    	 lblClose.setOnMouseClicked((MouseEvent event) -> {
             Platform.exit();
             System.exit(0);
    	 });
    	 
    	 
    	InputStream is = getClass().getResourceAsStream("/com/parbrigal/view/images/5.gif");
    	 
    	 Image img = new Image(is);
    	 
    	 imgLoading.setImage(img);
    	 go();
    	 
    	 BootstrapDB bs = new BootstrapDB();
 		
 		try {
 			bs.create();
 		} catch (ClassNotFoundException | IOException | SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    	}
    
    		catch (Exception e)
        	{
        		JOptionPane.showMessageDialog(null, e.getMessage());
        		
        		JOptionPane.showMessageDialog(null, e.getMessage());
        	    try
        	    {
        	      PrintWriter pw = new PrintWriter(new File("Error.txt"));
        	      e.printStackTrace(pw);
        	      pw.close();
        	    }
        	    catch (IOException e1)
        	    {
        	      e1.printStackTrace();
        	    }
        	  }
        	  
     
    }
    
    private void go() {
        Service<Void> service = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
					@Override
					protected Void call() throws Exception {
						Thread.sleep(4530);
						return null;
					}           
                  
                };
            }
        };
        service.start();
      
        service.setOnSucceeded((WorkerStateEvent event) -> 
        {
        	lblClose.getScene().getWindow().hide();
            ViewManager config = new ViewManager();
            config.newStage();
        });
    } 
    
    
 
}