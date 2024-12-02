package testapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import utilities.ReportManager;
import org.json.JSONObject;


public class Second_PostMethodOfRestAssured extends BaseTest {
	@Test
	public  void testPOSTAPI() {
		 ReportManager.createTest("Test for POST API with 3 Requests");
		
		 RestAssured.baseURI = "https://fakestoreapi.com/products";
		
		 String[] payloads = { new JSONObject().put("title", "Mr. A").put("price", "12.67").toString(),
				new JSONObject().put("title", "Mr. B").put("price", "13.67").toString(),
				new JSONObject().put("title", "Mr. C").put("price", "14.67").toString()				
		};
				
		for (String payload : payloads) {
			MultiPayloadsManager.sendPostRequest(payload);
        }		 
    
	}

}
