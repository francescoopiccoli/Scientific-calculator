import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.*;


// sources i used: https://docs.oracle.com/javase/tutorial/, java book "foundations of program design", https://www.html.it/guide/guida-java/

//this class will set up the components,  their layout and their listeners
public class GraphicInterface extends JPanel{

	JPanel mainPanel, SelectFunctionConstraint, enter1Enter2ClearComputeErrorResultShows,  enter1Enter2ClearComputeError, ResultShows, sourceCod;
	JComboBox<String> functionsDropDown;
	JLabel title, select, enter1, enter2, constraints, resultLabel, sourceCodeLabel;
	JTextField number1, number2;
	JTextArea result, sourceCode;
	JButton clearAll, compute, showFile, showCode;
	JScrollPane scrollpane, scrollpane2;
	
	public GraphicInterface() {
		
		//the main panel will contain all the GUI elements
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
	    //this panel contains the title
	    JPanel titlePanel = new JPanel();
	    titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
	    title = new JLabel("Function Calculator");
	    title.setFont(new Font(null, Font.PLAIN, 22));
	    title.setAlignmentX(CENTER_ALIGNMENT);
	    titlePanel.add(Box.createVerticalStrut(10));
		titlePanel.add(title);

		//the next panel will contain the "selectFunction" panel and  the "constr" panel
		SelectFunctionConstraint = new JPanel();

		//the next panel contains the Jcombobox element
		JPanel selectFunction = new JPanel();
		selectFunction.setLayout(new BorderLayout());
		functionsDropDown = new JComboBox<String>();
		functionsDropDown.addActionListener(new selectionListener());

		selectFunction.add(functionsDropDown, BorderLayout.CENTER);
		//all the items in the drop down menu
		functionsDropDown.addItem("Select");
		functionsDropDown.addItem("Sieve of Eratosthenes");
		functionsDropDown.addItem("Greatest common divisor");
		functionsDropDown.addItem("Fibonacci sequence");
		functionsDropDown.addItem("Binomial coefficient");
		functionsDropDown.addItem("Number of prime numbers smaller or equal to n");
		functionsDropDown.addItem("Prime factorization");
		functionsDropDown.addItem("Sigma function");

		//this panel contains the label that tells the user what kind on input is needed
		JPanel constr = new JPanel();
		constraints = new JLabel("Select one of the functions above to see the indications to compute it.");
		constr.add(constraints);
		
		SelectFunctionConstraint.add(selectFunction);
		SelectFunctionConstraint.add(constr);
		SelectFunctionConstraint.setLayout(new BoxLayout(SelectFunctionConstraint, BoxLayout.Y_AXIS));
		SelectFunctionConstraint.add(Box.createVerticalStrut(15));

		// the following panel contains the two subpanel (east and west elements)
		enter1Enter2ClearComputeErrorResultShows = new JPanel();
		enter1Enter2ClearComputeErrorResultShows.setLayout(new BorderLayout());

		//the following panel will contain the two enters for the two numbers, the two textfields and the buttons clear  and compute
		enter1Enter2ClearComputeError = new JPanel();
		enter1Enter2ClearComputeError.setLayout(new BoxLayout(enter1Enter2ClearComputeError, BoxLayout.Y_AXIS));
		
		//the following panel contains both the enter1 label and the number1 textfield to set them on the same line
		JPanel enterAndNumber1 = new JPanel();
		enter1 = new JLabel("Enter number #1");
		number1 = new JTextField(5);

		enterAndNumber1.add(enter1);
		enterAndNumber1.add(number1);
		
		
		//the following panel contains both the enter2 label and the number2 textfield to set them on the same line
		JPanel enterAndNumber2 = new JPanel();
		enter2 = new JLabel("Enter number #2");
		number2 = new JTextField(5);	
		enterAndNumber2.add(enter2);
		enterAndNumber2.add(number2);
		
				
		//the following panel contains the two buttons to set them on the same line
		JPanel clearAndCompute =  new JPanel();
		clearAll = new JButton("Clear all");
		clearAll.addActionListener(new Listener());
		compute = new JButton("Compute");
		compute.addActionListener(new Listener());

		clearAndCompute.add(clearAll);
		clearAndCompute.add(compute);
		
		//the three previous panels are set in another panel (the subpanel on the left) to display them vertically
		enter1Enter2ClearComputeError.add(Box.createVerticalStrut(8));
		enter1Enter2ClearComputeError.add(enterAndNumber1);
		enter1Enter2ClearComputeError.add(enterAndNumber2);
		enter1Enter2ClearComputeError.add(clearAndCompute);


		//the following panel will contain the result label and textarea, the show file and the show code buttons
		ResultShows = new JPanel();
		ResultShows.setLayout(new BoxLayout(ResultShows, BoxLayout.Y_AXIS));

		resultLabel = new JLabel("Result");
		resultLabel.setFont(new Font(null, Font.BOLD, 13));
		resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		result = new JTextArea(3, 1);
		result.setLineWrap(true);
        scrollpane = new JScrollPane(result);
        result.setEditable(false);

        // the two buttons are in a panel so that they are displayed on the same line
        JPanel showButtons = new JPanel();
		showButtons.setLayout(new BoxLayout(showButtons, BoxLayout.X_AXIS));
		showFile = new JButton("Show file");
		showFile.addActionListener(new Listener());

		showCode = new JButton("Show code");
		showCode.addActionListener(new Listener());
		
		showButtons.add(Box.createHorizontalStrut(350));
		showButtons.add(showFile);
		showButtons.add(showCode);
		
		ResultShows.add(resultLabel);
		ResultShows.add(scrollpane);
		ResultShows.add(Box.createVerticalStrut(12));
		ResultShows.add(showButtons);

		//the left/west subpanel and the the right/east subpanel are added in a unique panel
		enter1Enter2ClearComputeErrorResultShows.add(enter1Enter2ClearComputeError, BorderLayout.WEST);
		enter1Enter2ClearComputeErrorResultShows.add(ResultShows);
		
		//This panel contains the source code label and the source code text area
        JPanel sourceCodePandL = new JPanel();
        sourceCodePandL.setLayout(new BoxLayout(sourceCodePandL, BoxLayout.Y_AXIS));
        sourceCode = new JTextArea(17, 63);
        sourceCode.setEditable(false);
        scrollpane2 = new JScrollPane(sourceCode);
        sourceCodeLabel = new JLabel("Source code");
        sourceCodeLabel.setAlignmentX(CENTER_ALIGNMENT);
        sourceCodeLabel.setFont(new Font(null, Font.BOLD, 13));
        
        sourceCodePandL.add(sourceCodeLabel);
        sourceCodePandL.add(scrollpane2);

        //all the elements are added to the main panel to be displayed vertically
		mainPanel.add(titlePanel);
		mainPanel.add(new JSeparator());
		mainPanel.add(SelectFunctionConstraint);
		mainPanel.add(new JSeparator());
		mainPanel.add(enter1Enter2ClearComputeErrorResultShows);
		add(mainPanel);
		mainPanel.add(new JSeparator());
		add(sourceCodePandL);
		
		setPreferredSize(new Dimension(790, 570));
}
	
