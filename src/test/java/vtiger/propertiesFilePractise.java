package vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class propertiesFilePractise {
	public static void main(String[] args) throws Exception {
		
		//load the  file into java stream
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		//create obj of properties
		Properties pobj=new Properties();
		
		//load the file input stream to properties
		pobj.load(fis);
		
		//use the keys to read the values
		String BROWER=pobj.getProperty("browser");
		System.out.println(BROWER);
		
		String URL=pobj.getProperty("url");
		System.out.println(URL);
		
		String USERNAME = pobj.getProperty("username");
		System.out.println(USERNAME);
		
		String PASSWORD = pobj.getProperty("password");
		System.out.println(PASSWORD);
	}

}
 