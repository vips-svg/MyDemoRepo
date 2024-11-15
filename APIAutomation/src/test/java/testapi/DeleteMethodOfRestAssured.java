package testapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteMethodOfRestAssured {

	public static void main(String[] args) {
		
		String baseUrl= "https://reqres.in";
			
			RequestSpecification  reqspec = RestAssured.given();
			reqspec.contentType(ContentType.JSON);
			reqspec.pathParam("pageNumber", 2);
						
			Response res = reqspec.delete(baseUrl+"/api/users/{pageNumber}");
				        	res.then().assertThat().statusCode(204);
					
			System.out.println(res.statusLine());

	}

}