	//this is the listener of the selection JComboBox, it will set the indications/constraint label and the sourcecode
	//according to the function selected
	private class selectionListener implements ActionListener{

		
		public void actionPerformed(ActionEvent event) {
			
			functionsDropDown = (JComboBox) event.getSource();
			Object selected = functionsDropDown.getSelectedItem();
			
			if ("Sieve of Eratosthenes".equals(selected)) {
            						 
        		result.setText("");
        		constraints.setText("Enter just one integer number n, n>1");
            	number2.setEditable(false);	//disable the second textfield
				number2.setText(""); //delete the text in the second field
				
				sourceCode.setText("int number = Integer.parseInt(w);\n" + 
						"boolean[] primeNumbers = new boolean[number+1];\n" +
						"for(int i = 0; i <= number; i++) \n" + 
						"	primeNumbers[i] = true; \n" + 
						"for(int m = 2; m * m <= number; m++){ \n" + 
						"	if(primeNumbers[m] == true){ \n" + 
						"for(int i = m*2; i <= number; i += m) \n" + 
						"	primeNumbers[i] = false; } \n" + 
						"} \n" + 
						" for(int i = 2; i <= number; i++) \n" + 
						"	{ \n" + 
						"	if(primeNumbers[i] == true) \n" + 
						"	result += i + \" \"; \n" + 
						"} }\n" + 
						"\n");
				
				sourceCode.setVisible(false);//only if showCode button is pressed, the text will be visible

				}
				
            
            if ("Greatest common divisor".equals(selected)) {
            		
            		result.setText("");
            		constraints.setText("Enter two integer numbers n and k, n>0 and k>0");
            		number2.setEditable(true);
            		sourceCode.setVisible(false);
            		sourceCode.setText("public static int gcd (int n, int m) {\n" +
            				"if (m > n) {\n" + 
            				"\n" + 
            				" if ((m % n) == 0) \n" + 
            				"	return n;\n" + 
            				" else\n" + 
            				"	 return gcd(n, m % n);\n" + 
            				"}\n" + 
            				"else {\n" + 
            				"	if ((n % m) == 0) \n" + 
            				"	   return m;\n" + 
            				"	else\n" + 
            				"	   return gcd(m, n % m);\n" + 
            				"	        }\n" + 
            				"	    }");
            }
            
            if ("Fibonacci sequence".equals(selected)) {
            	
        			result.setText("");
            		constraints.setText("Enter just one integer number n, n>=0");
            		number2.setEditable(false);
            		number2.setText("");
            		sourceCode.setVisible(false);
            		sourceCode.setText("public static int fibonacciSequence(int n)  {\n" + 
            				" // f(0) = 0\n" + 
            				" if(n == 0)\n" + 
            				"	 return 0;\n" + 
            				" // f(1) = 1\n" + 
            				"  else if(n == 1)\n" + 
            				"	 return 1;\n" + 
            				"  else\n" + 
            				"	//f(n) n different from 0 and 1, it repeats the function of (n-1) and (n-2)\n" + 
            				"   //till when n = 0 or n = 1\n" + 
            				"   //the result is given by the sum of all those values\n" + 

            				"	  return fibonacciSequence(n - 1) + fibonacciSequence(n - 2);\n" + 
            				"	}");

            }
            
            if ("Binomial coefficient".equals(selected)) {
        			
            		result.setText("");
            		constraints.setText("Enter two integer numbers n and k, n >= 0 and n>=k>=0");
            		number2.setEditable(true);
            		sourceCode.setVisible(false);
            		sourceCode.setText("double n = Integer.parseInt(one);\n" + 
            				"double k = Integer.parseInt(two);\n" + 
            				"\n" + 
            				"result = 1;\n" + 
            				"\n" + 
            				"for(int i = 1; i <= k; i++) {\n" + 
            				"\n" + 
            				" result *= ((n + 1 - i)/i);\n" + 
            				"}");
            }
            
            if ("Number of prime numbers smaller or equal to n".equals(selected)) {
        		
            	result.setText("");
				constraints.setText("Enter just one integer number n, n>0");
            	number2.setEditable(false);
				number2.setText("");
				sourceCode.setVisible(false);
				sourceCode.setText("int number = Integer.parseInt(w);\n" + 
						"boolean[] primeNumbers = new boolean[number+1];" +
						"for(int i=0; i< number; i++) \n" + 
						"	primeNumbers[i] = true; \n" + 
						"for(int m = 2; m * m <= number; m++){ \n" + 
						"	if(primeNumbers[m] == true){ \n" + 
						"for(int i = m*2; i <= number; i += m) \n" + 
						"	primeNumbers[i] = false; }" + 
						"} \n" + 
						" for(int i = 1; i <= number; i++) \n" + 
						"	{ \n" + 
						"	if(primeNumbers[i] == true) \n" + 
						"	result += i + \" \"; \n" + 
						"} }\n" + 
						"public String toString() {\n" + 
						"return result;\n "
						+ "String[] array = result.split(\" \");\n" + 
						"   numberOfPrimeNumber = array.length - 1;");
           }
            
            if ("Prime factorization".equals(selected)) {
				
        		result.setText("");
            	constraints.setText("Enter just one integer number n,  n>1");
            	number2.setEditable(false);
				number2.setText("");
				sourceCode.setVisible(false);
				sourceCode.setText("numb  = Integer.parseInt(number);\n" + 
						"\n" + 
						"result = \"\";" + 
						"		\n" + 
						" while (numb % 2 == 0){\n" + 
						"        \n" + 
						"  result += 2 + \" \"; \n" + 
						"  numb = numb / 2; \n" + 
						" } \n" + 
						"  for (int j = 3; j <= numb; j += 2)  { \n" + 
						"    while (numb % j == 0) { \n" + 
						"     result += j + \" \"; \n" + 
						"     numb = numb / j; \n" + 
						"    } \n" + 
						"   } \n" + 	 
						" if (numb > 2) \n" + 
						"  result  +=  numb; ");
            }
            
            if ("Sigma function".equals(selected)) {		
            	
        		result.setText("");
            	constraints.setText("Enter two integer numbers n and x, n>1 and x>=0");
            	number2.setEditable(true);
            	sourceCode.setVisible(false);
            	sourceCode.setText(" for(int i = 1; i <= n; i++) {\n" + 
            			" //if the remainder of the division n%i = 0\n" + 
            			" //it means that i is a divisor of n\n" + 
            			"   if(n % i == 0) {\n" + 
            			"	//the result is given by the sum of all divisors raised to the power of m\n" + 
            			"	 result += Math.pow(i, m);\n" + 
            			"		}");
            }
		}	
	}
	
	
	//This is the listener of the four buttons (clearAll, Compute, showFile, showCode)
	private class Listener implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			
			//this arraylist will contain a string for each function performed, it will be printed as a string in the file
			ArrayList<String> file = new ArrayList<String>();
			
