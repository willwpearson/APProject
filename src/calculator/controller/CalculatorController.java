package calculator.controller;

import calculator.model.Calculator;
import calculator.view.CalculatorFrame;

public class CalculatorController
{
	private CalculatorFrame appFrame;
	private Calculator appCalculator;
	
	public CalculatorController()
	{
		appFrame = new CalculatorFrame(this);
		appCalculator = new Calculator();
	}
	
	public void start()
	{
		
	}
	
	public int calculateAnswer(String currentText)
	{
		int answer = 0;
		
		if(currentText.contains("+"))
		{
			int first = 0;
			int second = 0;
			
			first = Integer.parseInt(currentText.substring(0, currentText.indexOf(" ")));
			second = Integer.parseInt(currentText.substring(currentText.indexOf(" ", currentText.indexOf("+"))).trim());
			
			answer = appCalculator.addMethod(first, second);
		}
		
		if(currentText.contains("-"))
		{
			int first = 0;
			int second = 0;
			
			first = Integer.parseInt(currentText.substring(0, currentText.indexOf(" ")));
			second = Integer.parseInt(currentText.substring(currentText.indexOf(" ", currentText.indexOf("-"))).trim());
			
			answer = appCalculator.subtractMethod(first, second);
		}
		
		if(currentText.contains("*"))
		{
			int first = 0;
			int second = 0;
			
			first = Integer.parseInt(currentText.substring(0, currentText.indexOf(" ")));
			second = Integer.parseInt(currentText.substring(currentText.indexOf(" ", currentText.indexOf("*"))).trim());
			
			answer = appCalculator.multiplyMethod(first, second);
		}
		
		if(currentText.contains("÷"))
		{
			int first = 0;
			int second = 0;
			
			first = Integer.parseInt(currentText.substring(0, currentText.indexOf(" ")));
			second = Integer.parseInt(currentText.substring(currentText.indexOf(" ", currentText.indexOf("÷"))).trim());
			
			answer = appCalculator.divideMethod(first, second);
		}
		
		return answer;
	}
}
