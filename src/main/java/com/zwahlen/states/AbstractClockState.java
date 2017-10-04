package com.zwahlen.states;

import com.zwahlen.clockface.ClockFace;

public interface AbstractClockState {

	ClockFace getClockFace();
	
	long getSleepTime();
	
}
