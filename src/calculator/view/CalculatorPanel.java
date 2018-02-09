package calculator.view;

import javax.swing.JPanel;
import calculator.controller.CalculatorController;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class CalculatorPanel extends JPanel
{
	private CalculatorController appController;
	private JButton zeroButton;
	private JButton oneButton;
	private JButton twoButton;
	private JButton threeButton;
	private JButton fourButton;
	private JButton fiveButton;
	private JButton sixButton;
	private JButton sevenButton;
	private JButton eightButton;
	private JButton nineButton;
	private JButton addButton;
	private JButton subtractButton;
	private JButton multiplyButton;
	private JButton divideButton;
	private JButton equalsButton;
	private JButton clearButton;
	private JTextArea numbersArea;
	private SpringLayout appLayout;
	
	public CalculatorPanel(CalculatorController appController)
	{
		super();
		this.appController = appController;
		appLayout = new SpringLayout();
		
		//GUI data members
		zeroButton = new JButton("0");
		oneButton = new JButton("1");
		twoButton = new JButton("2");
		threeButton = new JButton("3");
		fourButton = new JButton("4");
		fiveButton = new JButton("5");
		sixButton = new JButton("6");
		sevenButton = new JButton("7");
		eightButton = new JButton("8");
		nineButton = new JButton("9");
		addButton = new JButton("+");
		subtractButton = new JButton("-");
		multiplyButton = new JButton("*");
		divideButton = new JButton("÷");
		equalsButton = new JButton("=");
		clearButton = new JButton("CE");
		numbersArea = new JTextArea();
		
		setupPanel();
//		setupLayout();
//		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.gray);
		this.setLayout(appLayout);
		this.add(zeroButton);
		this.add(oneButton);
		this.add(twoButton);
		this.add(threeButton);
		this.add(fourButton);
		this.add(fiveButton);
		this.add(sixButton);
		this.add(sevenButton);
		this.add(eightButton);
		this.add(nineButton);
		this.add(addButton);
		this.add(subtractButton);
		this.add(multiplyButton);
		this.add(divideButton);
		this.add(equalsButton);
		this.add(clearButton);
		this.add(numbersArea);
	}
}
