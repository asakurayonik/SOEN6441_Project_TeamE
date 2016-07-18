//Calculate the equation.

public class Calculator {
	
	private double Pi = 3.14159265359;
	private double x_zero = 2; //initial guess
	private double tolerance = 0.000001;
	private int PRECISION = 10;
	
	public Calculator(int p, double t)
	{
		tolerance = t;
		PRECISION = p;
	}
	
	// compute alpha using Newton's Method
	double getAlpha(){
		Approximation a = new Approximation(PRECISION);
		double x_temp = x_zero;
		double sin_x = a.getSin(x_zero);
		double Abs = getAbs(x_zero - sin_x - Pi/2);
		for (int i = 0; Abs > tolerance; i++) {
			x_temp = x_temp - (x_temp - sin_x - Pi/2) / (1 - a.getCos(x_temp));	
			System.out.println("x_temp = " + x_temp + "\n");
			sin_x = a.getSin(x_temp);
			Abs = getAbs(x_temp - sin_x - Pi/2);
		}
		System.out.println("Absolute value of the function is smaller than the tolerence.");
		System.out.println("Alpha = " + x_temp + "\n");
		return x_temp;
	}
	
	double getL(double r){		
		Approximation a = new Approximation(PRECISION);
		double alpha = getAlpha();
		double l = 2*r*(1-a.getCos(alpha/2));
		System.out.println("l = " + l + "\n");
		return l;
	}
	
	private double getAbs(double x){
		if (x>0)
			return x;
		else 
			return (-x);
	}
}
