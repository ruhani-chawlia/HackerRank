package org.ruhani.hackerrank.javaPractice;

/** Given a time in -hour AM/PM format, convert it to military (-hour) time. */

import java.util.Scanner ;

public class TimeConversion {
	
	/*method to obtain military time from time in 12-hour format */ 
	static String timeConversion(String s) {
		
		String militaryTime = "";
		
		String[] time = s.split(":"); //split the time based on : as the delimiter
		String hour = time[0];
		String minute = time[1];
		String seconds = time[2].replaceAll("[APM]", "");
        String meridiem = time[2].replaceAll("[0-9]", "");
	
        if((Integer.parseInt(hour)>=1 && Integer.parseInt(hour)<=12) && 
        		(Integer.parseInt(minute)>=0 && Integer.parseInt(minute)<=59) && 
        		(Integer.parseInt(seconds)>=0 && Integer.parseInt(seconds)<=59)) { //constraints
        	
        	//if merifiem is AM, just remove the AM from the time
        	if(meridiem.equals("AM")) {
        		if(!hour.equals("12")) 
        			militaryTime = s.replaceAll("AM", "");        			
        		else
        			militaryTime = new String("00" + ":" + minute + ":" + seconds);
        	}
        	//if meridiem is PM, convert the hour into 24-hour format
        	else if(meridiem.equals("PM")) {
        		if(!hour.equals("12"))
        			militaryTime = new String((Integer.parseInt(hour)+12) + ":" + minute + ":" + seconds);
        		else
        			militaryTime = new String(hour + ":" + minute + ":" + seconds);
        	}
        }
        
        return militaryTime;
    }

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in); //input the time
        String s = in.next(); //read the time
        String result = timeConversion(s); //obtain the military time from time in 12-hour format
        System.out.println(result); //print the military time
        in.close();
    }

}
