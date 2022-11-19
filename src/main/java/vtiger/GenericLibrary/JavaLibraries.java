package vtiger.GenericLibrary;

import java.util.Date;
import java.util.Random;

//single line comment
/*Multi line comment */
/**
 * this class will contains all generic methods related to java
 * @author Rajini
 *
 */

public class JavaLibraries {
	/*THIS METHOD ILL GENERATE RANDOM NUMBER FOR EVERY EXECUTION 
	*@return
	*/
		
			
	public int getRandomNumber() {
	Random ran=new Random();
	int value=ran.nextInt(500);
	return value;
	}
    public String getSystemDate() {
    	Date d=new Date();
    	String date=d.toString();
		return date;
    	
    }
    public String getSystemDateInFormat() {
    	Date d=new Date();
    	String[] dArr=d.toString().split("");
    	String month=dArr[1];
    	String date=dArr[2];
    	String year=dArr[5];
    	String time=dArr[3].replace(":", "-");
    	String dateInFormat=date+"-"+month+"-"+year+"-"+time;
		return dateInFormat;
    	
    }
}
