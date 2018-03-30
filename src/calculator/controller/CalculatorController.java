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
	
	public String calculateAnswer(String currentText)
	{
		String answer = "";
		Scanner calcScanner = new Scanner(currentText);
		numbers.clear();
		operands.clear();
		
		while(calcScanner.hasNextDouble() || calcScanner.hasNextInt())
		{
			if(calcScanner.hasNextInt())
			{
				numbers.add((double)(calcScanner.nextInt()));
			}
			else if(calcScanner.hasNextDouble())
			{
				numbers.add(calcScanner.nextDouble());
			}
			if(calcScanner.hasNext())
			{
				operands.add(calcScanner.next());
			}
			
		}
		calcScanner.close();
		
		if(operands.size() >= 2)
		{
			answer = appCalculator.calculateMultipleOperands(numbers, operands) + "";
		}
		else
		{
			answer = appCalculator.calculateOneOperand(currentText, numbers) + "";
		}

		return answer;
	}
}
