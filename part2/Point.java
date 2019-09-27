public class Point
{
	private double x;
	private double y;

	public Point (double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double getX() { return x; }
	public double getY() { return y; }

	public double getRadius()
	{
		double radius = Math.pow((Math.pow(x, 2) + Math.pow(y, 2)), .5);
		return radius;
	}

	public double getAngle() 
	{
		double angle = Math.atan2(y, x);
		return angle;
	}

	public Point rotate90() 
	{ 
		double temp = x;
		x = -1 * y;
		y = temp;
		Point p = new Point(x, y);
		return p;
	}
}