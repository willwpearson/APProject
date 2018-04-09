package calculator.view;

import calculator.controller.CalculatorController;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

import java.util.List;
import java.util.ArrayList;

public class CalculatorPanel extends JPanel
{
	private CalculatorController appController;
	private List<Double> answerList;
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
	private JButton decimalButton;
	private JButton equalsButton;
	private JButton clearButton;
	private JTextArea numbersArea;
	private JTextArea answersArea;
	private JScrollPane calculatorScroll;
	private SpringLayout appLayout;
	private boolean hasAnswered;
	
	public CalculatorPanel(CalculatorController appController)
	{
		super();
		this.appController = appController;
		answerList = new ArrayList<Double>();
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
		decimalButton = new JButton(".");
		equalsButton = new JButton("=");
		clearButton = new JButton("CE");
		numbersArea = new JTextArea();
		answersArea = new JTextArea();
		calculatorScroll = new JScrollPane();
		answersArea.setBackground(Color.LIGHT_GRAY);
		numbersArea.setBackground(Color.LIGHT_GRAY);
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupScrollPane()
	{
		calculatorScroll.setViewportView(answersArea);
		calculatorScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		calculatorScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		answersArea.setLineWrap(true);
		answersArea.setWrapStyleWord(true);
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
		this.add(decimalButton);
		this.add(equalsButton);
		this.add(clearButton);
		this.add(numbersArea);
		this.add(calculatorScroll);
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, oneButton, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, oneButton, 0, SpringLayout.NORTH, zeroButton);
		appLayout.putConstraint(SpringLayout.WEST, zeroButton, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, zeroButton, 0, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, twoButton, 0, SpringLayout.EAST, oneButton);
		appLayout.putConstraint(SpringLayout.WEST, threeButton, 0, SpringLayout.EAST, twoButton);
		appLayout.putConstraint(SpringLayout.SOUTH, threeButton, 0, SpringLayout.SOUTH, twoButton);
		appLayout.putConstraint(SpringLayout.SOUTH, twoButton, 0, SpringLayout.SOUTH, oneButton);
		appLayout.putConstraint(SpringLayout.WEST, fourButton, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, fourButton, 0, SpringLayout.NORTH, oneButton);
		appLayout.putConstraint(SpringLayout.WEST, fiveButton, 0, SpringLayout.EAST, fourButton);
		appLayout.putConstraint(SpringLayout.SOUTH, fiveButton, 0, SpringLayout.SOUTH, fourButton);
		appLayout.putConstraint(SpringLayout.WEST, sixButton, 0, SpringLayout.EAST, fiveButton);
		appLayout.putConstraint(SpringLayout.SOUTH, sixButton, 0, SpringLayout.SOUTH, fiveButton);
		appLayout.putConstraint(SpringLayout.WEST, nineButton, 0, SpringLayout.EAST, eightButton);
		appLayout.putConstraint(SpringLayout.SOUTH, nineButton, 0, SpringLayout.SOUTH, sevenButton);
		appLayout.putConstraint(SpringLayout.WEST, eightButton, 0, SpringLayout.EAST, sevenButton);
		appLayout.putConstraint(SpringLayout.SOUTH, eightButton, 0, SpringLayout.SOUTH, sevenButton);
		appLayout.putConstraint(SpringLayout.WEST, sevenButton, 0, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, sevenButton, 0, SpringLayout.NORTH, fourButton);
		appLayout.putConstraint(SpringLayout.WEST, clearButton, 0, SpringLayout.WEST, nineButton);
		appLayout.putConstraint(SpringLayout.SOUTH, clearButton, 0, SpringLayout.NORTH, nineButton);
		appLayout.putConstraint(SpringLayout.WEST, divideButton, 0, SpringLayout.WEST, equalsButton);
		appLayout.putConstraint(SpringLayout.WEST, multiplyButton, 0, SpringLayout.WEST, equalsButton);
		appLayout.putConstraint(SpringLayout.WEST, subtractButton, 0, SpringLayout.WEST, equalsButton);
		appLayout.putConstraint(SpringLayout.WEST, addButton, 0, SpringLayout.WEST, equalsButton);
		appLayout.putConstraint(SpringLayout.SOUTH, addButton, 0, SpringLayout.NORTH, equalsButton);
		appLayout.putConstraint(SpringLayout.WEST, equalsButton, 0, SpringLayout.EAST, threeButton);
		appLayout.putConstraint(SpringLayout.SOUTH, equalsButton, 0, SpringLayout.SOUTH, zeroButton);
		appLayout.putConstraint(SpringLayout.SOUTH, divideButton, 0, SpringLayout.NORTH, multiplyButton);
		appLayout.putConstraint(SpringLayout.SOUTH, multiplyButton, 0, SpringLayout.NORTH, subtractButton);
		appLayout.putConstraint(SpringLayout.SOUTH, subtractButton, 0, SpringLayout.NORTH, addButton);
		appLayout.putConstraint(SpringLayout.NORTH, numbersArea, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, numbersArea, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, numbersArea, 0, SpringLayout.NORTH, clearButton);
		appLayout.putConstraint(SpringLayout.EAST, numbersArea, 0, SpringLayout.EAST, divideButton);	
		appLayout.putConstraint(SpringLayout.NORTH, decimalButton, 0, SpringLayout.NORTH, zeroButton);
		appLayout.putConstraint(SpringLayout.WEST, decimalButton, 0, SpringLayout.WEST, twoButton);
		appLayout.putConstraint(SpringLayout.SOUTH, decimalButton, 0, SpringLayout.SOUTH, zeroButton);
		appLayout.putConstraint(SpringLayout.EAST, decimalButton, 0, SpringLayout.EAST, twoButton);
		appLayout.putConstraint(SpringLayout.NORTH, answersArea, 0, SpringLayout.NORTH, numbersArea);
		appLayout.putConstraint(SpringLayout.WEST, answersArea, 25, SpringLayout.EAST, numbersArea);
		appLayout.putConstraint(SpringLayout.SOUTH, answersArea, -25, SpringLayout.SOUTH, equalsButton);
		appLayout.putConstraint(SpringLayout.EAST, answersArea, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, calculatorScroll, 0, SpringLayout.NORTH, numbersArea);
		appLayout.putConstraint(SpringLayout.WEST, calculatorScroll, 25, SpringLayout.EAST, numbersArea);
		appLayout.putConstraint(SpringLayout.SOUTH, calculatorScroll, -25, SpringLayout.SOUTH, equalsButton);
	}
	
