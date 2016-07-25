package cheers;

import team_E_library.*; 

public class Incarnation1 extends Team_E_Math{
	
	private double Pi;
	private double x_zero = 2; // initial guess
	

	public Incarnation1(int precision, double tolerance){
		
		super(tolerance,precision);
		
		Pi = getPi();
	}
	
	@Override
	public double getL(double radius) {
		
		double alpha = getAlpha();
		double l = 2 * radius * (1 - getCos(alpha / 2));
		System.out.println("l = " + l + "\n");
		
		return l;
	}

	@Override
	public double getAlpha() {
		
		double x_temp = x_zero;
		double sin_x = getSin(x_zero);
		double Abs = getAbsoluteValue(x_zero - sin_x - Pi / 2);
		double tolerance = getTolerance();
		
		while (Abs > tolerance) {
			
			x_temp = x_temp - (x_temp - sin_x - Pi / 2) / (1 - getCos(x_temp));
			System.out.println("x_temp = " + x_temp + "\n");
			sin_x = getSin(x_temp);
			Abs = getAbsoluteValue(x_temp - sin_x - Pi / 2);
		}
		
		System.out.println("Absolute value of the function is smaller than the tolerence.");
		System.out.println("Alpha = " + x_temp + "\n");
		
		return x_temp;
	}

	@Override
	public double getCos(double radian) {
		
		double sum = 1;
		
		for (int i = 1; i <= getPrecision(); i++) {
			
	        if (i % 2 == 0){
	        	
	        	sum += getPower(radian, 2 * i) / getFactorial(2 * i);	
	        }
	        else{
	        	
	        	sum -= getPower(radian, 2 * i) / getFactorial(2 * i);
	        }
	        
	        System.out.println("Step " + i + ".   " + sum);
	    }
		
		System.out.println("Cos(" + radian + ") = " + sum);
		
		return sum;
	}

	@Override
	public double getSin(double radian) {
		
		double sum = radian;
		
		for (int i = 1; i <= getPrecision(); i++) {
			
	        if (i % 2 == 0){
	        	
	        	sum += getPower(radian, 2*i + 1) / getFactorial(2*i + 1);	
	        } 
	        else{
	        	
	        	sum -= getPower(radian, 2*i + 1) / getFactorial(2*i + 1);
	        }
	            	   
	      System.out.println("Step " + i + ".   " + sum);
	    }
		
		System.out.println("Sin(" + radian + ") = " + sum);
		
		
		return sum;
	}


	public double getPower(double x, int power) {
		
		double result = 1;
		
		for (int i = 0; i < power; i++) {
			
			result = result * x;
		}
		
		return result;
	}

	
	public double getFactorial(int number) {
		
		double result = 1;
		
		for (int i = 1; i <= number; i++) {
			
			result = result*i;
		}
		
		return result;
	}

	@Override
	public double getAbsoluteValue(double number) {
		
		if (number > 0){
			
			return number;
		}	
		else{
			
			return (-number);
		}
			
	}

	@Override
	public double getPi() {
		
		double sum = 0;
		
		for (int i = 1; i <= 100000 * getPrecision(); i++) {
			
			if (i % 2 == 0){
				
				sum -= (1.0 / (2*i - 1));
			}
			else{
				
				sum += (1.0 / (2*i - 1));
			}		
		}
		
		sum = sum * 4;
		
		System.out.println("Pi = " + sum);
		
		return sum;
	}

}
