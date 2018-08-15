package com.parbrigal.main.controller;

import com.parbrigal.model.GenEmployeeDetail;

public class IdCreator {
	
	public static String getIdNumber()
	{
		return GenEmployeeDetail.getID(19, 70);
	}

}
