package com.cowin.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	Properties p;
	public ConfigurationReader() throws IOException {
		File f = new File("/Users/r.harish/eclipse-workspace/com.cowin/src/main/java/com/cowin/property/cowin.properties");
		FileInputStream fi = new FileInputStream(f);
		 p = new Properties();
		 p.load(fi);
		 
	}
	
	
	public String getBrowser() {
		
		 String browser = p.getProperty("browser");
		 return browser;
	}
public String getUrl() {
	String url = p.getProperty("url");
	return url;
}


}
