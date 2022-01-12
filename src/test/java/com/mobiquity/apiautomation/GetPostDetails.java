package com.mobiquity.apiautomation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mobiquity.services.PostDetailsService;
import com.mobiquity.services.UserDetailsService;
import com.mobiquity.util.APIServiceBase;
import com.mobiquity.util.TestBase;

import io.restassured.response.Response;

public class GetPostDetails extends TestBase{

	private APIServiceBase apiServiceBase;
	private Response getPostResponseDTO;
	static Logger log = Logger.getLogger(GetUserDetails.class.getName());
	private PostDetailsService postDetailsService;
	private GetUserDetails getUserDetails;
	private List postsList;
	private ArrayList<Integer> posts;
	
	public ArrayList<Integer> getPostsFromASpecificPersonId(int userId) throws Exception {
		try {
			
			postDetailsService = new PostDetailsService();
			getUserDetails = new GetUserDetails();
			
			System.out.println("\n Fetching all Post IDs of UserId: "+userId);

			getPostResponseDTO = postDetailsService.getPostDetails(userId);
			Assert.assertEquals(getPostResponseDTO.getStatusCode(), 200);
			Assert.assertEquals(getPostResponseDTO.jsonPath().get("userId[0]"),userId);
			
			postsList = getPostResponseDTO.getBody().jsonPath().getList("id");

			Iterator<List> it = postsList.iterator();
			while (it.hasNext()) {
	            System.out.print(it.next());
	            System.out.print(" ");
	        }
			
			posts = new ArrayList<Integer>(postsList);

		} catch (Exception e) {
			throw e;
		}
		
		return posts;
	}
}
