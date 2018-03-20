package calculator.model;

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
}
