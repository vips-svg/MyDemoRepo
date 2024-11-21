package testapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ReportManager;

public class PutMethodOfRestAssured extends BaseTest{

	@Test
	public  void testPUTAPI() {
		ReportManager.createTest("Test for PUT  API");
		
		String putrequestbodydata = "{\"idnumber\":\"5\",\"firstname\" : \"mr satish\", \"lastname\" : \"kumar\"}";
		
        String baseUrl= "https://reqres.in";
		
		RequestSpecification  reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.pathParam("pageNumber", 2);
		reqspec.body(putrequestbodydata);
		
		Response res = reqspec.put(baseUrl+"/api/users/{pageNumber}");
				
		System.out.println(res.asPrettyString());
		System.out.println(res.statusLine());
		
		if (res.statusCode() == 200) {
	          ReportManager.logPass("API responded with correct status code: " + res.statusCode());
	        } 
	 else {
	         ReportManager.logFail("Expected 200 but received: " + res.statusCode());
	        }
		
	}

}
