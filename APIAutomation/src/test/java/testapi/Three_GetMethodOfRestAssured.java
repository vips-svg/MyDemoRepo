package testapi;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.Config;
import utilities.ReportManager;

public class Three_GetMethodOfRestAssured extends BaseTest{
	    @Test
	    public void testGetAPI() {
	  Config.loadProperties("src/test/resources/Config2.properties");
	  
	  ReportManager.createTest("Test for GET API");

	        Response response = RestAssured
	            .given()
	            .baseUri(Config.get("base.url"))
	            .when()
	            .get((Config.get("endpoint.users"))+(Config.get("queryparam.page"))+"&"+(Config.get("queryparam.id")));
	          
	        
	        System.out.println("Status code is:"+response.getStatusLine());
            System.out.println("\u001B[1m"+"\u001B[33m"+"------------------------------------ PAGE 1 -> RESPONSE BODY----------------------------------------------------"+"\u001B[0m");
           System.out.println("Body is:"+response.asPrettyString());
           
            String first_name = response.jsonPath().getString("data.first_name");
            String last_name = response.jsonPath().getString("data.last_name");
           
            
	        if (response.statusCode() == 200) {
	          ReportManager.logPass("API responded with correct status code: " + response.statusCode());
	        } 
	        else {
	         ReportManager.logFail("Expected 200 but received: " + response.statusCode());
	        }	
	        
	        ReportManager.logInfo("First name of the user for "+(Config.get("queryparam.page"))+ " and "+(Config.get("queryparam.id"))+" is: " + "<b>" + first_name + "</b>");
	        ReportManager.logInfo("Last name of the user for "+(Config.get("queryparam.page"))+ " and "+(Config.get("queryparam.id"))+" is: " +"<b>" + last_name + "</b>");
	    } 
	
}
