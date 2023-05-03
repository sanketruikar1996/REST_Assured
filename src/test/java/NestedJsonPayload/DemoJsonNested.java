package NestedJsonPayload;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class DemoJsonNested {
	@Test
	public void demoNested() throws JsonProcessingException
	{
		//Create Data 
		
		Employee emp1 = new Employee();
		emp1.setFirstname("Suresh");
		emp1.setLastname("Mehra");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(10000.00);
		
		Address ad=new Address();
		ad.setStreet("1234 Safardarjanfg magr");
		ad.setCity("Delhi");
		ad.setPincode(12542890);
		ad.setState("Delhi");
		
		emp1.setAddress(ad); 
		
		ObjectMapper obj=new ObjectMapper();
		String jsonObject=obj.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		
		System.out.println(jsonObject);
		
		//Create RequestSpecification
		RequestSpecification request=RestAssured.given();
		
		//add baseURI and headers
		
		request.baseUri("http://httpbin.org/post").contentType(ContentType.JSON).body(jsonObject);
		
		//send post request and recieve resposne
		Response resposne=request.post();
		
		Assert.assertEquals(200,resposne.statusCode(), "Wrong status code received");
	}

}