			//clear the text of the input fields
			if(event.getSource() == clearAll) {
				number1.setText("");
				number2.setText("");
			}
			
			
			try {
				
			//Instantiation of a file object, it will create the file
				File fi = new File ("ProjectFile");
				FileWriter fw = new FileWriter(fi, true);
				PrintWriter pw = new PrintWriter(fw, true);			
		
			//every time the program is closed, the file will be deleted
				fi.deleteOnExit();

			//the next if will work with try and catch, to create an object (when compute button is pressed) corresponding to the selected function
			//only if the input(s) is/are valid, otherwise(catch) will display an error and the object wont be created
			if(event.getSource() == compute) {
				
				//Function1 
				if("Sieve of Eratosthenes".equals((String)functionsDropDown.getSelectedItem())) {
					
					try {
						 Integer.parseInt(number1.getText());
						 
						 if(Integer.parseInt(number1.getText()) > 1) {
								Function1 function1 = new Function1(number1.getText());
								result.setText(function1.toString());
								file.add("Function1 performed(Sieve of Eratosthenes): Input: " + number1.getText() + "; Output: " + result.getText());
								
						 }
						 
					   if(Integer.parseInt(number1.getText()) <= 1){
						   JOptionPane.showMessageDialog(null, "Error: make sure you entered an integer greater than one");
				       }
				      
					}
			      
					catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Error: make sure you entered an integer number");
						}
				}
				
				//Function2 
				if("Greatest common divisor".equals((String)functionsDropDown.getSelectedItem())) {
					
					try {
						 Integer.parseInt(number1.getText());
						 Integer.parseInt(number2.getText());
						 
						 if(Integer.parseInt(number1.getText()) <= 0){
							   JOptionPane.showMessageDialog(null, "Error: make sure that the first number entered is greater than zero");
						 }
						 if(Integer.parseInt(number2.getText()) <= 0){
							   JOptionPane.showMessageDialog(null, "Error: make sure that the second number entered is greater than zero");

						   }
						 if(Integer.parseInt(number1.getText()) > 0 && Integer.parseInt(number2.getText()) > 0) {
							 
							 	Function2 function2 = new Function2(number1.getText(), number2.getText()); 
								result.setText("" + Function2.gcd(Integer.parseInt(number1.getText()), Integer.parseInt(number2.getText()))); 
								file.add("Function2 performed(GCD): Input: " + number1.getText() + ", " + number2.getText() + ";  Output: " + result.getText());
							 
						 }
						 
					}
					catch (Exception ex) {
						try {
							 Integer.parseInt(number1.getText());
							 if(Integer.parseInt(number1.getText()) <= 0){
								   JOptionPane.showMessageDialog(null, "Error: make sure that the first number entered is greater than zero");

							   }
						}
							catch (Exception ex1) {
						JOptionPane.showMessageDialog(null, "Error: make sure that the first number entered is an integer number");
						   }
						
						try {
							 Integer.parseInt(number2.getText());
							 if(Integer.parseInt(number2.getText()) <= 0){
								   JOptionPane.showMessageDialog(null, "Error: make sure that the second number entered is greater than zero");
							   }

					}
				     
						catch (Exception ex2) {
							JOptionPane.showMessageDialog(null, "Error: make sure that the second number entered is an integer number");
						}
					
					}
				}
				
				
				//Function3
				if("Fibonacci sequence".equals((String)functionsDropDown.getSelectedItem())) {
					
					try {
						 Integer.parseInt(number1.getText());
						 
						 if(Integer.parseInt(number1.getText()) >= 0) {
							 Function3 function3 = new Function3(number1.getText()); 
							 result.setText("" + Function3.fibonacciSequence(Integer.parseInt(number1.getText())));
							 file.add("Function3 performed(Fibonacci sequence): Input: " + number1.getText() + "; Output: " + result.getText());
					}
				
					if(Integer.parseInt(number1.getText()) < 0){
						   JOptionPane.showMessageDialog(null, "Error: make sure you entered an integer greater than or equal to zero");
				       }
					}
			      
					catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Error: make sure you entered an integer number");
						}
				}
				
