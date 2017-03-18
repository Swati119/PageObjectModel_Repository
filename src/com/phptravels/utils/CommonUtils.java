package com.phptravels.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonUtils {
	
	public String readProperties(String propertyFileName, String key){
		Properties prop = new Properties();
		InputStream input = null;
		String propertyValue = "";
		
		try {

			input = new FileInputStream(propertyFileName);

			// load a properties file
			prop.load(input);
						
			propertyValue = prop.getProperty(key);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return propertyValue;
	}
}
