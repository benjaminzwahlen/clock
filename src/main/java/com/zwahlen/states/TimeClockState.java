package com.zwahlen.states;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

import com.zwahlen.clockface.ClockFace;
import com.zwahlen.clockface.Digit;

public class TimeClockState implements AbstractClockState {

	
	@Override
	public long getSleepTime() {
		return 100l;
	}

	@Override
	public ClockFace getClockFace() {
		
		Date date = new Date();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		
		String hoursString = StringUtils.leftPad(Integer.toString(hour), 2, "0");
		String minuteString = StringUtils.leftPad(Integer.toString(minute), 2, "0");
		
		ClockFace clockface = new ClockFace();
		
		clockface.setDigit(1, new Digit(hoursString.substring(0, 1)));
		clockface.setDigit(2, new Digit(hoursString.substring(1, 2)));
		clockface.setDigit(3, new Digit(minuteString.substring(0, 1)));
		clockface.setDigit(4, new Digit(minuteString.substring(1, 2)));
		
		return clockface;
	}

	@Override
	public boolean acceptKey(String key, int repeatCount) {
		//The zwahlen face doesn't care if a button is pressed.
		return false;
	}

}
