package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonPathResponse {

	@Test
	public void jsonPath() {
		
		given()
			.contentType(ContentType.JSON)
			
		.when()
			.get("http://localhost:3000/UserList")
			
		.then()
			.log().all()
			.body("UserList.users[0].firstName", equalTo("Krish"));	
		
	}
	
	@Test
	public void jsonPathResponse() {
		
		Response res = given()
			.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/UserList");
		
		JSONObject obj = new JSONObject(res.asString());
		
		for(int i = 0; i< obj.getJSONArray("users").length(); i++) {
			
			String firstName = obj.getJSONArray("users").getJSONObject(i).get("phoneNumber").toString();
			System.out.println(firstName);
		}
	}
}
