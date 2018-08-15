package com.parbrigal.main;

import javax.swing.ImageIcon;

public class Utilities
{
  public Utilities() {}
  
  public static ImageIcon setIcon(String path)
  {
    java.net.URL url = System.class.getResource(path);
    
    if (url == null) {
      System.out.println("::Unable to find image::");
    }
    
    ImageIcon icon = new ImageIcon(url);
    return icon;
  }
  
}