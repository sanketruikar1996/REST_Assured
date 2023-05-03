package validateHttpResponseStatus;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class failedTestValidateErroLine {
	String ExpectedStatusCode="HTTP/1.1 200 OK";
	@Test
	void test01()
	{
		
		baseURI="https://reqres.in/api/users/2tt";
		
		RequestSpecification request=given();
		Response response=request.get();
		
		String actutalStatusLine=response.getStatusLine();
		
		Assert.assertEquals(actutalStatusLine, ExpectedStatusCode,"Incorrect Status Line received");
	}
}
