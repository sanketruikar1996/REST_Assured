package validateHttpResponseStatus;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class validatableDemo {
	
	int ExpectedStatusCode=200;
	@Test
	void test01()
	{
		
		baseURI="https://reqres.in/api/users/2";
		
		RequestSpecification request=given();
		
		
		Response response=request.get();
		
		ValidatableResponse validate=response.then();
		
		validate.statusCode(ExpectedStatusCode);
		
		
	}

}
