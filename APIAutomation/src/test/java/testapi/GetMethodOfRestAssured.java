package testapi;

import static io.restassured.RestAssured.get;
import io.restassured.response.Response;

public class GetMethodOfRestAssured {

	public static void main(String[] args) {
				
		Response res = get("https://reqres.in/api/users?page=2");
		
        System.out.println(res.getStatusCode());
		System.out.println( res.getBody().asPrettyString());	
	}
}
