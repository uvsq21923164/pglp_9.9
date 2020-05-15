package Uvsq21923164.pglp9_9;

public class triangles extends Forme implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	Point point1,point2,point3;
    public Point getPoint1() {
		return point1;
	}
	public void setPoint1(Point point1) {
		this.point1 = point1;
	}
	public Point getPoint2() {
		return point2;
	}
	public void setPoint2(Point point2) {
		this.point2 = point2;
	}
	public Point getPoint3() {
		return point3;
	}
	public void setPoint3(Point point3) {
		this.point3 = point3;
	}
	public triangles(String name,Point p1,Point p2,Point p3) {
    	super(name);
    	point1=p1.copie();
    	point2=p2.copie();
    	point3=p3.copie();
    }
	@Override
	public void move(String name, int x, int y) {
		this.point1.setX(this.point1.getX() + x);
		this.point1.setY(this.point1.getY() + y);
		this.point2.setX(this.point2.getX() + x);
		this.point2.setY(this.point2.getY() + y);
		this.point3.setX(this.point3.getX() + x);
		this.point3.setY(this.point3.getY() + y);
		
	}
		

	public void affiche() {
		System.out.println("Triangle : " + name + ", Point 1 " + point1.toString()+ ", Point 2 "+ point2.toString()+ ", Point 3 "+ point3.toString());
			
		
	}
	
		
	
}
