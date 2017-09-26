package com.pra;

import java.io.Serializable;  
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 
@XmlRootElement(name = "Cities") 

public class Cities implements Serializable {  
   private static final long serialVersionUID = 1L; 
   
   private String city;  
   public Cities(){} 
    
   public Cities(String city){  
     
      this.city = city; 
   }  
 
   public String getCity() { 
      return city; 
   } 
   @XmlElement 
   public void setCity(String city) { 
	   this.city = city; 
   }   
} 