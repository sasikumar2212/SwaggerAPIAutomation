package api.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest2 {

	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setupData() {
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority=1)
	public void testPostUser() throws IOException {
		
		Response response = UserEndPoints2.createUser(userPayload);
		//System.out.println("@!@!@"+response);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	  @Test(priority=2) public void testGetUser() throws IOException { Response
	  response = UserEndPoints2.getUser(this.userPayload.getUsername());
	  response.then().log().all();
	  
	  Assert.assertEquals(response.getStatusCode(), 200); }
	  
	  @Test(priority=3) public void testUpdateUser() throws IOException {
	  userPayload.setFirstname(faker.name().firstName());
	  userPayload.setLastname(faker.name().lastName());
	  userPayload.setEmail(faker.internet().emailAddress());
	  
	  Response response = UserEndPoints2.updateUser(this.userPayload.getUsername(),
	  userPayload); response.then().log().all();
	  
	  Assert.assertEquals(response.getStatusCode(), 200); }
	  
	  @Test(priority=4) public void testDaleteUser() throws IOException { Response
	  response = UserEndPoints2.deleteUser(this.userPayload.getUsername());
	  response.then().log().all();
	  
	  Assert.assertEquals(response.getStatusCode(), 200); }
	 
}
