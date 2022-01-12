package com.mobiquity.services;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.mobiquity.constants.RelativeURLs;
import com.mobiquity.responsedto.CommentDTO;
import com.mobiquity.responsedto.CommentDetailsDTO;
import com.mobiquity.responsedto.PostDTO;
import com.mobiquity.responsedto.PostDetailsDTO;
import com.mobiquity.responsedto.UserDTO;
import com.mobiquity.responsedto.UserDetailsDTO;
import com.mobiquity.util.APIServiceBase;
import com.mobiquity.util.Config;

import io.restassured.response.Response;

public class CommentDetailsService extends APIServiceBase {
	private final String baseURI;
	private CommentDTO commentDTO;
	private CommentDetailsDTO[] commentDetailsDTO;

	public CommentDetailsService() {
		this.baseURI = Config.getProperty("mobiquity.url");

	}

	public Response getCommentDetails(Integer postId) throws Exception {

		Response response;

		try {
			response = getRequest(baseURI, RelativeURLs.GET_COMMENT_DETAILS+postId);

			if (response.statusCode() == 200) {

				commentDTO = new CommentDTO();
				commentDetailsDTO = objectMapper.readValue(response.asString(), CommentDetailsDTO[].class);
				commentDTO.setUser(Arrays.asList(commentDetailsDTO));
			} else
				commentDTO = new CommentDTO();
				commentDTO.setResponse(response);

		} catch (Exception ex) {
			throw ex;
		}
		return response;
	}
}
