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
		double calc = (y/x);
		double angle = Math.atan(calc);
		if (x < 0)
			return (angle + Math.PI);
		else if (x >= 0 && y <= 0)
			return (angle + (2 * Math.PI));
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