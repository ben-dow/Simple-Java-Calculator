
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public abstract class calculator implements ActionListener {
	static String answer;
	static String[] operations = {"+","x","/","-"};
	static int currentop;
	static String finalresult;
	static int numcalcs;

	
	public static double Addition(Double num1, Double num2){ //Addition Method
		double addend1 = num1;
		double addend2 = num2;
		return addend1+addend2;
		
	}
	
	public static double Multiplication(Double num1, Double num2){// Multiplication Method
		double factor1 = num1;
		double factor2 = num2;
		return factor1*factor2;
	}
	
	public static String Division(Double num1, Double num2){// Division Method
		double dividend = num1;
		double divisor = num2;
		String divisionresult;
		if (divisor == 0){
			 divisionresult = "Error: Divide by 0";
		}
		else {
			divisionresult = Double.toString(dividend / divisor);
		}
		return divisionresult;
	}
	
	public static double Subtraction(Double num1, Double num2){// Subtraction Method
		double minuend = num1;
		double subtrahend = num2;
		return minuend - subtrahend;
	}
	public static String Calculations(JTextField num1, JTextField num2, JLabel numcalc){	
			numcalcs++;
			numcalc.setText(Integer.toString(numcalcs));
			
			String text1 = num1.getText();
			String text2 = num2.getText();

			
			double finalnum1 = Double.parseDouble(text1);
			double finalnum2 = Double.parseDouble(text2);
			if (currentop == 0){//Does Addition
				 finalresult = Double.toString(Addition(finalnum1, finalnum2));
			}
			else if (currentop == 1){//Does Multiplication
				 finalresult = Double.toString(Multiplication(finalnum1, finalnum2));
			}
			else if (currentop == 2){// Does Division
				 finalresult = Division(finalnum1, finalnum2);
			}
			else if (currentop == 3){// Does Subtraction
				 finalresult = Double.toString(Subtraction(finalnum1, finalnum2));
			}
			
			return finalresult;
		}
	
	public static boolean checkNumbers(JTextField num1, JTextField num2){
		
		
		if (num1.getText().equals("") || num2.getText().equals("")){
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public static void Window(){// Creates window and executes methods for calculator
		JFrame frame = new JFrame("Basic Calculator");// Calls Class JFrame for new Window.
		
		
		//First Number
		final JTextField num1 = new JTextField("");
		num1.setEditable(true);
		
		//Second Number
		final JTextField num2 = new JTextField("");
		num2.setEditable(true);
		
		
		JLabel numcalcslabel = new JLabel("Number of Calculations Made: ");
		final JLabel numcalc = new JLabel();
		
		
		final JComboBox<?> operators = new JComboBox<Object>(operations);
		operators.setSelectedIndex(0);
		operators.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				currentop = operators.getSelectedIndex();
				
			}
		});
		
		JLabel equals = new JLabel("="); //Equals Symbol
		
		final JTextField result = new JTextField(answer); //Displays Answer
		result.setEditable(false);
		
		//Preforms Calculation
		JButton calculate = new JButton("Calculate");
		calculate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (checkNumbers(num1, num2) == false){ // Checks for Empty Values
					result.setText("Error: Missing Number(s)"); 
				}
				else{
					result.setText(Calculations(num1, num2, numcalc));
				}
			}
		});
		
		
		//Layout
		GridLayout layout = new GridLayout(6,5);
		frame.setLayout(layout);
		
		
		
		
		//Add Components to Window
		frame.add(num1);
		frame.add(new JPanel());
		frame.add(operators);
		frame.add(new JPanel());
		frame.add(num2);
		frame.add(equals);
		frame.add(result);
		frame.add(calculate);
		frame.add(numcalcslabel);
		frame.add(numcalc);

		frame.getRootPane().setDefaultButton(calculate); // Allow Enter to Work
		
		//Make Window Visible
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String args[]){
		Window();
	}



}
