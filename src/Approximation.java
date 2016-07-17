// Approximation Algorithms for Numerical Problems.

public class Approximation {
	
	private int PRECISION = 4;
	
	//compute sin by using Taylor Series
	double getSin(double x) { // X is Radiance
		double rad = x;
		double sum = rad;
		for (int i = 1; i <= PRECISION; i++) {
	        if (i % 2 == 0) 
	            sum += getPower(rad, 2*i+1) / getFactorial(2 * i + 1);
	        else 
	            sum -= getPower(rad, 2*i+1) / getFactorial(2 * i + 1);
	        //System.out.println("Sum = " + sum + "\n");
	    }
		return sum;
	}
	
	//compute sin by using Taylor Series
	double getCos(double x) { // X is Radiance
		double rad = x;
		double sum = 1;
		for (int i = 1; i <= PRECISION; i++) {
	        if (i % 2 == 0) 
	            sum += getPower(rad, 2*i) / getFactorial(2 * i);
	        else 
	            sum -= getPower(rad, 2*i) / getFactorial(2 * i);
	        //System.out.println("Sum = " + sum + "\n");
	    }
		return sum;
	}

	//compute power
	private double getPower(double x, int p) {
		double result = 1;
		for (int i = 0; i <p; i++) {
			result = result*x;
		}
		return result;
	}
	
	//compute factorial
	private double getFactorial(int x) {
		double result = 1;
		for (int i = 1; i<=x; i++) {
			result = result*i;
		}
		return result;
	}
}
