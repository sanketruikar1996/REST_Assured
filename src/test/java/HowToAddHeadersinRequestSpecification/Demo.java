package HowToAddHeadersinRequestSpecification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo {
	@Test
	public void demo()
	{
		Map<String, String> requestHeader = new HashMap<String,String>();
		requestHeader.put("Header1", "Value1");
		requestHeader.put("Header2", "Value2");

		
		Header header1 = new Header("Header1","Value1");
		Header header2 = new Header("Header2","Value2");
		Header header3 = new Header("Header3","Value3");
		
		List<Header> headerList = new ArrayList<Header>();
		headerList.add(header1);
		headerList.add(header2);
		headerList.add(header3);
		
		Headers header=new Headers(headerList);
		Headers headersObj = new Headers(headerList);
		
				RequestSpecification request=RestAssured.given();
				
				request.headers(headersObj).log().headers();
				request.baseUri("https://reqres.in/api/users?page=1");
				Response resposne =request.get();
				resposne.prettyPrint();
	}

}
