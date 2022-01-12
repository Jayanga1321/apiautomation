package com.mobiquity.services;

import java.util.Arrays;

import com.mobiquity.constants.RelativeURLs;
import com.mobiquity.responsedto.PostDTO;
import com.mobiquity.responsedto.PostDetailsDTO;
import com.mobiquity.responsedto.UserDTO;
import com.mobiquity.responsedto.UserDetailsDTO;
import com.mobiquity.util.APIServiceBase;
import com.mobiquity.util.Config;

import io.restassured.response.Response;

public class PostDetailsService extends APIServiceBase {
	private final String baseURI;
	private PostDTO postDTO;
	private PostDetailsDTO[] postDetailsDTO;

	public PostDetailsService() {
		this.baseURI = Config.getProperty("mobiquity.url");

	}

	public Response getPostDetails(int userId) throws Exception {

		Response response;

		try {
			response = getRequest(baseURI, RelativeURLs.GET_POST_DETAILS+userId);

			if (response.statusCode() == 200) {

				postDTO = new PostDTO();
				postDetailsDTO = objectMapper.readValue(response.asString(), PostDetailsDTO[].class);
				postDTO.setUser(Arrays.asList(postDetailsDTO));
			} else
				postDTO = new PostDTO();
				postDTO.setResponse(response);

		} catch (Exception ex) {
			throw ex;
		}
		return response;
	}
}
