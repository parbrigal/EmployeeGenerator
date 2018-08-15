package com.parbrigal.main.controller;

import java.util.Iterator;
import java.util.List;

public class EmployeeIterator implements Iterator{
	
	  private Iterator<Employee> iterator;
	  
	  public EmployeeIterator(List<Employee> employees)
	  {
	    iterator = employees.iterator();
	  }
	  
	  public boolean hasNext()
	  {
	    return iterator.hasNext();
	  }
	  
	  public Object next()
	  {
	    return iterator.next();
	  }
	  
	  public void remove()
	  {
	    iterator.remove();
	  }
}
