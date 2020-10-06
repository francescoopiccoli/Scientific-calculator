import javax.swing.JOptionPane;

public class Function2 {
	
	private String nString, mString;

	//even if for the method gcd i don't use the two string instance variables 
	//(it would be impossible for a static method), i created them to simplify the 
	//try and catch procedure to pop up errors
	public Function2(String n, String m) {	
		
		this.nString = n;
		this.mString = m;
    }
	
	public static int gcd (int n, int m) {
	//if m > n that the divison is m/n, otherwise n/m
	    if (m > n) {
	    	//if the remainder = 0, it means that the division btw the two numbers return an integer values
	    	//so the greatest common divisor of m/n is n
	      if ((m % n) == 0) 
	         return n;
	      else
	    	  //otherwise it repeats the operation btw n and the remainder of m%n
	         return gcd(n, m % n);
	    }
	    else {
	        if ((n % m) == 0) 
	             return m;
	          else
	             return gcd(m, n % m);
	        }
	    }
	
}

