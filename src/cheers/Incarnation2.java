package cheers;

import team_E_library.Team_E_Math;

public class Incarnation2 extends Team_E_Math{
	
	private double x_zero = 2; // initial guess
	
	/** 
	 * @author Eric Watat Lowe
	 * @param  tolerance the accepted error margin
	 * @param  precision  the acceptable number of significant digits of the approximation
	 */
	public Incarnation2(double tolerance, int precision){
		
		super(tolerance,precision);
	}

	/**
	 * This method computes the length "l" which is the distance of the segment X1X2
	 * As described in the cheers specification.
	 *  
	 * @author Eric Watat Lowe
	 * @param  radius the radius of the circles to overlap
	 * @return      the length "l" 
	 */
	@Override
	public double getL(double radius) {
		
		double alpha = getAlpha();
		double l = 2 * radius * (1 - getCos(alpha / 2));
		
		System.out.println("l = " + l + "\n");
		
		return l;
	}

	/**
	 * This method computes the value of alpha given by the equation: alpha – sin(alpha) = Pi/2.
	 *  
	 * @author Ni Ye
	 * @return      alpha 
	 */
	@Override
	public double getAlpha() {
		
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

	/**
	 * This method computes the value of Cos(alpha) using the Java native library.
	 *  
	 * @author Eric Watat Lowe
	 * @param radian the value of alpha
	 * @return      Cos(alpha) 
	 */
	@Override
	public double getCos(double radian) {
		
		return Math.cos(radian);
	}

	/**
	 * This method computes the value of Sin(alpha) using the Java native library.
	 *  
	 * @author Eric Watat Lowe
	 * @param radian the value of alpha
	 * @return      Sin(alpha) 
	 */
	@Override
	public double getSin(double radian) {
		
		return Math.sin(radian);
	}

	/**
	 * This method computes the absolute value od a number using the Java native library.
	 *  
	 * @author Eric Watat Lowe
	 * @param number 
	 * @return      abs(number) 
	 */
	@Override
	public double getAbsoluteValue(double number) {
		
		return Math.abs(number);
	}

	/**
	 * This method returns the value of Pi taken from the Java native library.
	 *  
	 * @author Eric Watat Lowe
	 * @return      Pi 
	 */
	@Override
	public double getPi() {
		
		return Math.PI;
	}

}
