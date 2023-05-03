package bddDemo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class firstPOSTRequest {
	@Test
	void post()
	{
		JSONObject jsonData=new JSONObject();
		jsonData.put("name", "Sanket");
		jsonData.put("job", "Quality Assurance Engineer");
		
		
		baseURI="https://reqres.in/api/users";
		given()
		.header("Content-type","Application/Json")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString())
		.when()
		.post()
		.then()
		.statusCode(201)
		.log()
		.all();
	}
	
	@Test
	void put()
	{
		JSONObject jsonData=new JSONObject();
		jsonData.put("name", "Sanket Ruikar");
		jsonData.put("job", "Software Development Engineer");
		
		
		baseURI="https://reqres.in/api/users/420";
		given()
		.header("Content-type","Application/Json")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString())
		.when()
		.put()
		.then()
		.statusCode(200)
		.log()
		.all();
	}
	@Test
	void patch()
	{
		JSONObject jsonData=new JSONObject();
		jsonData.put("job", "Automation ENgineer");
		
		RestAssured.baseURI="https://reqres.in/api/users/420";
		RestAssured.given()
		.when()
		.patch()
		.then()
		.statusCode(200)
		.log()
		.all();
	}
	@Test
	void delete()
	{
		RestAssured.baseURI="https://reqres.in/api/users/420";
		RestAssured.given()
		.when()
		.delete()
		.then()
		.statusCode(204)
		.log()
		.all();
		
	}
	
	
	
}
