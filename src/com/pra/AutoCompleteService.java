package com.pra;

import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;  
@Path("/AutoCompleteService") 

public class AutoCompleteService {  
	CitiesDao cityDao = new CitiesDao();  
 /*  @GET 
   @Path("/cities") 
   @Produces(MediaType.TEXT_PLAIN) 
   public List<Cities> getUsers(@QueryParam("start") String start,
			@QueryParam("atmost") int to){ 
	   int i=3;
	   i=i+1;
      return cityDao.loadAllcities(start,to); 
      
   }  */
   @GET 
   @Path("/cities") 
   @Produces(MediaType.TEXT_PLAIN) 
   public Response getUsers(@QueryParam("start") String start,
			@QueryParam("atmost") int to){ 
	   StringBuffer result = new StringBuffer("");
	  String s1 = start.toUpperCase();
	   try{List<Cities> citiesList = cityDao.loadAllcities(s1,to);
	        if(citiesList.size()==0);
	        result.append("No Record");
	        for(Cities city:citiesList){
	           result.append(city.getCity());
	           result.append(System.getProperty("line.separator"));
	        }
	   }
	   catch (Exception e)
	   { 
		   result.append("No Record");
	       return Response.status(200).entity(result.toString()).build();
	   }
	  // return Response.status(200).entity("<html> " + "<title>" + "Hello HTML Response" + "</title><body><b>"+result+"</b></body></html>").build();
		 return Response.status(200).entity(result.toString()).build();
  
   } 
}