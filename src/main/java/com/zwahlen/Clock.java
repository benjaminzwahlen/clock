package com.zwahlen;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.zwahlen.controller.ClockController;

public class Clock {

	public static void main(String[] args) {

		try (FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("Beans.xml"))
		{
			ClockController controller = (ClockController) context.getBean("clockController");
			controller.start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
