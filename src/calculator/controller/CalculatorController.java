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
		operands = new ArrayList<String>();
	}
	
	public void start()
	{
		
	}
	
	public double calculateOneOperand(String currentText)
	{
		double answer = 0.0;
		
		if(currentText.contains("*"))
		{	
			answer = (double) (appCalculator.multiplyMethod(numbers.get(0), numbers.get(1)));
		}
		else if(currentText.contains("÷"))
		{
			answer = (double) (appCalculator.divideMethod(numbers.get(0), numbers.get(1)));
		}
		else if(currentText.contains("+"))
		{
			answer = (double) (appCalculator.addMethod(numbers.get(0), numbers.get(1)));
		}
		else if(currentText.contains("-"))
		{
			answer = (double) (appCalculator.subtractMethod(numbers.get(0), numbers.get(1)));
		}
		
		return answer;
	}
	
	public double calculateMultipleOperands(List<Double> numbers)
	{
		double answer = 0.0;
		
		while(!numbers.isEmpty())
		{
			for(int i = 0; i < operands.size(); i++)
			{
				if(operands.get(i).equals("*"))
				{
					double temp1 = numbers.get(i);
					double temp2 = numbers.get(i + 1);
					numbers.remove(i);
					numbers.remove(i + 1);
					numbers.add(i, appCalculator.multiplyMethod(temp1, temp2));
				}
				else if(operands.get(i).equals("÷"))
				{
					double temp1 = numbers.get(i);
					double temp2 = numbers.get(i + 1);
					numbers.remove(i);
					numbers.remove(i + 1);
					numbers.add(i, appCalculator.divideMethod(temp1, temp2));
				}
			}
			for(int i = 0; i < operands.size(); i++)
			{
				if(operands.get(i).equals("+"))
				{
					double temp1 = numbers.get(i);
					double temp2 = numbers.get(i + 1);
					numbers.remove(i);
					numbers.remove(i + 1);
					numbers.add(i, appCalculator.addMethod(temp1, temp2));
				}
				else if(operands.get(i).equals("-"))
				{
					double temp1 = numbers.get(i);
					double temp2 = numbers.get(i + 1);
					numbers.remove(i);
					numbers.remove(i + 1);
					numbers.add(i, appCalculator.subtractMethod(temp1, temp2));
				}
			}
			if(numbers.size() == 1)
			{
				answer = numbers.get(0);
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
			while(calcScanner.hasNext())
			{
				operands.add(calcScanner.next());
			}
		}
		calcScanner.close();
		
		if(operands.size() >= 2)
		{
			answer = calculateMultipleOperands(numbers) + "";
		}
		else if(operands.size() == 1)
		{
			answer = calculateOneOperand(currentText) + "";
		}

		return answer;
	}
}
