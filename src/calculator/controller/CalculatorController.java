package calculator.controller;

import calculator.model.Calculator;
import calculator.view.CalculatorFrame;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CalculatorController
{
	private CalculatorFrame appFrame;
	private Calculator appCalculator;
	private List<Double> numbers;
	private List<String> operands;
	
	public CalculatorController()
	{
		appFrame = new CalculatorFrame(this);
		appCalculator = new Calculator();
		numbers = new ArrayList<Double>();
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
			//startAbstraction
			first = calcScanner.nextDouble();
			//endAbstraction
			second = Double.parseDouble(currentText.substring(currentText.indexOf(" ", currentText.indexOf("÷"))).trim());
			answer = appCalculator.divideMethod(first, second);
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
	
	public double calculateMultipleOperands(List<Double> numbers)
	{
		double answer = 0.0;
		List<Double> removed = new ArrayList<Double>();
		
		while(!numbers.isEmpty())
		{
			for(int i = 0; i < operands.size(); i++)
			{
				if(operands.get(i) == "*")
				{
					appCalculator.multiplyMethod(numbers.get(i), numbers.get(i + 1));
					numbers.remove(i);
					numbers.remove(i + 1);
					numbers.add(i, appCalculator.multiplyMethod(numbers.get(i), numbers.get(i + 1)));
				}
				else if(operands.get(i) == "÷")
				{
					
				}
			}
		}
		return answer;
	}
	
	public String getAnswer(String currentText)
	{
		String answer = "";
		Scanner calcScanner = new Scanner(currentText);
		numbers.clear();
		operands.clear();
		
		while(calcScanner.hasNextDouble())
		{
			numbers.add(calcScanner.nextDouble());
		}
		while(calcScanner.hasNext())
		{
			operands.add(calcScanner.next());
		}
		
		if(numbers.size() > 2)
		{
			answer = calculateMultipleOperands(numbers) + "";
		}
		else
		{
			answer = calculateOneOperand(currentText) + "";
		}

		calcScanner.close();
		return answer;
	}
}
