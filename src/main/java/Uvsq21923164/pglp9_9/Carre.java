package Uvsq21923164.pglp9_9;

public class Carre extends Forme implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	Point point;
	int cote;
	/* methodes get et set */
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public int getCote() {
		return cote;
	}

	public void setCote(int cote) {
		this.cote = cote;
	}


/* Constructeur de la class*/
	public Carre(String name,Point p,int cote) {
		super(name);
		point=p.copie();
		this.cote=cote;
	}

	
	public void deplacer(String name, int x, int y) {
		point.deplacer(x, y);
		
	}

	public void affiche() {
		System.out.println( "Carre : " + name + ", Point : " + point.toString()+ ", cote :"+ cote);
		
	}

	

}
