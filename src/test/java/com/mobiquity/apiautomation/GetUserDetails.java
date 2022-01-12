package com.mobiquity.apiautomation;

import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mobiquity.constants.RelativeURLs;
import com.mobiquity.responsedto.UserDTO;
import com.mobiquity.services.UserDetailsService;
import com.mobiquity.util.APIServiceBase;
import com.mobiquity.util.Config;
import com.mobiquity.util.TestBase;

import io.restassured.response.Response;

public class GetUserDetails extends TestBase {

	private APIServiceBase apiServiceBase;
	private Response getUserResponseDTO;
	static Logger log = Logger.getLogger(GetUserDetails.class.getName());
	public int userId;
	private UserDetailsService userDetailsService;


	public int getUserId(String userName) throws Exception {
		try {
			userDetailsService = new UserDetailsService();
			
			System.out.println("Getting the User ID of: "+userName);
			getUserResponseDTO = userDetailsService.getUserDetails(userName);
			Assert.assertEquals(getUserResponseDTO.getStatusCode(), 200);
			Assert.assertEquals(getUserResponseDTO.jsonPath().get("username[0]"),userName);	
			userId = getUserResponseDTO.jsonPath().get("id[0]");
			
		} catch (Exception e) {
			throw e;
		}
		
		return userId;
	}
}
