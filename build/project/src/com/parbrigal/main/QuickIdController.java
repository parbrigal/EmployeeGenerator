package com.parbrigal.main;

import com.parbrigal.main.controller.IdCreator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class QuickIdController {
	
	@FXML
	private TextField idTextField;
	
	@FXML
	private Button get;
	
	
	public void getId()
	{
		idTextField.clear();
		idTextField.appendText(IdCreator.getIdNumber());
	}

}
