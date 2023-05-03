package JSONManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ComplexJSONToJavaMap {
	
	/*{
	   "firstName":"Amod",
	   "lastName":"Mahajan",
	   "age": 28,
	   "salary": 10000.56,
	   "IsMarried":true,
	   "Hobbies":["Music","Computer","Games"],
	 "TechSkill":{
			"Programming language":"Java",
			"WebAutomation":"Selenium",
			"API testing" : "Rest Assured"
			
	             }
	   
	 }*/
	
	@Test
	public void demo()
	{
		
		//Create Map object
		Map<String,Object> userData=new HashMap<String,Object>();
		userData.put("firstName","Amod");
		userData.put("lastName","Mahajan");
		userData.put("age","28");
		userData.put("salary",100000.56);
		userData.put("IsMarried", true);
		ArrayList<String> hoobies=new ArrayList<String>();
		hoobies.add("Music");
		hoobies.add("Computer");
		hoobies.add("Games");
		userData.put("Hobbies", hoobies);
		Map<String,Object> technicalSkiils=new HashMap<String,Object>();
		technicalSkiils.put("Programming language","java");
		technicalSkiils.put("WebAutomation","Selenium");
		technicalSkiils.put("API testing","Rest Assured");
		userData.put("TechSkill", technicalSkiils);
		
		//RequestSpecification create
		
				RequestSpecification request =RestAssured.given();
				
				//add basePath and baseURI
				
				request.baseUri("https://reqres.in/");
				request.basePath("api/users");
				
				//add header
				request.contentType(ContentType.JSON)
				.body(userData);
				
				//send-request
				Response response=request.post();
				
				System.out.println(response.asPrettyString());
				
				
				Assert.assertEquals(response.statusCode(), 201,"check for status code.");
		
		
		
		
	}

}
