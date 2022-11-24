package vtiger.GenericLibrary;

import java.util.Date;
import java.util.Random;

public class JavaFileLibrary {
	  /**
	   * This method will generate random number for every execution 
	   * @return
	   */
		public int getRandomNumber()
		{
			Random ran =new Random();
			int value =ran.nextInt(500);
			return value;
		}
		/**
		 * This method will generate the system date
		 * @return
		 */
		public String  getSytemDate()
		{
			Date d =new Date();
			 String date=d.toString();
			return date;
		}
		public String getSystemDateInFormat()
		{
			Date d=new Date();
			 String [] dArr=d.toString().split(" ");
			   String month=dArr[1];
			String date  =dArr[2];
			 String year=dArr[5];
			String time=  dArr[3].replace(":", "-");
			
			 String dateInformat =date+"-"+month+"-"+year+" "+time;
			 return dateInformat;
		}

}
