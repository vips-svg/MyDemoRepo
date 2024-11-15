package testapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchMethodOfRestAssured {

	public static void main(String[] args) {
	
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
		
	}

}
