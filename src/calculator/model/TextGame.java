package calculator.model;

public class TextGame
{
	public TextGame()
	{
		
	}
	
	public String mainGame()
	{
		String mainText = "";
		
		mainText += "\n" + introduction();
		
		return mainText;
	}
	
	public String introduction()
	{
		String hello = "Hello?? \n Anyone There?";
		
		return hello;
	}
}
