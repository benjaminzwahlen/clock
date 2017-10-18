package com.zwahlen.ledclock.clockface;

public class ClockFace {

	private Digit [] digits = new Digit [4] ;

	public void setDigit(int i, Digit digit)
	{
		digits[i-1] = digit;
		
	}

	public Digit getDigit(int digit)
	{
		return digits[digit-1];
	}
	
	public void setAllOff()
	{
		setDigit(1, new Digit(0));
		setDigit(2, new Digit(0));
		setDigit(3, new Digit(0));
		setDigit(4, new Digit(0));
	}
	
	public void setAllOn()
	{
		setDigit(1, new Digit(127));
		setDigit(2, new Digit(127));
		setDigit(3, new Digit(127));
		setDigit(4, new Digit(127));
	}
	
	public boolean equals(Object obj)
	{
		if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof ClockFace))
            return false;

        ClockFace rhs = (ClockFace) obj;
        return rhs.getDigit(1).equals(getDigit(1))
        		&& rhs.getDigit(2).equals(getDigit(2))
        		&& rhs.getDigit(3).equals(getDigit(3))
        		&& rhs.getDigit(4).equals(getDigit(4));
		
	}
}
