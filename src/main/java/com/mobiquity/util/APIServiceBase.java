package com.mobiquity.util;

import java.util.Map;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class APIServiceBase extends RestUtil {

	public Response getRequest(Map<String, Object> headers, String baseURI, String relativeURI) throws Exception {

		try {
			setBaseURI(baseURI);
			setBasePath(relativeURI);

			Response response = given().headers(headers).when().get();

			// Clear Base Path
			resetBaseURI();
			resetBasePath();

			return response;

		} catch (Exception ex) {
			throw ex;
		}
	}

}
