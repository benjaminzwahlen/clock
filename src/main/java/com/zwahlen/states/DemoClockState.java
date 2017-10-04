package com.zwahlen.states;

import java.util.ArrayList;
import java.util.List;

import com.zwahlen.clockface.ClockFace;
import com.zwahlen.clockface.Digit;

public class DemoClockState implements AbstractClockState {

	private int progress = 0;

	@SuppressWarnings("serial")
	private List<int[]> animation = new ArrayList<int[]>()
	{{
		add(new int[] {0, 0, 0, 0});
		add(new int[] {127, 127, 127, 127});
		add(new int[] {0, 0, 0, 0});
		add(new int[] {127, 127, 127, 127});
		add(new int[] {0, 0, 0, 0});
		add(new int[] {127, 127, 127, 127});
		add(new int[] {0, 0, 0, 0});
		add(new int[] {127, 127, 127, 127});
		add(new int[] {0, 0, 0, 0});
		add(new int[] {127, 127, 127, 127});
		add(new int[] {0, 0, 0, 0});
		add(new int[] {127, 127, 127, 127});
		add(new int[] {0, 0, 0, 0});
		add(new int[] {127, 127, 127, 127});
		add(new int[] {0, 0, 0, 0});
		add(new int[] {127, 127, 127, 127});
		add(new int[] {0, 0, 0, 0});
		add(new int[] {127, 127, 127, 127});
		
		
		add(new int[] {2, 0, 0, 0});
		add(new int[] {4, 0, 0, 0});
		add(new int[] {8, 0, 0, 0});
		add(new int[] {0, 8, 0, 0});
		add(new int[] {0, 0, 8, 0});
		add(new int[] {0, 0, 0, 8});
		add(new int[] {0, 0, 0, 16});
		add(new int[] {0, 0, 0, 32});
		add(new int[] {0, 0, 0, 64});
		add(new int[] {0, 0, 64, 0});
		add(new int[] {0, 64, 0, 0});
		add(new int[] {64, 0, 0, 0});
		add(new int[] {2, 0, 0, 0});
		add(new int[] {4, 0, 0, 0});
		add(new int[] {8, 0, 0, 0});
		add(new int[] {0, 8, 0, 0});
		add(new int[] {0, 0, 8, 0});
		add(new int[] {0, 0, 0, 8});
		add(new int[] {0, 0, 0, 16});
		add(new int[] {0, 0, 0, 32});
		add(new int[] {0, 0, 0, 64});
		add(new int[] {0, 0, 64, 0});
		add(new int[] {0, 64, 0, 0});
		add(new int[] {64, 0, 0, 0});
		add(new int[] {2, 0, 0, 0});
		add(new int[] {4, 0, 0, 0});
		add(new int[] {8, 0, 0, 0});
		add(new int[] {0, 8, 0, 0});
		add(new int[] {0, 0, 8, 0});
		add(new int[] {0, 0, 0, 8});
		add(new int[] {0, 0, 0, 16});
		add(new int[] {0, 0, 0, 32});
		add(new int[] {0, 0, 0, 64});
		add(new int[] {0, 0, 64, 0});
		add(new int[] {0, 64, 0, 0});
		add(new int[] {64, 0, 0, 0});
		add(new int[] {2, 0, 0, 0});
		add(new int[] {4, 0, 0, 0});
		add(new int[] {8, 0, 0, 0});
		add(new int[] {0, 8, 0, 0});
		add(new int[] {0, 0, 8, 0});
		add(new int[] {0, 0, 0, 8});
		add(new int[] {0, 0, 0, 16});
		add(new int[] {0, 0, 0, 32});
		add(new int[] {0, 0, 0, 64});
		add(new int[] {0, 0, 64, 0});
		add(new int[] {0, 64, 0, 0});
		add(new int[] {64, 0, 0, 0});
		
		
		
		add(new int[] {2, 0, 0, 0});
		add(new int[] {6, 0, 0, 0});
		add(new int[] {14, 0, 0, 0});
		add(new int[] {14, 0, 0, 0});
		add(new int[] {14, 8, 0, 0});
		add(new int[] {14, 8, 8, 0});
		add(new int[] {14, 8, 8, 8});
		add(new int[] {14, 8, 8, 8});
		add(new int[] {14, 8, 8, 24});
		add(new int[] {14, 8, 8, 56});
		add(new int[] {14, 8, 8, 120});
		add(new int[] {14, 8, 72, 120});
		add(new int[] {14, 72, 72, 120});
		add(new int[] {78, 72, 72, 120});
	}};
	
	@Override
	public ClockFace getClockFace() {
		if (progress >= animation.size())
			return null;
		
		ClockFace face = new ClockFace();
		face.setDigit(1, new Digit(animation.get(progress)[0]));
		face.setDigit(2, new Digit(animation.get(progress)[1]));
		face.setDigit(3, new Digit(animation.get(progress)[2]));
		face.setDigit(4, new Digit(animation.get(progress)[3]));

		progress++;
		
		return face;
	}

	@Override
	public long getSleepTime() {
		return 30l;
	}

	@Override
	public boolean acceptKey(String key, int repeatCount) {
		return true;
	}

}
