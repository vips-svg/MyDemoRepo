package testapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ReportManager;

public class MultiPayloadsManager {

	public static void sendPostRequest(String payload) {
        // Create RequestSpecification
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        
        request.body(payload);

        // Send POST request
        Response response = request.post();
        
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asPrettyString());
        
        if (response.statusCode() == 200) {
	          ReportManager.logPass("API responded with correct status code: " + response.statusCode());
	        } 
	    else {
	         ReportManager.logFail("Expected 200 but received: " + response.statusCode());
	        }
        
        System.out.println("-----------------------------------------------------------------------------------");
    }
}
