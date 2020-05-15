package Uvsq21923164.pglp9_9;

public class Rectangle extends Forme implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	int largeur,longeur;
	Point point;
	public Point getPoint() {
		return point;
	}
	/* methode get et set */
	public void setPoint(Point point) {
		this.point = point;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getLongeur() {
		return longeur;
	}
	public void setLongueur(int longeur) {
		this.longeur = longeur;
	}

	/* construcreur */
	 public Rectangle(String name,Point p,int lag,int log) {
	    	super(name);
	    	point=p.copie();
	    	this.largeur=lag;
	    	this.longeur=log;
	    	
	    }
	@Override
	public void move(String name, int x, int y) {
		// TODO Auto-generated method stub
		point.move(x, y);
	}
	@Override
	public void affiche() {
		// TODO Auto-generated method stub
		System.out.println("Rectangle : " + name + ", Point :" + point.toString()+", Longueur : "+longeur+", largeur :"+largeur);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
