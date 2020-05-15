package Uvsq21923164.pglp9_9;

public class Cercle extends Forme implements java.io.Serializable  {
	private static final long serialVersionUID = 1L;
	int rayon;
	Point centre;
	
    public int getRayon() {
		return rayon;
	}
	public void setRayon(int rayon) {
		this.rayon = rayon;
	}
	public Point getCentre() {
		return centre;
	}
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	public Cercle(String name,Point p,int rayon){
    	super(name);
    	this.centre=p.copie();
    	this.rayon=rayon;
    }
	
	public void move(String name, int x, int y) {
		centre.move(x, y);
		
	}

	public void affiche() {
		System.out.println("Cercle : " + name + ", rayon " + rayon+ ", centre "+ centre.toString());
		
	}
	
}
