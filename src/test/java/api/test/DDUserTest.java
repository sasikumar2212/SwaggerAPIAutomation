package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;


import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utility.DataProviders;
import io.restassured.response.Response;

public class DDUserTest {
	
	@Test(priority=1,dataProvider="fetchData",dataProviderClass=DataProviders.class)
	public void testPostUser(Integer userId, String uname,String fname,String lname, String email, String pwd,Integer ph) {
		//System.out.println(userId + " - " + uname + " - " + fname+ " - " + lname+ " - " + email+ " - " + pwd+ " - " + ph);
		User userPayload = new User();
		
		//userPayload.setId(Integer.parseInt(userId));
		userPayload.setId(userId);
		userPayload.setUsername(uname);
		userPayload.setFirstname(fname);
		userPayload.setLastname(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph.toString());
		
		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=2,dataProvider="fetchData",dataProviderClass=DataProviders.class)
	public void testDeleteUser(Integer userId, String uname,String fname,String lname, String email, String pwd,Integer ph) {
		Response response = UserEndPoints.deleteUser(uname);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
