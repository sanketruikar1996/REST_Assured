package validateHeader;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Header {
	@Test
	public void Test()
	{
		
		RequestSpecification request=RestAssured.given();
		
		request.baseUri("https://reqres.in");
		request.basePath("/api/users/2");
		
		Response s=request.get();
		
		//GET value of Specific Header like - Content-Type
		
		String s2 =s.getHeader("Content-Type");
		System.out.println(s2);
		
		//Print all values in Header
		
		Headers s3 =s.getHeaders();
		
		for(io.restassured.http.Header h : s3)
		{
			System.out.println(s3);
		}
		
		
	}

}
