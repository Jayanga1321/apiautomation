package com.mobiquity.util;

import org.testng.annotations.BeforeSuite;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestBase {
	private static String urlPath;
	private File file;
	private static String testDataPath;
	private static JSONParser parser;
	protected Map<String, JSONObject> value;
	static Logger log = Logger.getLogger(TestBase.class.getName());
	static Logger log1 = Logger.getGlobal();


	@BeforeSuite(alwaysRun = true)
	public void startUp() throws Exception {

		try {
			Config.setConfigFilePath("/config/config.properties");
			testDataPath = Config.getProperty("env.data");
			urlPath = Config.getProperty("mobiquity.url");
			parser = new JSONParser();
			
		} catch (Exception e) {
			throw e;
		}
	}
	@SuppressWarnings("unchecked")
	public JSONObject getJSONTestData(String filename ,String dataName) throws IOException, ParseException {

		try {
			file = new File(testDataPath, filename);
			value = (Map<String, JSONObject>)parser.parse(new FileReader(file));
			return value.get(dataName);

		}catch (NullPointerException e){
			log.info("error"+e);
			throw e;}

	}

	public String getTestData(String propertyName) throws IOException, ParseException {
		return getJSONTestData("envdata","userData").get(propertyName).toString();
	}

}
