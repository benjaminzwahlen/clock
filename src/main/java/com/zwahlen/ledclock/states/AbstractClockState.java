package com.zwahlen.ledclock.states;

import com.zwahlen.ledclock.clockface.ClockFace;

public interface AbstractClockState {

	ClockFace getClockFace();
	
	long getSleepTime();
	
}
