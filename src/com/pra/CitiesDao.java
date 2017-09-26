package com.pra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;  
import java.io.FileReader;
import java.io.IOException; 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;  

public class CitiesDao { 
	
	public static Trie trieData = new Trie();
 
	static{
         String csvFile = "All_India_pincode_data_18082017.csv";
        String line = "";
        String cvsSplitBy = ",";
       String cityUpdateUpper="";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] cityName = line.split(cvsSplitBy);
                cityUpdateUpper=cityName[0].toUpperCase();
                trieData.insert(cityUpdateUpper);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
   
   public  List<Cities> loadAllcities(String str,int x){ 
	 Collection <String> d= new ArrayList<String>();
	   List <Cities> cityList= new ArrayList<Cities>();
       d=trieData.autoComplete(str);
       for(int i=0;i<d.size();i++) {
       	System.out.println(((ArrayList<String>) d).get(i)+" ");
       if(i<x)
       	cityList.add(new Cities(((ArrayList<String>) d).get(i)));
       }
       	
  
   return cityList; 
   }

  
   
    
}