				//Function4
				if("Binomial coefficient".equals((String)functionsDropDown.getSelectedItem())) {
					
					try {
						 Integer.parseInt(number1.getText());
						 Integer.parseInt(number2.getText());
						 
						 	if(Integer.parseInt(number1.getText()) >= 0 && Integer.parseInt(number2.getText()) >= 0 && Integer.parseInt(number1.getText()) >= Integer.parseInt(number2.getText())) {
							 
							 	Function4 function4 = new Function4(number1.getText(), number2.getText()); 
								result.setText(function4.toString());
								file.add("Function4 performed(Binomial Coefficient): Input: " + number1.getText() + ", " + number2.getText() + ";  Output: " + result.getText() );
						 }
						 	
						 	if(Integer.parseInt(number1.getText()) < 0){
						 		JOptionPane.showMessageDialog(null, "Error: make sure that the first number entered is greater than or equal to zero");

						 	}
						 	if(Integer.parseInt(number2.getText()) < 0){
						 		JOptionPane.showMessageDialog(null, "Error: make sure that the second number entered is greater than or equal to zero");
						 	}
						 
						 	if(Integer.parseInt(number1.getText()) < Integer.parseInt(number2.getText())) {
						 		JOptionPane.showMessageDialog(null, "Error: make sure that that the second number is smaller than or equal to the first one");
						 	}
					}
			      
					catch (Exception ex) {
						try {
							 Integer.parseInt(number1.getText());
							 
							 if(Integer.parseInt(number1.getText()) < 0){
								   JOptionPane.showMessageDialog(null, "Error: make sure that the first number entered is greater than or equal to zero");

							   }
						}
							catch (Exception ex1) {
							 JOptionPane.showMessageDialog(null, "Error: make sure that the first number entered is an integer number");
						   }
						
						try {
							 Integer.parseInt(number2.getText());
							 
							 if(Integer.parseInt(number2.getText()) < 0){
								   JOptionPane.showMessageDialog(null, "Error: make sure that the second number entered is greater than or equal to zero");
							   }
					}
				     
						catch (Exception ex2) {
							JOptionPane.showMessageDialog(null, "Error: make sure that the second number entered is an integer number");
						}
					}
				}
				
