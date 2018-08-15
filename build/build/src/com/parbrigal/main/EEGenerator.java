package com.parbrigal.main;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class EEGenerator extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("/com/parbrigal/view/EEGenerator.fxml"));
			Scene scene = new Scene(root);
			//#3d4956
			scene.getStylesheets().add(getClass().getResource("/com/parbrigal/view/css/JMetroThemeLight.css").toExternalForm());
			primaryStage.setTitle("Employee Generator MK-II");
			primaryStage.getIcons().add(new Image(EEGenerator.class.getResourceAsStream("/com/parbrigal/view/images/generate.png"))); 
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
