package createPojoClassFromJsonData;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SerializationAndDeserialization {

	
	//Aim is Send Employee schema data But Data is in POJO from 
	
	
	@Test
	public void testDemo() throws JsonProcessingException
	{
		//RequestSpecificatiom
		RequestSpecification request=RestAssured.given();
		
		//Create Body
		Employee emp1 = new Employee();
		emp1.setFirstname("Suresh");
		emp1.setLastname("Mehra");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(10000.00);
		ObjectMapper obj=new ObjectMapper();
		String empObj=obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		
		System.out.println(empObj.toString());
		
		
		
		//Send Request
		request.baseUri("http://httpbin.org/post")
		.contentType(ContentType.JSON)
		.body(obj);
		
		
		
		//Get Response
		Response resposne=request.post();
		
		resposne.prettyPrint();
		
		//Validate Response
		Assert.assertEquals(resposne.statusCode(), 200,"Check for status code");
		
		//convert JSON String (empObj) to Class object (Employee)
		
		Employee originalEmployee=obj.readValue(empObj, Employee.class);
		System.out.println(originalEmployee.getFirstname());
		
		
		
		
	}
	
}


