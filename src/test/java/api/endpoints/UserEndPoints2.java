package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Created for perform Create,Read,Update and Delete requests for the user
public class UserEndPoints2 {
	
	static Properties getURl(String filename) throws IOException {
		FileReader reader = new FileReader("src/test/resources/"+filename);
		System.out.println(reader+"---------src/test/resources/"+filename);
		Properties p = new Properties();
		p.load(reader);
		return p;
	}
	
	
	public static Response createUser(User payload) throws IOException {
		Properties pro = getURl("routes.properties");
		String postURL = pro.getProperty("PostURL");
		//String base = pro.getProperty("baseURL");
		System.out.println(postURL+"------"+payload);
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(postURL);
		return response;	
		
	}
	public static Response getUser(String userName) throws IOException {
		Properties pro = getURl("routes.properties");
		String getURL = pro.getProperty("GetURL");
		Response response = given()
				.pathParam("username", userName)
				.when()
				.get(getURL);
		return response;	
		
	}
	public static Response updateUser(String userName, User payload) throws IOException {
		Properties pro = getURl("routes.properties");
		String updateURL = pro.getProperty("UpdateURL");
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				.when()
				.put(updateURL);
		return response;	
		
	}
	public static Response deleteUser(String userName) throws IOException {
		Properties pro = getURl("routes.properties");
		String deleteURL = pro.getProperty("DeleteURL");
		Response response = given()
				.pathParam("username", userName)
				.when()
				.delete(deleteURL);
		return response;	
		
	}
}
