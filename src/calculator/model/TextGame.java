package calculator.model;

import calculator.controller.CalculatorController;

public class TextGame
{
	private CalculatorController appController;
	
	public TextGame()
	{
		
	}
	
	public String introduction()
	{
		String hello = "Hello?? \nAnyone There?";
		hello += "\n" + "I've been stuck here for days.";
		hello += "\n" + "Can you hear me?";
		
		return hello;
	}
	
	public String firstAct()
	{
		String worried = "";
		
		
		
		return worried;
	}
	
	public boolean choices(String choice)
	{
		boolean yesOrNo = false;
		
		if(choice.equals("Yes"))
		{
			yesOrNo = true;
			return yesOrNo;
		}
		else
		{
			return yesOrNo;
		}
	}
}
