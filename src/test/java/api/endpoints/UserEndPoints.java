package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;

//Created for perform Create,Read,Update and Delete requests for the user
public class UserEndPoints {
	
	public static Response createUser(User payload) {
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(Routes.postUrl);
		return response;	
		
	}
	public static Response getUser(String userName) {
		Response response = given()
				.pathParam("username", userName)
				.when()
				.get(Routes.getUrl);
		return response;	
		
	}
	public static Response updateUser(String userName, User payload) {
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				.when()
				.put(Routes.updatetUrl);
		return response;	
		
	}
	public static Response deleteUser(String userName) {
		Response response = given()
				.pathParam("username", userName)
				.when()
				.delete(Routes.deleteUrl);
		return response;	
		
	}
}
