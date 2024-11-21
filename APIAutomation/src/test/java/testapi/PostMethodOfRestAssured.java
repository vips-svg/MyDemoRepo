package testapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ReportManager;

public class PostMethodOfRestAssured extends BaseTest {

	@Test
	public  void testPOSTAPI() {
		 ReportManager.createTest("Test for POST API");
		
		String requestbodydata = "{\"title\" : \"Mr. V\", \"price\" : \"13.5\",  \"description\" : \"electronics set\",\"category\" : \"electronics\"}";
		
		RestAssured.baseURI = "https://fakestoreapi.com/products";
		
		RequestSpecification  reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(requestbodydata);
		
		Response res = reqspec.post();
		System.out.println(res.asPrettyString());
		System.out.println(res.statusLine());
		
		String getActualTitleValue = res.jsonPath().getString("title");
        String expectedTitleValue = "Mr. V";    
        Assert.assertTrue(getActualTitleValue.equals(expectedTitleValue));
        
        if (getActualTitleValue.equalsIgnoreCase(expectedTitleValue)) {
	          ReportManager.logPass("API responded with correct title: " + expectedTitleValue);
	        } 
	 else {
	         ReportManager.logFail("Expected "+ expectedTitleValue+ " but received: " + getActualTitleValue);
	        }
        
		if (res.statusCode() == 200) {
	          ReportManager.logPass("API responded with correct status code: " + res.statusCode());
	        } 
	 else {
	         ReportManager.logFail("Expected 200 but received: " + res.statusCode());
	        }

	}

}
