package Uvsq21923164.pglp9_9;



/*  
 *Implementation de la class Forme
 * */
public abstract class Forme {
	String name;
	/* constructeur */
	public Forme(String name) {
		this.name = name;
	}
	
/*	methode get */
	
	 public String getname() {
	        return name;
	    }
	 /* methode set */
	 public void setNom(String name) {
			this.name= name;
		}
	 public abstract void move(String name, int x, int y);
	    /**
	     * affichage de la forme.
	     */
	    public abstract void affiche();
	
	
	
	
	
	
	
	
}
