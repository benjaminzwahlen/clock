package com.zwahlen.ledclock.clockface;

import java.util.HashMap;
import java.util.Map;

public class Digit
{
	private int binary;
	
	@SuppressWarnings("serial")
	public static final Map <String, Integer> mapping = new HashMap<String, Integer>()
			{{
				put("", 0);
				put("0", 126);
				put("1", 48);
				put("2", 109);
				put("3", 121);
				put("4", 51);
				put("5", 91);
				put("6", 95);
				put("7", 112);
				put("8", 127);
				put("9", 115);
			}};
	
	public Digit(String digit)
	{
		binary = mapping.get(digit);
	}
	public Digit(int binaryPattern)
	{
		binary = binaryPattern;
	}
	
	public int getInt()
	{
		return binary;
	}
	
	public boolean equals(Object obj)
	{
		if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Digit))
            return false;

        Digit rhs = (Digit) obj;
        return rhs.getInt() == getInt();
		
	}
}
