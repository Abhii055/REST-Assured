package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class putPatchDeleteExample {
	@Test	
	public void testPut() {
		JSONObject request = new JSONObject();
		request.put("name","morpheus");
		request.put("job","leader");
		System.out.println(request);

		baseURI="https://reqres.in/api";
		given().
			header("Contect-Type","application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).log().all();
		
		
	}
	@Test	
	public void testPatch() {
		JSONObject request = new JSONObject();
		request.put("name","Hichkaeus");
		request.put("job","leader");
		System.out.println(request);

		baseURI="https://reqres.in";
		given().
			header("Contect-Type","application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).log().all();
		
		
	}
	@Test	
	public void testDelete() {
		
		baseURI="https://reqres.in";
		given().
		when().
			delete("/api/users/2").
		then().
			statusCode(204).log().all();
		
		
	}

}
