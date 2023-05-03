package uploadFile;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UploadImageasFileDemo {
	@Test
	public void uploadImage()
	{
		File file=new File("C:\\Users\\Sanket\\Downloads\\Cat.jpg");
		RequestSpecification request=RestAssured.given();
		request.baseUri("https://petstore.swagger.io/");
		request.basePath("v2/pet/123/uploadImage");
		
		Response response=request.header("accept","application/json")
		.contentType(ContentType.MULTIPART).multiPart("file",file).post();
		
		System.out.println(response.asPrettyString());
		
		//validate status code
		Assert.assertEquals(response.statusCode(), 200,"Check for status code");
	}

}
