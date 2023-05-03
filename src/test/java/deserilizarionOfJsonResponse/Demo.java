package deserilizarionOfJsonResponse;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Demo {
    @Test
	public void deserlizate()
	{
    	
    	
    	RequestSpecification request=RestAssured.given();
    	
    	request.baseUri("https://reqres.in/");
    	request.basePath("api/users/");
    	
    	//create request body
        JSONObject data=new JSONObject();
    	data.put("name","MSDF");
    	data.put("job","Captain");
    	
    	//perform post request
    	Response respone=request
    			.contentType(ContentType.JSON)
    			.body(data.toJSONString())
    			.post();
    	
    	System.out.println(respone.asPrettyString());
    	
    	//Deserialize responseBody i.e json resoponse body to class object
		
    	//Class<T> is a generic form of any class of type T which is also referred to as template class.
    	ResponseBody body=respone.body();
    	
    	JSONPOSTDeseriliz deObject=body.as(JSONPOSTDeseriliz.class);
    	
    	Assert.assertEquals(deObject.name, "MSDF","Wrong name");
    	
    	
    	
		
	}
}
