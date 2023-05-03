package validateHttpResponseStatus;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.*;

public class getTest {
	int ExpectedStatusCode=200;
	@Test
	void test01()
	{
		
		baseURI="https://reqres.in/api/users/2";
		
		RequestSpecification request=given();
		
		
		Response response=request.get();
		
		int actutalStatusCode=response.statusCode();
		
		Assert.assertEquals(actutalStatusCode, ExpectedStatusCode,"Right code received");
	}

}
