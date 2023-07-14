package utils;

import java.util.Date;

public class utilities {
	public static final int IMPLICT_TIME=10;
//	public static final int PAGELOADOUT_TIME=5; 
	public static String TimeStamp() {
		Date d = new Date();
		String t = d.toString().replace(" ", "-").replace(":", "_");
		return t;
	}

}
