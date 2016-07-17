//Calculate the equation.

public class Calculator {
	
	private double Pi = 3.14159265359;
	private double x_zero = 2; //initial guess
	private double tolerence = 0.000001; 
	
	double getAlpha(){
		Approximation a = new Approximation();
		double x_temp = x_zero;
		double Abs = getAbs(x_zero - a.getSin(x_zero) - Pi/2);
		System.out.println(Abs);
		for (int i = 0; Abs > tolerence; i++) {
			x_temp = x_temp - (x_temp - a.getSin(x_temp) - Pi/2) / (1 - a.getCos(x_temp));	
			Abs = getAbs(x_temp - a.getSin(x_temp) - Pi/2);
			System.out.println("x_temp = " + x_temp);
			System.out.println("Abs = " + Abs);
		}
		return x_temp;
	}
	
	double getL(double r){		
		Approximation a = new Approximation();
		double alpha = getAlpha();
		double l = 2*r*(1-a.getCos(alpha/2));
		return l;
	}
	
	private double getAbs(double x){
		if (x>0)
			return x;
		else 
			return (-x);
	}
}
