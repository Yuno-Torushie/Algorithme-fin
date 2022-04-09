package defalut;

public class Point {
	
	private double x;
	private double y;
	
	public Point() {
		this(0.,0.);
	}
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Point(Point origine) {
		this(origine.x, origine.y);
	}
	
	public String affiche() {
		return "("+x+","+y+")";
	}

}
