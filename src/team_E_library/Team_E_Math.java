package team_E_library;

public abstract class Team_E_Math {
	
	private int precision;
	private double tolerance;
	
	public Team_E_Math(double tolerance,int precision){
		
		this.precision = precision;
		this.tolerance = tolerance;
	}
	
	public abstract double  getL(double radius);
	public abstract double  getAlpha();
	public abstract double  getCos(double radiance);
	public abstract double  getSin(double radiance);
	public abstract double  getAbsoluteValue(double number);
	public abstract double  getPi();
	
	public int getPrecision(){return precision;}
	public double getTolerance(){return tolerance;}
	
	public void setPrecision(int precision){
		
		this.precision = precision;
		
	}
	
	public void setTolerance(double tolerance){
		
		this.tolerance = tolerance;
	}

}
