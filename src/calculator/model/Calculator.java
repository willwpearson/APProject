package calculator.model;

public class Calculator
{	
	public Calculator()
	{
		
	}
	
	public int addMethod(int first, int second)
	{
		int sum = 0;
		
		sum = first + second;
		
		return sum;
	}
	
	public int subtractMethod(int first, int second)
	{
		int difference = 0;
		
		difference = first - second;
		
		return difference;
	}
	
	public int mulitplyMethod(int first, int second)
	{
		int product = 0;
		
		product = first * second;
		
		return product;
	}
	
	public int divideMethod(int first, int second)
	{
		int quotient = 0;
		
		quotient = first / second;
		
		return quotient;
	}
	
	public void clearMethod()
	{
		
	}
}
