package calculator.controller;

import calculator.model.Calculator;
import calculator.view.CalculatorFrame;
import java.util.Scanner;

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
	
	public int calculateOneOperand(String currentText)
	{
		int answer = 0;
		Scanner calcScanner = new Scanner(currentText);
		
		if(currentText.contains("*"))
		{
			int first = 0;
			int second = 0;
		
			first = calcScanner.nextInt();
			second = Integer.parseInt(currentText.substring(currentText.indexOf(" ", currentText.indexOf("*"))).trim());
			
			answer = appCalculator.multiplyMethod(first, second);
		}
	
		if(currentText.contains("÷"))
		{
			int first = 0;
			int second = 0;
			
			first = calcScanner.nextInt();
			second = Integer.parseInt(currentText.substring(currentText.indexOf(" ", currentText.indexOf("÷"))).trim());
			
			answer = appCalculator.divideMethod(first, second);
		}
		
		if(currentText.contains("+"))
		{
			int first = 0;
			int second = 0;
			
			first = calcScanner.nextInt();
			second = Integer.parseInt(currentText.substring(currentText.indexOf(" ", currentText.indexOf("+"))).trim());
			
			answer = appCalculator.addMethod(first, second);
		}
		
		if(currentText.contains("-"))
		{
			int first = 0;
			int second = 0;
			
			first = calcScanner.nextInt();
			second = Integer.parseInt(currentText.substring(currentText.indexOf(" ", currentText.indexOf("-"))).trim());
			
			answer = appCalculator.subtractMethod(first, second);
		}
		
		return answer;
	}
	
	public int calculateMoreOperands(String currentText)
	{
		int answer = 0;
		
		return answer;
	}
}