	private void setupListeners()
	{
		//Number button display listeners
		zeroButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(hasAnswered == true)
				{
					numbersArea.setText("");
					hasAnswered = false;
				}
				String currentText = numbersArea.getText();
				numbersArea.setText(currentText + "0");	
			}
		});
		
		oneButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(hasAnswered == true)
				{
					numbersArea.setText("");
					hasAnswered = false;
				}
				String currentText = numbersArea.getText();
				numbersArea.setText(currentText + "1");	
			}
		});
		
		twoButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(hasAnswered == true)
				{
					numbersArea.setText("");
					hasAnswered = false;
				}
				String currentText = numbersArea.getText();
				numbersArea.setText(currentText + "2");
			}
		});
		
		threeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(hasAnswered == true)
				{
					numbersArea.setText("");
					hasAnswered = false;
				}
				String currentText = numbersArea.getText();
				numbersArea.setText(currentText + "3");
			}
		});
		
		fourButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(hasAnswered == true)
				{
					numbersArea.setText("");
					hasAnswered = false;
				}
				String currentText = numbersArea.getText();
				numbersArea.setText(currentText + "4");
			}
		});
		
		fiveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(hasAnswered == true)
				{
					numbersArea.setText("");
					hasAnswered = false;
				}
				String currentText = numbersArea.getText();
				numbersArea.setText(currentText + "5");
			}
		});
		
		sixButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(hasAnswered == true)
				{
					numbersArea.setText("");
					hasAnswered = false;
				}
				String currentText = numbersArea.getText();
				numbersArea.setText(currentText + "6");
			}
		});
		
		sevenButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(hasAnswered == true)
				{
					numbersArea.setText("");
					hasAnswered = false;
				}
				String currentText = numbersArea.getText();
				numbersArea.setText(currentText + "7");
			}
		});
		
		eightButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(hasAnswered == true)
				{
					numbersArea.setText("");
					hasAnswered = false;
				}
				String currentText = numbersArea.getText();
				numbersArea.setText(currentText + "8");
			}
		});
		
		nineButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(hasAnswered == true)
				{
					numbersArea.setText("");
					hasAnswered = false;
				}
				String currentText = numbersArea.getText();
				numbersArea.setText(currentText + "9");
			}
		});
		
		//Operation Display Listeners
		
		addButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String currentText = numbersArea.getText();
				numbersArea.setText(currentText + " + ");
			}
		});
		
		subtractButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String currentText = numbersArea.getText();
				numbersArea.setText(currentText + " - ");
			}
		});
		
		multiplyButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String currentText = numbersArea.getText();
				numbersArea.setText(currentText + " * ");
			}
		});
		
		divideButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String currentText = numbersArea.getText();
				numbersArea.setText(currentText + " ÷ ");
			}
		});
		
		decimalButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String currentText = numbersArea.getText();
				numbersArea.setText(currentText + ".");
			}
		});
		
		//Calculation Listeners
		
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				numbersArea.setText("");
			}
		});
		
		equalsButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String currentText = numbersArea.getText();
				hasAnswered = true;
				numbersArea.setText(appController.calculateAnswer(currentText));
				answerList.add(Double.parseDouble(appController.calculateAnswer(currentText)));
				answersArea.setText(answerList.toString());
			}
		});
	}
}
