package com.zwahlen.states;

import com.zwahlen.clockface.ClockFace;

public interface AbstractClockState {

	public ClockFace getClockFace();
	
	public long getSleepTime();
	
	public boolean acceptKey(String key, int repeatCount);
	
}
