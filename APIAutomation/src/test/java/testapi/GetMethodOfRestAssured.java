package testapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.ReportManager;

public class GetMethodOfRestAssured extends BaseTest{
	/*		
	public static void main(String[] args) {

		Response res = get("https://reqres.in/api/users?page=2");
		
        System.out.println(res.getStatusCode());
		System.out.println( res.getBody().asPrettyString());	
		
	}      */
	

	    @Test
	    public void testGetAPI1() {
	  ReportManager.createTest("Test1 for GET API");

	        Response response = RestAssured
	            .given()
	            .baseUri("https://reqres.in/api")
	            .when()
	            .get("/users?page=2");
	        
             System.out.println("Status code is:"+response.getStatusLine());

             // we are logging the result based on output
	        if (response.statusCode() == 200) {
	          ReportManager.logPass("API responded with correct status code: " + response.statusCode());
	        } 
	        else {
	         ReportManager.logFail("Expected 200 but received: " + response.statusCode());
	        }
	    } 
	    
	    @Test
	    public void testGetAPI2() {
	  ReportManager.createTest("Test2 for GET API");

	        Response response = RestAssured
	            .given()
	            .baseUri("https://reqres.in/api---")
	            .when()
	            .get("/users?page=2");
	        
             System.out.println("Status code is:"+response.getStatusLine());
             Assert.assertEquals(response.getStatusCode(), 404);

             // we are logging the result based on output
	        if (response.statusCode() == 200) {
	          ReportManager.logPass("API responded with correct status code: " + response.statusCode());
	        } 
	        else {
	         ReportManager.logFail("Expected 200 but received: " + response.statusCode());
	        }
	    } 
	
}
