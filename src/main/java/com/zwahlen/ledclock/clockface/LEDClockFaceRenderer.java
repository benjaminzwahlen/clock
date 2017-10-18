package com.zwahlen.ledclock.clockface;

import org.apache.commons.lang3.Conversion;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class LEDClockFaceRenderer implements AbstractClockFaceRenderer
{
	
	final GpioController gpio = GpioFactory.getInstance();
	
	final GpioPinDigitalOutput dataStreamPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
	final GpioPinDigitalOutput shiftPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.LOW);
	final GpioPinDigitalOutput storePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, PinState.LOW);
	
	private ClockFace previousClockFace = null;

	@Override
	public void pushDisplay(ClockFace clockFace)
	{
		if (previousClockFace == null)
		{
			render(clockFace);
		}
		else if (!clockFace.equals(previousClockFace))
		{
			render(clockFace);
		}
		

	}
	
	private void render(ClockFace clockFace)
	{
		previousClockFace = clockFace;
		for (int i=4; i>=1; i--)
		{
			boolean [] arr = new boolean [8];
			arr[7] = true;
			Conversion.intToBinary(clockFace.getDigit(i).getInt(), 0, arr, 0, 7);
			for (boolean bit : arr)
			{
				dataStreamPin.setState(bit);
				shiftPin.setState(PinState.LOW);
				shiftPin.setState(PinState.HIGH);
				
				
			}
		}
		storePin.setState(PinState.HIGH);
		storePin.setState(PinState.LOW);
	}

}
