package bddDemo;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class staticImport {
	@Test
	void test01()
	{
		
		baseURI="https://reqres.in/api/users";
		given()
		.queryParam("page","2")
		.when()
		.get()
		.then()
		.statusCode(200);
	}

}