				//Function5
				if("Number of prime numbers smaller or equal to n".equals((String)functionsDropDown.getSelectedItem())) {
					
					try {
						
						 Integer.parseInt(number1.getText());
						 
						 if(Integer.parseInt(number1.getText()) > 0) {
							 Function5 function5 = new Function5(number1.getText()); 
							 result.setText(function5.toString());
							 file.add("Function5 performed(Number of prime numbers...): Input: " + number1.getText() + "; Output: " + result.getText());
						 }
						 
						 if(Integer.parseInt(number1.getText()) <= 0){
							 JOptionPane.showMessageDialog(null, "Error: make sure you entered an integer greater than zero");
				       }
					}
			      
					catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Error: make sure you entered an integer number");
			    	}
				}
				
				//Function6
				if("Prime factorization".equals((String)functionsDropDown.getSelectedItem())) {
					
					try {
						 Integer.parseInt(number1.getText());
						 
						 if(Integer.parseInt(number1.getText()) > 1) {
							 Function6 function6 = new Function6(number1.getText());  //se creo una funzione 6 va al catch
							 result.setText(function6.toString());
							 file.add("Function6 performed(Prime factorization): Input: " + number1.getText() + "; Output: " + result.getText());
						 }
						 if(Integer.parseInt(number1.getText()) <= 1){
							 JOptionPane.showMessageDialog(null, "Error: make sure you entered an integer greater than one");
						 }
					}
			      
					catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Error: make sure you entered an integer number");
			    	}
				}
				
				//Function7
				if("Sigma function".equals((String)functionsDropDown.getSelectedItem())) {
					try {
						 Integer.parseInt(number1.getText());
						 Integer.parseInt(number2.getText());
						 
						 	if(Integer.parseInt(number1.getText()) > 1 && Integer.parseInt(number2.getText()) >= 0) {
							 
							 	Function7 function7 = new Function7(number1.getText(), number2.getText()); 
								result.setText(function7.toString());
								file.add("Function7 performed(Sigma): Input: "  + number1.getText() + ", " + number2.getText() + ";  Output: " + result.getText());

						 	}
						 
						 	if(Integer.parseInt(number1.getText()) <= 1){
						 		JOptionPane.showMessageDialog(null, "Error: make sure that the first number entered is greater than one");

						 	}
						 	if(Integer.parseInt(number2.getText()) < 0){
						 		JOptionPane.showMessageDialog(null, "Error: make sure that the second number entered is greater than or equal to zero");
						 	}
					}
			      
					catch (Exception ex) {
						try {
							 Integer.parseInt(number1.getText());
							  if(Integer.parseInt(number1.getText()) <= 1){
								   JOptionPane.showMessageDialog(null, "Error: make sure that the first number entered is greater than one");

							   }
							  }
							catch (Exception ex1) {
						JOptionPane.showMessageDialog(null, "Error: make sure that the first number entered is an integer number");
						   }
						
						try {
							 Integer.parseInt(number2.getText());
							 if(Integer.parseInt(number2.getText()) < 0){
								   JOptionPane.showMessageDialog(null, "Error: make sure that the second number entered is greater than or equal to zero");
						}
					}
						catch (Exception ex2) {
							JOptionPane.showMessageDialog(null, "Error: make sure that the second number entered is an integer number");
						}
					}	
				}
				
				//the content of the arraylist is set in a string (through the use of a for) in order to display it more aptly
				String fileString = "";
				for(int i = 0; i < file.size(); i++) {
					fileString += "" + file.get(i) + "\n\n";
				}
				
				pw.write(fileString);
			}
			
				pw.close();
			}
			//in case the file is not created/found
			catch(IOException e){
				System.out.println("error");
			}
			
			//showFile button will open a new frame containing the file
			if(event.getSource() == showFile) {
				createFrame();
			}
			//the already set text of the sourceCode textarea will be visible once showCode button is pressed
			if(event.getSource() == showCode) {
				sourceCode.setVisible(true);
			}	
			
	    }
	}
	
	//here i created the frame containing the file
	private static void createFrame() {

			JFrame frame2 = new JFrame("Log file");
        	frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame2.setPreferredSize(new Dimension(705, 250));
			JTextArea fileArea = new JTextArea();
			fileArea.setLineWrap(true);
	        JScrollPane scrollpaneFile = new JScrollPane(fileArea);
	        fileArea.setEditable(false);
	        
	        try {
	        	
	        FileReader fr = new FileReader("ProjectFile");
	        BufferedReader br = new BufferedReader(fr);
	        String str;
	        
	        while((str = br.readLine()) != null) {
	        	fileArea.append(str + "\n");
	        	}
	        }
	        catch(IOException ex){
	        	System.out.println("File not found");
	        	
	        }
	        frame2.add(scrollpaneFile);


        try 
        
        {
        	frame2.getContentPane();
   			frame2.pack();
   			frame2.setVisible(true);		
        } 
        
        catch (Exception e) {
           e.printStackTrace();
        }
	}
}


