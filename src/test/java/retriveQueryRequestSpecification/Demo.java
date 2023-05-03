package retriveQueryRequestSpecification;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class Demo {
@Test
public void demo()
{
	
	            RequestSpecification request=RestAssured.given();
	            
	            request.baseUri("https://reqres.in/");
	            request.basePath("api/users");
	            
	            //CREATE POST BODY
	            
	            JSONObject data=new JSONObject();
	            data.put("name","Dravid");
	            data.put( "job" ,"The Wall");
	            
	            Response response=request
	            		.contentType(ContentType.JSON)
	            		.body(data.toJSONString())
	            		.post();
	            
	           //GET values from RequestSpecification
	            
	            
	           QueryableRequestSpecification qury=SpecificationQuerier.query(request);
	            
	           //Get BaseUri
	           String baseUri=qury.getBaseUri();
	           System.out.println(baseUri);
	           
	          //Get BasePath
	           String basePath=qury.getBasePath();
	           System.out.println(basePath);
	           
	           //Get RequestBody
	           String body=qury.getBody();
	           System.out.println(body);
	           
	           //Get Request Headers
	           Headers header =qury.getHeaders();
	           
	           for(Header h : header)
	           {
	        	   System.out.println(h);
	           }

}
	


}
