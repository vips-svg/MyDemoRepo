package testapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ReportManager;

public class DeleteMethodOfRestAssured extends BaseTest {

	@Test
	public  void testDelete_API() {
		
		ReportManager.createTest("Test for DELETE  API"); 
		
		String baseUrl= "https://reqres.in";
			
			RequestSpecification  reqspec = RestAssured.given();
			reqspec.contentType(ContentType.JSON);
			reqspec.header("Content-Type", "application/json");
			reqspec.pathParam("pageNumber", 2);
						
			Response res = reqspec.delete(baseUrl+"/api/users/{pageNumber}");
				        	res.then().assertThat().statusCode(204);
					
			System.out.println(res.statusLine());
			
			if (res.statusCode() == 204) {
		          ReportManager.logPass("API responded with correct status code: " + res.statusCode());
		        } 
		 else {
		         ReportManager.logFail("Expected 200 but received: " + res.statusCode());
		        }

	}

}
