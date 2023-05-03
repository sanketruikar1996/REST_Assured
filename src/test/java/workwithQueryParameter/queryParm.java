package workwithQueryParameter;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class queryParm {

//	@Test
	public void demo()
	{
		
		RequestSpecification request=RestAssured.given();
		
		request.baseUri("https://reqres.in/");
		request.basePath("api/users");
		request.queryParam("page", 2);
		
		Response response=request.get();
		
		System.out.println(response.asString());
	}
	@Test
	public void demo2()
	{
		
		RequestSpecification request=RestAssured.given();
		
		request.baseUri("https://reqres.in/");
		request.basePath("api/users");
		request.queryParam("page", 2).queryParam("id", 7);
		
		Response response=request.get();
		
		System.out.println(response.asString());
		
		ResponseBody body=response.body();
		
		JsonPath jsonResponse=body.jsonPath();
		
		String f_name=jsonResponse.get("data.first_name");
		
		System.out.println(f_name);
		
		Assert.assertEquals("Michaelooooo",f_name,"Wrong FirstName");
	}
}
