package validateJSONResponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Demo {
	
	@Test
	public void demo()
	{
		RequestSpecification request =RestAssured.given();
		request.baseUri("https://reqres.in");
		request.basePath("/api/users?page/2");
		
		Response response=request.get();
		
		ResponseBody responseBody=response.getBody();
		
		String body=responseBody.asString();
		
		System.out.println(body);
		
		//Check if Janet is present in response
		
		
		Assert.assertEquals(body.contains("Janet"), true,"Not present");
		
		//Traversing through to NODES
		JsonPath js =responseBody.jsonPath();
		System.out.println(js.get("data[1].id"));
		System.out.println(js.get("data[1].email"));
		System.out.println(js.get("data[1].first_name"));
		System.out.println(js.get("data[1].last_name"));
		System.out.println(js.get("data[1].avatar"));
		
		String f_name=js.get("data[1].first_name");
		
		Assert.assertEquals(f_name, "Janet","Not present");
		
		
		
		
		
	}

}
