import javax.swing.JOptionPane;

public class Function7 {
	
	private String number1, number2;	
	private int n, m, result = 0;


	public Function7(String number1, String number2) {	
		
		 this.number1 = number1;
		 this.number2 = number2;
		 n = Integer.parseInt(number1);
		 m = Integer.parseInt(number2);
		 
		 //it considers all the numbers between 1 and n
		 for(int i = 1; i <= n; i++) {
			 //if the remainder of the division n%i = 0
			 //it means that i is a divisor of n
			 if(n % i == 0) {
				 //the result is given by the sum of all divisors raised to the power of m
				 result += Math.pow(i, m);
			 }
		 }
	}
	public String toString() {
		return "" + result;
	}
	}


