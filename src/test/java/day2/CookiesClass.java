package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesClass {

	@Test
	public void getCookie() {
		
		Response res= when()
			.get("https://www.google.com/");
		
//			String cookie_value = res.getCookie("AEC"); // return a string --> to extract specific cookie information
//			System.out.println(cookie_value);
			
			Map<String, String> cookies = res.getCookies();  // to extract list of cookies and it's value
			for(String cookie : cookies.keySet()) {
				System.out.println(cookie+" "+res.getCookie(cookie));
			}
			
		
//		.then()
//			.log().cookies()
//			.cookie("AEC", "AQTF6Hxs73BGMszwxf1ZJP_sikEL3uyZ7pE5KrRvjc6HgiwY_uPa0gxWB9Y");
	}
}
