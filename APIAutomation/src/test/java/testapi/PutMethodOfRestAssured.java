package testapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutMethodOfRestAssured {

	public static void main(String[] args) {
		String putrequestbodydata = "{\"idnumber\":\"5\",\"firstname\" : \"mr satish\", \"lastname\" : \"kumar\"}";
		
        String baseUrl= "https://reqres.in";
		
		RequestSpecification  reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.pathParam("pageNumber", 2);
		reqspec.body(putrequestbodydata);
		
		Response res = reqspec.put(baseUrl+"/api/users/{pageNumber}");
				
		System.out.println(res.asPrettyString());
		System.out.println(res.statusLine());
		
	}

}
