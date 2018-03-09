package calculator.controller;

import calculator.model.Calculator;
import calculator.model.TextGame;
import calculator.view.CalculatorFrame;
import java.util.Scanner;

public class CalculatorController
{
	private CalculatorFrame appFrame;
	private Calculator appCalculator;
	private TextGame appGame;
	
	public CalculatorController()
	{
		appFrame = new CalculatorFrame(this);
		appCalculator = new Calculator();
		appGame = new TextGame();
	}
	
	public void start()
	{
		
	}
	
	public double calculateOneOperand(String currentText)
	{
		double answer = 0.0;
		Scanner calcScanner = new Scanner(currentText);
		
		if(currentText.contains("*"))
		{
			double first = 0.0;
			double second = 0.0;
		
			first = calcScanner.nextDouble();
			second = Double.parseDouble(currentText.substring(currentText.indexOf(" ", currentText.indexOf("*"))).trim());
			
			answer = appCalculator.multiplyMethod(first, second);
		}
	
		if(currentText.contains("÷"))
		{
			double first = 0.0;
			double second = 0.0;
			
			first = calcScanner.nextDouble();
			second = Double.parseDouble(currentText.substring(currentText.indexOf(" ", currentText.indexOf("÷"))).trim());
			
			answer = appCalculator.divideMethod(first, second);
		}
		
		if(currentText.contains("+"))
		{
			double first = 0.0;
			double second = 0.0;
			
			first = calcScanner.nextDouble();
			second = Double.parseDouble(currentText.substring(currentText.indexOf(" ", currentText.indexOf("+"))).trim());
			
			answer = appCalculator.addMethod(first, second);
		}
		
		if(currentText.contains("-"))
		{
			double first = 0.0;
			double second = 0.0;
			
			first = calcScanner.nextDouble();
			second = Double.parseDouble(currentText.substring(currentText.indexOf(" ", currentText.indexOf("-"))).trim());
			
			answer = appCalculator.subtractMethod(first, second);
		}
		
		calcScanner.close();
		return answer;
	}
	
	public void textGameFun()
	{
		
	}
}
