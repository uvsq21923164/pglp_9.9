package Uvsq21923164.pglp9_9;

public class Cercle extends Forme {

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
	
	public void deplacer(String name, int x, int y) {
		centre.deplacer(x, y);
		
	}

	public void affiche() {
		System.out.println("Cercle : " + name + ", rayon " + rayon+ ", centre "+ centre.toString());
		
	}
	
}
