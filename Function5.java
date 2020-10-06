import javax.swing.JOptionPane;

public class Function5 {
	private String w;
	String result;
	int numberOfPrimeNumber;
	
			public Function5(String w) {
				//it just takes the algorithm of the first function divides the result string every time there is a space
				//and set those values in an array, the number of prime numbers is equal to the array length minus one
		
				this.w = w;
			 	int number = Integer.parseInt(w);
		        boolean[] primeNumbers = new boolean[number+1]; 
		        for(int i=0; i<= number; i++) 
		            primeNumbers[i] = true; 
		        
		        for(int m = 2; m * m <= number; m++){ 
		            if(primeNumbers[m] == true){ 
		                for(int i = m*2; i <= number; i += m) 
		                    primeNumbers[i] = false; } 
		        } 
		          
		        //i = 1, not 2 like in the other algorithm because here the input is > 0, not 1
		        for(int i = 1; i <= number; i++) 
		        { 
		            if(primeNumbers[i] == true) 
		                result += i + " "; 
		        }
			        
			        String[] array = result.split(" ");
			        numberOfPrimeNumber = array.length - 1;
	}
			
	
			public String toString() {
					
				return numberOfPrimeNumber + "";
	}
}
