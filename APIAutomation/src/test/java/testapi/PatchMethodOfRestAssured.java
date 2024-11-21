package testapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ReportManager;

public class PatchMethodOfRestAssured extends BaseTest {

	@Test
	public  void testPATCH_API() {
		
		ReportManager.createTest("Test for PATCH  API"); 
	
       String patchrequestbodydata = "{\"id\":\"2\",\"firstname\" : \"mr satish\", \"lastname\" : \"kumar\"}";
		
        String baseUrl= "https://reqres.in";
		
		RequestSpecification  reqspec = RestAssured.given();
		reqspec.header("Content-Type", "application/json");
		reqspec.pathParam("pageNumber", 2);
		reqspec.body(patchrequestbodydata);
		
		Response res = reqspec.patch(baseUrl+"/api/users/{pageNumber}");
		res.then().assertThat().statusCode(200);
		
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
