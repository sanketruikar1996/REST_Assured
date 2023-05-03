package JSONArrayRequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateJsonArrayUsingList {
	@Test
	public void demo()
	{
		Map<String,Object> user1=new HashMap<String,Object>();
		user1.put("firstName","Prachi");
		user1.put("lastName","Gupta");
		user1.put("age","28");
		user1.put("salary",100000.56);
		
		Map<String,Object> user2=new HashMap<String,Object>();
		user2.put("firstName","Prachi");
		user2.put("lastName","Joshi");
		user2.put("age","28");
		user2.put("salary",100000.56);
		
		Map<String,Object> user3=new HashMap<String,Object>();
		user3.put("firstName","Prachi");
		user3.put("lastName","Kulkarni");
		user3.put("age","28");
		user3.put("salary",100000.56);
		
		List<Map<String,Object>> jsPayload=new ArrayList<Map<String,Object>>();
		jsPayload.add(user1);
		jsPayload.add(user2);
		jsPayload.add(user3);
		
		//create Request Specification
				RequestSpecification reqSpec = RestAssured.given();
				
				//specify URL
				reqSpec.baseUri("https://reqres.in/api/users");
				reqSpec.contentType(ContentType.JSON);
				reqSpec.body(jsPayload);
				
				//perform post request
				Response response = reqSpec.post();
				
				response.prettyPrint();
				
				//Validate the status code
				Assert.assertEquals(response.statusCode(), 201,"Check for status code.");
		
		
		
		
		
	}

}
