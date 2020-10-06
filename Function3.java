import javax.swing.JOptionPane;

public class Function3 {
private String n;
	
	public Function3(String n) {
		//to handle errors
		this.n = n;
	}
	
	public static int fibonacciSequence(int n)  {
		// f(0) = 0
	    if(n == 0)
	        return 0;
		// f(1) = 1
	    else if(n == 1)
	      return 1;
	   else
	    //f(n) (n different from 0 and 1: it repeats the function of (n-1) and (n-2)
		//till when n = 0 or n = 1
		//the result is given by the sum of all those values
		//it is a recursive function, it divides the computation in smaller computations
		//till when it gets to the base cases
	      return fibonacciSequence(n - 1) + fibonacciSequence(n - 2);
	}
}
