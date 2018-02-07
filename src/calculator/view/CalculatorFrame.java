package calculator.view;

import calculator.controller.CalculatorController;
import javax.swing.JFrame;

public class CalculatorFrame
{
	private CalculatorController appController;
	private CalculatorPanel appPanel;
	
	public CalculatorFrame(CalculatorController appController)
	{
		super();
		this.appController = appController;
		appPanel = new CalculatorPanel(appController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("Calculator");
		this.setResizeable(false);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public CalculatorController getAppController()
	{
		return appController;
	}
}
