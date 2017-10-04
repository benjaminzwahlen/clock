package com.zwahlen.controller;

import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.lang3.StringUtils;

import com.zwahlen.clockface.AbstractClockFaceRenderer;
import com.zwahlen.clockface.ClockFace;
import com.zwahlen.states.AbstractClockState;
import com.zwahlen.states.DemoClockState;
import com.zwahlen.states.ShutdownClockState;
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
		boolean stop = false;
		
		setState(new TimeClockState());
		long sleepTime = 1000l;

		while (!stop)
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
	
	public void acceptKey(String key, int repeatCount)
	{
		
		boolean stop = currentStateAtomicRef.get().acceptKey(key, repeatCount);
		//If stop is true, it means that the state has handled the keypress, no need to do anything else
		if (!stop)
		{
			if (StringUtils.equals("KEY_POWER", key))
			{
				currentStateAtomicRef.set(new ShutdownClockState());
			} else if (StringUtils.equals("KEY_0", key))
			{
				currentStateAtomicRef.set(new DemoClockState());
			}
		}
	}
}
