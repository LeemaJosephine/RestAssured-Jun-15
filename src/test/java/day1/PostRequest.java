package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;



public class PostRequest {

	/* 4 ways we can create request body
	 * 1) using HashMap
	 * 2) using org.json
	 * 3) using POJO class (Plain Java Old Object)
	 * 4) using external json file
	 */
	
	@Test
	public void postJson() {
		
		JSONObject data = new JSONObject();
		data.put("name", "Jose");
		data.put("job", "Manager");
		
		given()
			.contentType("application/json")
			.body(data.toString())
			
			.when()
				.post("https://reqres.in/api/users")
			
			.then()
				.statusCode(201)
				.body("name", equalTo("Jose"))
				.log().all();
			
	}
	
	@Test
	public void postPojo() {
		
		PojoClass data = new PojoClass();
		data.setName("Jo");
		data.setJob("Clerk");
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
		
		.then()
			.statusCode(201)
			.body("name", equalTo("Jo"))
			.log().all();
		
	}
	
	@Test
	public void postJsonFile() throws FileNotFoundException {
		
		FileReader fr = new FileReader("C:\\Users\\Digital Suppliers\\eclipse-workspace\\RestAsssuredClass\\src\\test\\java\\day1\\data.json");
		
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("https://reqres.in/api/users")
		
		.then()
			.statusCode(201)
			.body("name", equalTo("Arun"))
			.log().all();
		
		
	}
}
