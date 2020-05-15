package Uvsq21923164.pglp9_9;

import java.util.ArrayList;

public class FormeGroupe extends Forme implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	/**
     * la liste des formes.
     */
    private ArrayList<Forme> formes;
	
    public FormeGroupe(String name) {
		super(name);
		 formes = new ArrayList<Forme>();	
}

    
	@Override
	public void move(String name, int x, int y) {
		 for (Forme forme : formes) {
	            forme.move(name,x, y);
	        }
		
	}

	@Override
	public void affiche() {
		System.out.println("Groupe :");
        for (Forme forme : formes) {
            forme.affiche();
        }
		
	}
	
	
	public ArrayList<Forme> getListForm() {
        return this.formes;
    }
	public void ajouterForme(final Forme forme) {
		this.formes.add(forme);
	}
	
	public void supprimerForme(final Forme forme) {
	        formes.remove(forme);
	    }
	
}
