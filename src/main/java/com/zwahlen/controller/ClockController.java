package com.zwahlen.controller;

import java.util.concurrent.atomic.AtomicReference;

import com.zwahlen.clockface.AbstractClockFaceRenderer;
import com.zwahlen.clockface.ClockFace;
import com.zwahlen.states.AbstractClockState;
import com.zwahlen.states.TimeClockState;

public class ClockController {

	private AtomicReference<AbstractClockState> currentStateAtomicRef = new AtomicReference<AbstractClockState>();
	
	private AbstractClockFaceRenderer renderer;

	public void setRenderer(AbstractClockFaceRenderer renderer) {
		this.renderer = renderer;
	}

	private void setState(AbstractClockState newState)
	{
		currentStateAtomicRef.set(newState);
	}

	private long getSleepTime() {
		return currentStateAtomicRef.get().getSleepTime();
	}
	
	private ClockFace getClockFace()
	{
		return currentStateAtomicRef.get().getClockFace();
	}

	public void start()
	{
		
		setState(new TimeClockState());
		long sleepTime = 1000L;

		while (true)
		{
			ClockFace clockFace = getClockFace();
			
			if (clockFace == null)
			{
				setState(new TimeClockState());
				clockFace = getClockFace();
			}
			renderer.pushDisplay(clockFace);
			
			sleepTime = getSleepTime();
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
