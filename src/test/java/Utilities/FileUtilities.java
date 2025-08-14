package Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import Cons.ConstantFiles;


public class FileUtilities {
	public static String readLoginPropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(ConstantFiles.LOGIN_TEST_DATA_FILE_PATH));
		return p.getProperty(key);
	}

	public static String readHomePropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(ConstantFiles.HOME_TEST_DATA_FILE_PATH));
		return p.getProperty(key);
	}
	
	public static String readHomeLeadsLinkFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(ConstantFiles.LEADS_LINK_DROPDOWN));
		return p.getProperty(key);
	}
}
