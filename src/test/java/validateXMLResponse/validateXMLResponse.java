package validateXMLResponse;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class validateXMLResponse {
	
	@Test
	public void test()
	{
		String JSONData="{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		
		String XMLData="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		
		//Create RequestSpecification
		
		RequestSpecification request=RestAssured.given();
		
		//BaseURI && BAsePath
		
	     request.baseUri("https://petstore.swagger.io/");
	     request.basePath("v2/pet");
	     
	     //add Headers && BODY -- JSON Format
//	     request.header("accept","application/json")
//	     .header("Content-Type","application/json")
//	     .body(JSONData);
	     
	     
//	     //add Headers && BODY -- XML Format
	     request.header("accept","application/xml")
	     .header("Content-Type","application/xml")
	     .body(XMLData);
	     
	     //send POST request
	    Response response=request.post();
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.statusCode(), 200);
		
		response.then().body("Pet.name",Matchers.equalTo("doggie"));
		
	}

}
