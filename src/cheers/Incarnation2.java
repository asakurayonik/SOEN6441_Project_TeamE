package cheers;

import team_E_library.Team_E_Math;

public class Incarnation2 extends Team_E_Math{
	
	private double x_zero = 2; // initial guess
	
	public Incarnation2(double tolerance, int precision){
		
		super(tolerance,precision);
	}

	@Override
	public double getL(double radius) {
		
		// TODO Auto-generated method stub
		double alpha = getAlpha();
		double l = 2 * radius * (1 - getCos(alpha / 2));
		System.out.println("l = " + l + "\n");
		
		return l;
	}

	@Override
	public double getAlpha() {
		
		// TODO Auto-generated method stub
		double x_temp = x_zero;
		double sin_x = getSin(x_zero);
		double Abs = getAbsoluteValue(x_zero - sin_x - getPi() / 2);
		
		while (Abs > getTolerance()) {
			
			x_temp = x_temp - (x_temp - sin_x - getPi() / 2) / (1 - getCos(x_temp));
			System.out.println("x_temp = " + x_temp + "\n");
			
			sin_x = getSin(x_temp);
			Abs = getAbsoluteValue(x_temp - sin_x - getPi() / 2);
		}
		
		System.out.println("Absolute value of the function is smaller than the tolerence.");
		System.out.println("Alpha = " + x_temp + "\n");
		
		return x_temp;
	}

	@Override
	public double getCos(double radiance) {
		// TODO Auto-generated method stub
		return Math.cos(radiance);
	}

	@Override
	public double getSin(double radiance) {
		// TODO Auto-generated method stub
		return Math.sin(radiance);
	}


	@Override
	public double getAbsoluteValue(double number) {
		// TODO Auto-generated method stub
		return Math.abs(number);
	}

	@Override
	public double getPi() {
		// TODO Auto-generated method stub
		return Math.PI;
	}

}
