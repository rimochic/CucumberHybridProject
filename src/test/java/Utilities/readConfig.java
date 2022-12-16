package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readConfig {
	Properties pro;
	
	public readConfig() {
		File src = new File("./Configurations/config.properties");
		
		try {
			FileInputStream fi = new FileInputStream(src);
			pro = new Properties();
			pro.load(fi);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public String getBrowser() {
		String url = pro.getProperty("browser");
		return url;
	}
	

}
