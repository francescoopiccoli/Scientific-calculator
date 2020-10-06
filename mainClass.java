import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class mainClass{
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create the menu
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		JMenu menu = new JMenu("Menu");
		JMenu info = new JMenu("Info");

		menubar.add(menu);
		menubar.add(info); //information about the functions NOT REQUIRED In the text of the project

		JMenuItem about = new JMenuItem("About");
		JMenuItem exit = new JMenuItem("Exit");
		menu.add(about);
		menu.add(exit);
		JMenuItem Function1 = new JMenuItem("Sieve of Eratosthenes");
		JMenuItem Function2 = new JMenuItem("Greatest common divisor");
		JMenuItem Function3 = new JMenuItem("Fibonacci sequence");
		JMenuItem Function4 = new JMenuItem("Binomial coefficient");
		JMenuItem Function5 = new JMenuItem("Number of prime numbers");
		JMenuItem Function6 = new JMenuItem("Prime factorization");
		JMenuItem Function7 = new JMenuItem("Sigma function");
		info.add(Function1);
		info.add(Function2);
		info.add(Function3);
		info.add(Function4);
		info.add(Function5);
		info.add(Function6);
		info.add(Function7);


		frame.getContentPane().add(new GraphicInterface());
		frame.pack();
		frame.setVisible(true);
		
		//actionListener for the menu
		//once a menu item is clicked, the corresponding text will show in a showDialog window
		class MenuListener implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				
				String text = "This Java-programmed application was developed by Francesco Piccoli,\n"
						+ "an undergraduate computer science student of the Free University of Bolzano,\n"
						+ "for the exam project of the Computer Programming course.\n"
						+ "The application allows the user to perform 7 different functions on numbers."
						+ "\nThe source code uses 19 methods, 12 classes and 1056 lines of code";
				
				String function1 = "The sieve of Eratosthenes algorithm computes all the prime numbers\n"
						+ " smaller or equal than input n>1. Input is one integer number n greater than 1 and\n"
						+ "output is a list of positive number smaller or equal than n.";
				
				String function2 = "Given two integer numbers greater than 0,\n"
						+ "this function computes the greatest common divisor by\n"
						+ " using the Euclid algorithm. Input is two numbers n and m (greater than 0)\n"
						+ " and output is an integer number.";
				
				String function3 = "Given an integer number n>=0,\n"
						+ "this function computes the Fibonacci sequence f(0) , ... , f(n), where f(i)\n"
						+ "is the Fibonacci function: f(0) = 0, f(1) = 1, f(i) = f(i - 1) + f(i - 2)";
				
				String function4 = "Given two integer numbers n>=0 and n>=k>=0, this function\n"
						+ "computes the binomial coefficient b(n, k) = n!/[k! (n-k)!].\n"
						+ "Using the formula b(n, k) = [(n+1 -1)/1] * [(n+1 -2)/2] * ... * [(n+1 -k)/k]";
				
				String function5 = "Given an integer number n>0, this function computes\n"
						+ " the number of prime numbers smaller or equal than n.";
				
				String function6 = "Given an integer number n>1, this function identifies the prime \n"
						+ "factorization of the number. For instance, if you enter 12 the result should\n"
						+ "be the sequence 2 2 3. If you enter 56 then you must obtain 2 2 2 7.";
				
				String function7 = "Given two integer numbers n> 1 and x>=0, this function computes\n"
						+ " the sigma(x, n) function that sums the x-th powers of the positive\n"
						+ "divisors of n (including 1 and n itself). For instance sigma(0,14) = 10 + 20 + 70 + 140= 4;\n"
						+ "sigma(2,12) = 12 + 22 + 32 + 42 +62 +122 =210.";
				if(e.getSource() == about) {
					JOptionPane.showMessageDialog(null, text);
					
				}
				
				if(e.getSource() == exit) {
					System.exit(0);
				
				}
				
				if(e.getSource() == Function1) {
					JOptionPane.showMessageDialog(null, function1);
				}
				if(e.getSource() == Function2) {
					JOptionPane.showMessageDialog(null, function2);
				}
				if(e.getSource() == Function3) {
					JOptionPane.showMessageDialog(null, function3);
				}
				if(e.getSource() == Function4) {
					JOptionPane.showMessageDialog(null, function4);
				}
				if(e.getSource() == Function5) {
					JOptionPane.showMessageDialog(null, function5);
				}
				if(e.getSource() == Function6) {
					JOptionPane.showMessageDialog(null, function6);
				}
				if(e.getSource() == Function7) {
					JOptionPane.showMessageDialog(null, function7);
				}
			}
	}
		about.addActionListener(new MenuListener());
		exit.addActionListener(new MenuListener());
		Function1.addActionListener(new MenuListener());
		Function2.addActionListener(new MenuListener());
		Function3.addActionListener(new MenuListener());
		Function4.addActionListener(new MenuListener());
		Function5.addActionListener(new MenuListener());
		Function6.addActionListener(new MenuListener());
		Function7.addActionListener(new MenuListener());
}
}
