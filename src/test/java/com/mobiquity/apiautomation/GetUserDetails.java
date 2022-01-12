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
	private UserDTO getUserResponseDTO;
	static Logger log = Logger.getLogger(GetUserDetails.class.getName());
	private String userName;
	private UserDetailsService userDetailsService;

	@BeforeClass
	public void serviceSetUp() throws Exception {
		try {
			userDetailsService = new UserDetailsService();
			userName = getTestData("userName");
		} catch (Exception e) {
			throw e;
		}
	}

	@Test
	public void getUserDetails() throws Exception {
		try {
			log.info("Starting the test....");

			getUserResponseDTO = userDetailsService.getUserDetails(userName);
			Assert.assertEquals(getUserResponseDTO.getStatusCode(), 200);
		} catch (Exception e) {
			throw e;
		}
	}
}
