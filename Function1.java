import javax.swing.JOptionPane;

public class Function1 extends GraphicInterface{

	private String w;
	private String result = "";
	
	public Function1(String w) {
		
		this.w = w;
	 	int number = Integer.parseInt(w);
	 	//creates an array of boolean values whose size is [0...n]
        boolean[] primeNumbers = new boolean[number+1]; 
        //at the beginning each element of the array is set to true
        for(int i = 0; i <= number; i++) 
            primeNumbers[i] = true; 
        //all the multiples are not prime 
        for(int m = 2; m * m <= number; m++){ 
            // If primeNumbers[m] isn't changed of value by the following for, it means it is a prime 
            if(primeNumbers[m] == true){ 
            	for(int i = m*2; i <= number; i += m) 
                    primeNumbers[i] = false; } 
        } 
          
        //starting from two, the first prime number, all the values whose value is equal to true, are printed 
        //the true values are the ones that are not multiple of two or multiple of prime numbers
        for(int i = 2; i <= number; i++) 
        { 
            if(primeNumbers[i] == true) 
                result += i + " "; 
        } }
	
	public String toString() {
		return result;
	}
}
