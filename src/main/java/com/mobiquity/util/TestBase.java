package com.mobiquity.util;

import org.testng.annotations.BeforeSuite;

public class TestBase {
	private static String urlPath;

	@BeforeSuite(alwaysRun = true)
	public void startUp() throws Exception {

		try {
			Config.setConfigFilePath("/apiautomation/src/test/resources/config/config.properties");
			urlPath = Config.getProperty("mobiquity.url");
		} catch (Exception e) {
			throw e;
		}
	}
}
