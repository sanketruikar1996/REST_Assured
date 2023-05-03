package firstRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class firstRequest {
	@Test
	void testCase01()
	{
		
		Response getResponse=RestAssured.get("https://reqres.in/api/users/2");
		System.out.println("Printing Response");
		System.out.println("=====================");
		System.out.println(getResponse.asString());
		System.out.println("Printing StatusCode");
		System.out.println("=====================");
		System.out.println("StatusCode: "+ getResponse.statusCode());
		
		
		
	}

}
