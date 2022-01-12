package com.mobiquity.util;

import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public abstract class APIServiceBase extends RestUtil {
    protected ObjectMapper objectMapper = new ObjectMapper();

    public APIServiceBase() {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, false);
    }


	public Response getRequest(String baseURI, String relativeURI) throws Exception {

		try {
			setBaseURI(baseURI);
			setBasePath(relativeURI);

			Response response = given().when().get();

			// Clear Base Path
			resetBaseURI();
			resetBasePath();

			return response;

		} catch (Exception ex) {
			throw ex;
		}
	}

}
