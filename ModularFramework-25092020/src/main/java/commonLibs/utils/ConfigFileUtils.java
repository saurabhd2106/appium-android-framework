package commonLibs.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileUtils {
	
	public static Properties readConfigFile(String filename) throws Exception {
		filename = filename.trim();
		
		InputStream fileReader = new FileInputStream(filename);
		
		Properties properties = new Properties();
		
		properties.load(fileReader);
		
		return properties;
	}

}
