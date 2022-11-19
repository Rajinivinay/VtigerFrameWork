package vtiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileLibrary {
	public String readDtaFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IConstantsLibrary.propertyFilePath);
		Properties pObj=new Properties();
		pObj.load(fis);
		String value=pObj.getProperty(key);
		return value;
		
	}

}
