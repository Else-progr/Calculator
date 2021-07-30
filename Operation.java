

public class Operation {
	
	
	public Operation(){
		
	} // end constructor Operation
	

	public double add(double x, double y) {
		return (x+y);
	} // end method add
	
	public double sub(double x, double y) {
		return (x-y);
	} // end method sub
	
	public double mult(double x, double y) {
		return (x*y);
	} // end method mult
	
	public double div(double x, double y) {
		return (x/y);
	} // end method div
	
	public double sqrt(double x) {
		return (Math.sqrt(x));
	} // end method sqrt
	
	public double pot(double x, double y) {
		return Math.pow(x,y);
	} // end method pot

} // end class Operation
