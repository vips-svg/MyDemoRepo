package testapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.Config;
import utilities.ReportManager;

public class Two_GetMethodOfRestAssured extends BaseTest{
	    @Test
	    public void testGetAPI1() {
	  ReportManager.createTest("Test1 for GET API");

	        Response response = RestAssured
	            .given()
	            .baseUri(Config.get("base.url"))
	            .when()
	            .get((Config.get("endpoint.users"))+(Config.get("queryparam.page1")));
	        
             System.out.println("Status code is:"+response.getStatusLine());
             System.out.println("\u001B[1m"+"\u001B[33m"+"------------------------------------ PAGE 1 -> RESPONSE BODY----------------------------------------------------"+"\u001B[0m");
             System.out.println("Body is:"+response.asPrettyString());
             
         
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
	  ReportManager.createTest("Test1 for GET API");

	        Response response = RestAssured
	            .given()
	            .baseUri(Config.get("base.url"))
	            .when()
	            .get((Config.get("endpoint.users"))+(Config.get("queryparam.page2")));
	        
             System.out.println("Status code is:"+response.getStatusLine());
             System.out.println("\u001B[1m"+"\u001B[33m"+"------------------------------------ PAGE 2 -> RESPONSE BODY----------------------------------------------------"+"\u001B[0m");
             System.out.println("Body is:"+response.asPrettyString());
            

             // we are logging the result based on output
	        if (response.statusCode() == 200) {
	          ReportManager.logPass("API responded with correct status code: " + response.statusCode());
	        } 
	        else {
	         ReportManager.logFail("Expected 200 but received: " + response.statusCode());
	        }
	    } 
	    
	    @Test
	    public void testGetAPI3() {
	  ReportManager.createTest("Test1 for GET API");

	        Response response = RestAssured
	            .given()
	            .baseUri(Config.get("base.url"))
	            .when()
	            .get((Config.get("endpoint.users"))+(Config.get("queryparam.page3")));
	        
             System.out.println("Status code is:"+response.getStatusLine());
             System.out.println("\u001B[1m"+"\u001B[33m"+"------------------------------------ PAGE 3-> RESPONSE BODY----------------------------------------------------"+"\u001B[0m");
             System.out.println("Body is:"+response.asPrettyString());
          

             // we are logging the result based on output
	        if (response.statusCode() == 200) {
	          ReportManager.logPass("API responded with correct status code: " + response.statusCode());
	        } 
	        else {
	         ReportManager.logFail("Expected 200 but received: " + response.statusCode());
	        }
	    } 
	
}
