package createJSONfromPOJOClassArray;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import createPojoClassFromJsonData.Employee;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreateJSONFromJavaArray {
	@Test
	public void demoTest() throws JsonProcessingException
	{
		
		//Create Data--Java POJO Array to JSON 
		
		Employee emp1 = new Employee();
		emp1.setFirstname("Suresh");
		emp1.setLastname("Mehra");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(10000.00);
		
		Employee emp2 = new Employee();
		emp1.setFirstname("Suresh");
		emp1.setLastname("Kundra");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(10000.00);
		
		Employee emp3 = new Employee();
		emp1.setFirstname("Suresh");
		emp1.setLastname("Mehtra");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(10000.00);
		
		Employee emp4 = new Employee();
		emp1.setFirstname("Suresh");
		emp1.setLastname("ZunZunWala");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(10000.00);
		
		
		ArrayList<Employee> employeeList=new ArrayList<Employee>();
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		employeeList.add(emp4);
		
		//Convert to JSONdata
		
		ObjectMapper Object=new ObjectMapper();
		String jsonData=Object.writerWithDefaultPrettyPrinter().writeValueAsString(Object);
		
		//Create Request object from RequestSpecification
		
		RequestSpecification request=RestAssured.given();
		
		//add URI and Header
		request.baseUri("http://httpbin.org/post")
		.contentType(ContentType.JSON)
		.body(jsonData);
		
		//send request and collect response
		Response response=request.post();
		
		//print resposne
		response.asPrettyString();
		
		//AsseertResponse
		Assert.assertEquals(response.statusCode(),200,"Wrong code ");
		
		
		//convert JsonArray to Employee class objects (Deserialization)
		ResponseBody body=response.body();
		
        JsonPath jsonPathView = body.jsonPath();
		
		List<Employee> allEmployees = jsonPathView.getList("json", Employee.class);

	
		System.out.println("----------Emoployee objects in ResponseBody----------------");

		for(Employee emp:allEmployees)
		{
			System.out.println(emp.getFirstname()+ " " + emp.getLastname());
		}
		
		
	}

}
