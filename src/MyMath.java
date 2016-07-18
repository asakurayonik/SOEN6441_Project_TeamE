// Approximation Algorithms for Numerical Problems.

public class MyMath {
	
	private int PRECISION;
	
	public MyMath (int p)
	{
		PRECISION = p;
	}
	
	public MyMath() {
		PRECISION = 10;
	}

	//compute sin by using Taylor Series
	double getSin(double x) { // X is Radiance
		double rad = x;
		double sum = rad;
		for (int i = 1; i <= PRECISION; i++) {
	        if (i % 2 == 0) 
	            sum += getPower(rad, 2*i+1) / getFactorial(2 * i + 1);
	        else 
	            sum -= getPower(rad, 2*i+1) / getFactorial(2 * i + 1);	   
	      System.out.println("Step " + i + ".   " + sum);
	    }
		System.out.println("Sin(" + x + ") = " + sum);
		return sum;
	}
	
	//compute cos by using Taylor Series
	double getCos(double x) { // X is Radiance
		double rad = x;
		double sum = 1;
		for (int i = 1; i <= PRECISION; i++) {
	        if (i % 2 == 0) 
	            sum += getPower(rad, 2*i) / getFactorial(2 * i);
	        else 
	            sum -= getPower(rad, 2*i) / getFactorial(2 * i);
	        System.out.println("Step " + i + ".   " + sum);
	    }
		System.out.println("Cos(" + x + ") = " + sum);
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
	
	//compute absolute value
	double getAbs(double x){
		if (x>0)
			return x;
		else 
			return (-x);
	}
	
	// compute Pi by Leibniz Formula
	double getPi() {
		double sum = 0;
		for (int i = 1; i <= 100000*PRECISION; i++) {
			if (i % 2 == 0)
				sum -= (1.0 / (2 * i - 1));
			else
				sum += (1.0 / (2 * i - 1));
		}
		sum = sum * 4;
		System.out.println("Pi = " + sum);
		return sum;
	}
	
	//compute Pi by Newton's Formula
	/*double getPi() {
		double sum = 1;
		for (int i = 1; i <= 10000; i++) {
			sum += (1.0 / (getPower(4, i) * getFactorial(2 * i + 1)));
		}
		sum = sum*3;
		System.out.println("Pi = " + sum);
		return sum;
	}*/
	
	
}
