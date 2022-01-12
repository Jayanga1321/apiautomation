package com.mobiquity.e2e;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mobiquity.apiautomation.GetCommentDetails;
import com.mobiquity.apiautomation.GetPostDetails;
import com.mobiquity.apiautomation.GetUserDetails;
import com.mobiquity.util.TestBase;

public class E2ETests extends TestBase{
	
	GetPostDetails getPostdetails;
	GetCommentDetails getCommentDetails; 
	GetUserDetails getUserDetails;
	ArrayList<Integer> postIds;
	SoftAssert softAssertion;
	
	@Test
	public void verifyEmailAddressValidityOfPostComments() {
		
		getPostdetails = new GetPostDetails();	
		getCommentDetails = new GetCommentDetails();
		getUserDetails = new GetUserDetails();
		softAssertion= new SoftAssert();
		
		try {
			
			postIds = getPostdetails.getPostsFromASpecificPersonId(getUserDetails.getUserId(getTestData("userName")));
			//Validating email addresses of comments for each post
			for(Integer postId : postIds) {
				
				softAssertion.assertTrue(getCommentDetails.validateEmailAddressOfCommentsForaGivenPost(postId), "There are invalid emails for the Post : "+postId+ " of user: "+getTestData("userName"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
