package assignment_utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ReaderClass {


	public String get(String key) throws Exception {
		FileInputStream file=new FileInputStream("./config.properties");
		Properties prop =new Properties();
		prop.load(file);
		return (String) prop.get(key);
	}


}
