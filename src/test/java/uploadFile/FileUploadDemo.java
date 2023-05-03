package uploadFile;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FileUploadDemo {

	@Test
	public void demo()
	{  File path=new File("C:\\Users\\Sanket\\OneDrive\\Desktop\\New Text Document (2).txt");
		
		RequestSpecification s=RestAssured.given();
		s.baseUri("http://httpbin.org/");
		s.basePath("post");
		
	//	s.header("accept","application/json")
		s.multiPart("files",path)
		.contentType(ContentType.MULTIPART);
		
		
      Response response =s.post();
		
		//print response body
		response.prettyPrint();
		
		//validate status code
		Assert.assertEquals(response.statusCode(), 200,"Check for status code");
		
	}
}
