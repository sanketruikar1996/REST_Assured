package JSONArrayRequestBody;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONArrayRequestBodyDemo {

	@SuppressWarnings("unchecked")
	@Test
	public void test()
	{
		//create 3 users Data JOSN array 
		
		JSONObject user1 = new JSONObject();
		user1.put("firstName","Prachi");
		user1.put("lastName","Gupta");
		user1.put("age",28);
		user1.put("salary",10000.56);
		
		JSONObject user2 = new JSONObject();
		user2.put("firstName","Prerna");
		user2.put("lastName","Gupta");
		user2.put("age",28);
		user2.put("salary",10000.56);
		
		JSONObject user3 = new JSONObject();
		user3.put("firstName","Jatin");
		user3.put("lastName","Gupta");
		user3.put("age",28);
		user3.put("salary",10000.56);
		
		
		//by using 3 JSONObject create 1 array of JSON
		
		JSONArray jsArray=new JSONArray();
		jsArray.add(user1);
		jsArray.add(user2);
		jsArray.add(user3);
		
		//create Request Specification
		RequestSpecification reqSpec = RestAssured.given();
		
		//specify URL
		reqSpec.baseUri("https://reqres.in/api/users");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsArray);
		
		//perform post request
		Response response = reqSpec.post();
		
		response.prettyPrint();
		
		//Validate the status code
		Assert.assertEquals(response.statusCode(), 201,"Check for status code.");
		
	}
}
