package IgnoreNullDefaultEmptyValuesInPayload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Demo {
	@Test
	public void demo() throws JsonProcessingException
	{
		
		Employee e1=new Employee();
		e1.setFirstname("MDS");
		//e1.setLastname("Dravid");
		e1.setGender("Male");
		e1.setAge(56);
		e1.setSalary(2000000);
		e1.setMarried(false);
		
		// Empty array
				String[] hobbies=  new String[2];
				hobbies[0] = "Reading";
				hobbies[1] = "Music";
				e1.setHobbies(hobbies);
				
		//List of Degrees
				
				List<String> degree=new ArrayList<String>();
				degree.add("BCA");
				degree.add("MCA");
				degree.add("MSC");
				e1.setDegrees(degree);
				
		//Family Member
				
				Map<String,String> familyMembers = new HashMap<String,String>();
				familyMembers.put("1", "Mother");
				familyMembers.put("2", "Father");
				e1.setFamilyMembers(familyMembers);
				
				
		
		ObjectMapper obj=new ObjectMapper();
		String s=obj.writerWithDefaultPrettyPrinter().writeValueAsString(e1);
		System.out.println(s);
		
		//Create requestSpecification
		RequestSpecification request=RestAssured.given();
		
		//add baseUri and headers and body
		request.baseUri("http://httpbin.org/post").contentType(ContentType.JSON).body(s);
		
		//send request and collect response
		Response resposne=request.post();
		
		//print respone
		resposne.asPrettyString();
		
		//add assertions
		Assert.assertEquals(resposne.statusCode(), 200,"check for status code.");
		
		//add assertion to field
		
		ResponseBody body=resposne.getBody();
		
		JsonPath bodyString=body.jsonPath();
		
		System.out.println(bodyString.get("age"));
		
		
	}

}
