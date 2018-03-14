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
	
	public double calculateOneOperand(String currentText)
	{
		double answer = 0.0;
		Scanner calcScanner = new Scanner(currentText);
		
		//startComplexity
		if(currentText.contains("*"))
		{
			double first = 0.0;
			double second = 0.0;
		
			first = calcScanner.nextDouble();
			second = Double.parseDouble(currentText.substring(currentText.indexOf(" ", currentText.indexOf("*"))).trim());
			
			answer = appCalculator.multiplyMethod(first, second);
		}
		//endComplexity
		else if(currentText.contains("÷"))
		{
			double first = 0.0;
			double second = 0.0;
			first = calcScanner.nextDouble();
			second = Double.parseDouble(currentText.substring(currentText.indexOf(" ", currentText.indexOf("÷"))).trim());
			//startAbstraction
			answer = appCalculator.divideMethod(first, second);
			//endAbstraction
		}
		else if(currentText.contains("+"))
		{
			double first = 0.0;
			double second = 0.0;
			
			first = calcScanner.nextDouble();
			second = Double.parseDouble(currentText.substring(currentText.indexOf(" ", currentText.indexOf("+"))).trim());
			
			answer = appCalculator.addMethod(first, second);
		}
		else if(currentText.contains("-"))
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
	
	public double calculateMultipleOperands(String currentText)
	{
		double answer = 0.0;
		Scanner calcScanner = new Scanner(currentText);
		
		while(calcScanner.hasNextDouble())
		{
			double first = calcScanner.nextDouble();
			String operand = calcScanner.next();
			double second = calcScanner.nextDouble();
			
			if(operand == "*")
			{
				answer += appCalculator.multiplyMethod(first, second);
			}
			else if(operand == "÷")
			{
				answer += appCalculator.divideMethod(first, second);
			}
			else if(operand == "+")
			{
				answer += appCalculator.addMethod(first, second);
			}
			else if(operand == "-")
			{
				answer += appCalculator.subtractMethod(first, second);
			}
		}
		
		calcScanner.close();
		return answer;
	}
	
	public String getAnswer(String currentText)
	{
		String answer = "";
		Scanner calcScanner = new Scanner(currentText);
		
		if(calcScanner.hasNextDouble() || calcScanner.hasNextInt())
		{
			if(calcScanner.hasNextDouble() || calcScanner.hasNextInt())
			{
				if(!calcScanner.hasNextDouble() && !calcScanner.hasNextInt())
				{
					answer = calculateOneOperand(currentText) + "";
				}
				else
				{
					answer = calculateMultipleOperands(currentText) + "";
				}
			}
		}
		
		calcScanner.close();
		return answer;
	}
}
