package Incarnation_2;
// Calculate the equation by using the Math library.

public class JavaCalculator {

	private double x_zero = 2; // initial guess
	private double tolerance = 0.0000000001;

	// compute alpha using Newton's Method
	double getAlpha() {
		double x_temp = x_zero;
		double sin_x = Math.sin(x_zero);
		double Abs = Math.abs(x_zero - sin_x - Math.PI / 2);
		while (Abs > tolerance) {
			x_temp = x_temp - (x_temp - sin_x - Math.PI / 2) / (1 - Math.cos(x_temp));
			System.out.println("x_temp = " + x_temp + "\n");
			sin_x = Math.sin(x_temp);
			Abs = Math.abs(x_temp - sin_x - Math.PI / 2);
		}
		System.out.println("Absolute value of the function is smaller than the tolerence.");
		System.out.println("Alpha = " + x_temp + "\n");
		return x_temp;
	}

	public double getL(double r) {
		double alpha = getAlpha();
		double l = 2 * r * (1 - Math.cos(alpha / 2));
		System.out.println("l = " + l + "\n");
		return l;
	}
}
