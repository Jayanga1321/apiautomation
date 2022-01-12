package com.mobiquity.apiautomation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mobiquity.services.CommentDetailsService;
import com.mobiquity.services.PostDetailsService;
import com.mobiquity.util.APIServiceBase;
import com.mobiquity.util.TestBase;

import io.restassured.response.Response;

public class GetCommentDetails extends TestBase {
	private APIServiceBase apiServiceBase;
	private Response getCommentResponseDTO;
	static Logger log = Logger.getLogger(GetUserDetails.class.getName());
	public int userId;
	private CommentDetailsService commentDetailsService;
	private GetUserDetails getUserDetails;
	private GetPostDetails getPostDetails;
	private List emailListofComments;
	boolean flag;

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	public boolean validateEmailAddressOfCommentsForaGivenPost(int postId) throws Exception {
		try {

			commentDetailsService = new CommentDetailsService();
			getUserDetails = new GetUserDetails();
			getPostDetails = new GetPostDetails();

			System.out.println("\n Fetching all Comments of the PostID: " + postId);

			getCommentResponseDTO = commentDetailsService.getCommentDetails(postId);
			Assert.assertEquals(getCommentResponseDTO.getStatusCode(), 200);
			Assert.assertEquals(getCommentResponseDTO.jsonPath().get("postId[0]"), postId);

			emailListofComments = getCommentResponseDTO.getBody().jsonPath().getList("email");

			ArrayList<String> emailsArrlist = new ArrayList<String>(emailListofComments);
			ArrayList<String> errornousEmails = new ArrayList<String>();

			for (String email : emailsArrlist) {
				if (validate(email) == false) {
					errornousEmails.add(email);
				}
			}

			if (errornousEmails.size() > 0) {
				flag = false;
			}

			System.out.println("No of invalid emails for the Post: " + postId + " || " + errornousEmails.size());
			for (String error : errornousEmails) {
				System.out.println("This email address is invalid: " + error);
			}

		} catch (Exception e) {
			throw e;
		}

		return flag;
	}
}
