package com.mobiquity.services;

import java.util.Arrays;

import com.mobiquity.constants.RelativeURLs;
import com.mobiquity.responsedto.UserDTO;
import com.mobiquity.responsedto.UserDetailsDTO;
import com.mobiquity.util.APIServiceBase;
import com.mobiquity.util.Config;

import io.restassured.response.Response;

public class UserDetailsService extends APIServiceBase {
	private final String baseURI;
	private UserDTO userDTO;
	private UserDetailsDTO[] userDetailsDTO;

	public UserDetailsService() {
		this.baseURI = Config.getProperty("mobiquity.url");

	}

	public Response getUserDetails(String userName) throws Exception {

		Response response;

		try {
			response = getRequest(baseURI, RelativeURLs.GET_USER_DETAILS.replace("{id}", userName));

			if (response.statusCode() == 200) {

				userDTO = new UserDTO();
				userDetailsDTO = objectMapper.readValue(response.asString(), UserDetailsDTO[].class);
				userDTO.setUser(Arrays.asList(userDetailsDTO));
				
			} else

				userDTO = new UserDTO();
				userDTO.setResponse(response);

		} catch (Exception ex) {
			throw ex;
		}
		return response;
	}
}