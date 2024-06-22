	package Tests;
	import org.json.simple.JSONObject;
import org.testng.Assert;
	import org.testng.annotations.Test;

	import static io.restassured.RestAssured.*;
	import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
	
	 
	public class TestsExample {
		@Test
		public void Test_1() {
			Response response = get("https://reqres.in/api/users?page=2");
			System.out.println(response.getStatusCode());
			System.out.println(response.getTime());
			System.out.println(response.asString());
			System.out.println(response.statusLine());
			System.out.println(response.header("content-type "));
			int  status= response.getStatusCode();
			Assert.assertEquals(status, 200);
		}
		@Test
		public void Test_2() {
			baseURI="https://reqres.in/api";
			given().
				get("/users?page=2").
			then().
			statusCode(200).
			body("data[1].id", equalTo(8)).
			body("data.first_name",hasItem("George")).
			log().all();;
		}
		@Test
		public void TestPost() {
			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("name", "morpheus");
			map.put("job", "leader");
			System.out.println(map);
			JSONObject request = new JSONObject(map);
			System.out.println(request);
			
			baseURI="https://reqres.in/api";
			given().
				header("Contect-Type","application/json").
				contentType(ContentType.JSON).accept(ContentType.JSON).
				body(request.toJSONString()).
			when().
				post("/users").
			then().
				statusCode(201).log().all();
		}
		
		
		
		
	}
