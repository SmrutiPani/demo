package com.example.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.model.TalkingClock;


@Service
public class TalkingClockServiceImpl implements TalkingClockService {
	
	private static final Logger logger = LoggerFactory.getLogger(TalkingClockServiceImpl.class);
	
	@Override
	public TalkingClock getTime(Integer hr, Integer min) {
		TalkingClock tt = new TalkingClock();
		String  w, timetext;
		String words[] = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
				"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty",
				"Twenty one", "Twenty two", "Twenty three", "Twenty four", "Twenty five", "Twenty six", "Twenty seven",
				"Twenty eight", "Twenty nine" };
		System.out.println("Enter Hour");
		System.out.println("Enter Minutes");
		if (hr > 12) {
			hr = hr - 12;
		}
		
		if(hr==0) {
			hr=12;
		}

		if ((hr >= 0 && hr <= 12) && (min >= 0 && min <= 59)) {
			
			if (hr == 12) // Storing "One" in 'w' if hr is 12
			{
				w = words[1];
			} else // Storing Next value of hour in 'w' if hour is between 1-11
			{
				w = words[hr + 1];
			}
			if (min == 0) {
				logger.debug("Time Entered - " + hr + " : " + min);
				logger.debug(words[hr] + " O' clock");
				//System.out.println("Time Entered - " + hr + " : " + min);
				//System.out.println(words[hr] + " O' clock");
				timetext = words[hr] + " O' clock";
			} else if (min == 15) {
				logger.debug("Time Entered - " + hr + " : " + min);
				logger.debug("Quarter Past " + words[hr]);
				//System.out.println("Time Entered - " + hr + " : " + min);
				//System.out.println("Quarter Past " + words[hr]);
				timetext = "Quarter Past " + words[hr];

			} else if (min == 30) {
				logger.debug("Time Entered - " + hr + " : " + min);
				logger.debug("Half Past " + words[hr]);
				//System.out.println("Time Entered - " + hr + " : " + min);
				//System.out.println("Half Past " + words[hr]);
				timetext = "Half Past " + words[hr];
			} else if (min == 45) {
				logger.debug("Time Entered - " + hr + " : " + min);
				logger.debug("Quarter to " + w);
				//System.out.println("Time Entered - " + hr + " : " + min);
				//System.out.println("Quarter to " + w);
				timetext = "Quarter to " + w;
			} else if (min < 30) // Condition for minutes between 1-29
			{
				logger.debug("Time Entered - " + hr + " : " + min);
				logger.debug(words[min] + " past " + words[hr]);
				//System.out.println("Time Entered - " + hr + " : " + min);
				//System.out.println(words[min] + " past " + words[hr]);
				timetext = words[min] + " past " + words[hr];
			} else // Condition for minutes between 30-59
			{
				logger.debug("Time Entered - " + hr + " : " + min);
				logger.debug(words[60 - min] + " to " + w);
				//System.out.println("Time Entered - " + hr + " : " + min);
				//System.out.println(words[60 - min] + " to " + w);
				timetext = words[60 - min] + " to " + w;
			}
		} // end of outer if statement
		else {
			logger.debug("Invalid Time Entered");
			//System.out.println("Invalid Time Entered");
			timetext = "Invalid Time Entered";
		}
		tt.setResponse(timetext);
		return tt;
	}
}
