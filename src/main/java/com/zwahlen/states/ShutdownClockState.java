package com.zwahlen.states;

import java.io.IOException;

import com.zwahlen.clockface.ClockFace;
import com.zwahlen.clockface.Digit;

public class ShutdownClockState implements AbstractClockState {

	private int progress=0;
	
	private boolean shuttingDown = false;
	boolean pressed = true;
	
	@Override
	public ClockFace getClockFace() {
		if (shuttingDown)
		{
			ClockFace face = new ClockFace();
			face.setAllOff();
			return face;
		}
		if (!pressed)
			return null;
		pressed = false;
		ClockFace face = new ClockFace();
		switch (progress) {
		case 0:
			face.setDigit(1, new Digit(2));
			face.setDigit(2, new Digit(0));
			face.setDigit(3, new Digit(0));
			face.setDigit(4, new Digit(0));
			break;
		case 1:
			face.setDigit(1, new Digit(6));
			face.setDigit(2, new Digit(0));
			face.setDigit(3, new Digit(0));
			face.setDigit(4, new Digit(0));
			break;
		case 2:
			face.setDigit(1, new Digit(14));
			face.setDigit(2, new Digit(0));
			face.setDigit(3, new Digit(0));
			face.setDigit(4, new Digit(0));
			break;
		case 3:
			face.setDigit(1, new Digit(14));
			face.setDigit(2, new Digit(8));
			face.setDigit(3, new Digit(0));
			face.setDigit(4, new Digit(0));
			break;
		case 4:
			face.setDigit(1, new Digit(14));
			face.setDigit(2, new Digit(8));
			face.setDigit(3, new Digit(8));
			face.setDigit(4, new Digit(0));
			break;
		case 5:
			face.setDigit(1, new Digit(14));
			face.setDigit(2, new Digit(8));
			face.setDigit(3, new Digit(8));
			face.setDigit(4, new Digit(8));
			break;
		case 6:
			face.setDigit(1, new Digit(14));
			face.setDigit(2, new Digit(8));
			face.setDigit(3, new Digit(8));
			face.setDigit(4, new Digit(24));
			break;
		case 7:
			face.setDigit(1, new Digit(14));
			face.setDigit(2, new Digit(8));
			face.setDigit(3, new Digit(8));
			face.setDigit(4, new Digit(56));
			break;
		case 8:
			face.setDigit(1, new Digit(14));
			face.setDigit(2, new Digit(8));
			face.setDigit(3, new Digit(8));
			face.setDigit(4, new Digit(120));
			break;
		case 9:
			face.setDigit(1, new Digit(14));
			face.setDigit(2, new Digit(8));
			face.setDigit(3, new Digit(72));
			face.setDigit(4, new Digit(120));
			break;
		case 10:
			face.setDigit(1, new Digit(14));
			face.setDigit(2, new Digit(72));
			face.setDigit(3, new Digit(72));
			face.setDigit(4, new Digit(120));
			break;
		case 11:
			face.setDigit(1, new Digit(78));
			face.setDigit(2, new Digit(72));
			face.setDigit(3, new Digit(72));
			face.setDigit(4, new Digit(120));
			break;
		case 12:
			face.setAllOff();
			break;
		default:
			try {
				shuttingDown = true;
				Runtime.getRuntime().exec("shutdown -h now");
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		progress++;
		return face;
	}

	@Override
	public long getSleepTime() {
		return 200l;
	}

	@Override
	public boolean acceptKey(String key, int repeatCount) {
		pressed = true;
		
		//Return true so that no further processing happens
		return true;
	}

}
