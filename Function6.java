import javax.swing.JOptionPane;

public class Function6 {
	private String number;
	private String result;
	private int numb;
	
	public Function6(String number) {

		this.number = number;
		numb  = Integer.parseInt(number);

		result = ""; //result string will contain all the prime factorization
		
		while (numb % 2 == 0){  //while the result is divisible by 2, a 2 is added to the string
        
            result += 2 + " "; 
            numb = numb / 2; 
        } 
  
		//looking for prime numbers that divide n starting from 2+1 = 3, 
		//jumping all the multiple of 2 because they were already counted in the previous while
		//till when we get to n
		for (int j = 3; j <= numb; j += 2)  { 
            while (numb % j == 0) { //if the division n/j has 0 as remainder, then j is a divisor of n
                result += j + " "; //so we add j to the result string
                numb = numb / j; //the new value of the number we consider is n/j 
            } 
        } 
  
		//if the final value of n is bigger than 2 (not equal to 1 or not equal to 2)
		//then the input number is prime so the prime factorization is the number itself
        if (numb > 2) 
            result  +=  numb; 
    } 
	
	public String toString() {
		return result;
	}
}
