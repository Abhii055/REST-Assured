package Tests;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.baseURI;


public class Examplejson {

	public void test_get() {
		baseURI="http://localhost:3000/";
		given().
		param("subjectid","2").
			get("users").
		then().
			statusCode(200).
			log().all();
	}
	@Test 
	public void test_post() {
		JSONObject request= new JSONObject();
		request.put("first_name", "kanya");
		request.put("last_name", "stree");
		request.put("subjectid",7);
		
		baseURI ="http://localhost:3000";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}
	
	public void test_patch() {
	    JSONObject request = new JSONObject();
	    request.put("last_name","Dyenasol");

	    baseURI = "http://localhost:3000";
	    given()
	        .contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .body(request.toJSONString())
	    .when()
	        .patch("/users/2") // Use RESTful URL structure
	    .then()
	        .statusCode(200)
	        .log().all();
	}
	
	public void test_put() {
		JSONObject request= new JSONObject();
		request.put("first_name", "vaibhav");
		request.put("last_name", "Hichakaaa");
		request.put("subjectid", 99);

	    baseURI = "http://localhost:3000";
	    given()
	        .contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .body(request.toJSONString())
	    .when()
	        .put("/users/3") // Use RESTful URL structure
	    .then()
	        .statusCode(200)
	        .log().all();
	}
	
	public void test_delete() {
	
		baseURI = "http://localhost:3000/";
		
		when().
			delete("/users/578d").
		then().
			statusCode(200);
		
	}
}


