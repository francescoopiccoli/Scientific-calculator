import javax.swing.JOptionPane;

public class Function4 {
	private String one, two;	
	private double result;
	
	public Function4(String one, String two) {	
		//this constructor is useful to handle the input errors, as in all the other classes
		this.one = two;
		this.one = two;
		double n = Integer.parseInt(one);
		double k = Integer.parseInt(two);
		
		result = 1;
		//i used the formula suggested in the exam project text
		//it is basically a for, every time the value of i increase of 1 unit
		//till when it is equal to k
		//the final result is given by the product of all those computations
		for(int i = 1; i <= k; i++) {
			
			result *= ((n + 1 - i)/i);
		}
	}
	
	public String toString() {
		return "" + (int) result;
	}
}
	
        



