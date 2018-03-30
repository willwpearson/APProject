package calculator.model;

import java.util.List;
import java.util.ArrayList;

public class Calculator
{	
	public Calculator()
	{
		
	}
	
	public double addMethod(double first, double second)
	{
		double sum = 0.0;
		
		sum = first + second;
		
		return sum;
	}
	
	public double subtractMethod(double first, double second)
	{
		double difference = 0.0;
		
		difference = first - second;
		
		return difference;
	}
	
	public double multiplyMethod(double first, double second)
	{
		double product = 0.0;
		
		product = first * second;
		
		return product;
	}
	
	public double divideMethod(double first, double second)
	{
		double quotient = 0.0;
		
		quotient = first / second;
		
		return quotient;
	}
	
	public double calculateOneOperand(String currentText, List<Double> numbers)
	{
		double answer = 0.0;
		
		if(currentText.contains("*"))
		{	
			answer = (double) (multiplyMethod(numbers.get(0), numbers.get(1)));
		}
		else if(currentText.contains("÷"))
		{
			answer = (double) (divideMethod(numbers.get(0), numbers.get(1)));
		}
		else if(currentText.contains("+"))
		{
			answer = (double) (addMethod(numbers.get(0), numbers.get(1)));
		}
		else if(currentText.contains("-"))
		{
			answer = (double) (subtractMethod(numbers.get(0), numbers.get(1)));
		}
		
		return answer;
	}
	
	public double calculateMultipleOperands(List<Double> numbers, List<String> operands)
	{
		double answer = 0.0;
		
		while(!operands.isEmpty())
		{
			for(int i = 0; i < operands.size(); i++)
			{
				if(operands.get(i).equals("*"))
				{
					double temp1 = numbers.get(i);
					double temp2 = numbers.get(i + 1);
					numbers.remove(i);
					numbers.add(i, multiplyMethod(temp1, temp2));
					if(numbers.size() != 1)
					{
						numbers.remove(i + 1);
					}
					operands.remove(i);
				}
				else if(operands.get(i).equals("÷"))
				{
					double temp1 = numbers.get(i);
					double temp2 = numbers.get(i + 1);
					numbers.remove(i);
					numbers.add(i, divideMethod(temp1, temp2));
					if(numbers.size() != 1)
					{
						numbers.remove(i + 1);
					}
					operands.remove(i);
				}
			}
			for(int i = 0; i < operands.size(); i++)
			{
				if(operands.get(i).equals("+"))
				{
					double temp1 = numbers.get(i);
					double temp2 = numbers.get(i + 1);
					numbers.remove(i);
					numbers.add(i, addMethod(temp1, temp2));
					if(numbers.size() != 1)
					{
						numbers.remove(i + 1);
					}
					operands.remove(i);
				}
				else if(operands.get(i).equals("-"))
				{
					double temp1 = numbers.get(i);
					double temp2 = numbers.get(i + 1);
					numbers.remove(i);
					numbers.add(i, subtractMethod(temp1, temp2));
					if(numbers.size() != 1)
					{
						numbers.remove(i + 1);
					}
					operands.remove(i);
				}
			}
			if(numbers.size() == 1)
			{
				answer = numbers.get(0);
				numbers.clear();
			}
		}
		return answer;
	}
}
