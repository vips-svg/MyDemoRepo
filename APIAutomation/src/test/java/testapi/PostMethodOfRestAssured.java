package testapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostMethodOfRestAssured {

	public static void main(String[] args) {
		
		String requestbodydata = "{\"title\" : \"mr v\", \"price\" : \"13.5\",  \"description\" : \"electronics set\",\"category\" : \"electronics\"}";
		
		RestAssured.baseURI = "https://fakestoreapi.com/products";
		
		RequestSpecification  reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(requestbodydata);
		
		Response res = reqspec.post();
		System.out.println(res.asPrettyString());
		System.out.println(res.statusLine());

	}

}
