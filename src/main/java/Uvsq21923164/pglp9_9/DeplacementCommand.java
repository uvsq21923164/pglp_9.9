package Uvsq21923164.pglp9_9;


import java.sql.SQLException;

public class DeplacementCommand implements Commande{

	Forme forme;

	Point point;
	
	public DeplacementCommand(Forme forme,Point point) {
		this.forme=forme;
		this.point=point;
	}

	public void execute() throws SQLException {
		String f="";
		 forme.move(f,point.getX(), point.getY());
	DaoFactory factory = new DaoFactory();
	
        if (forme instanceof Cercle) {
            DAO<Cercle> cercle = factory.getCercleDAO();
             cercle.update((Cercle) forme);
        } else if (forme instanceof Rectangle) {
        	DAO<Rectangle> rectangle = factory.getRectangleDAO();
             rectangle.update((Rectangle) forme);
        } else if (forme instanceof triangles) {
        	DAO<triangles> triangle = factory.gettrianglesDAO();
             triangle.update((triangles) forme);
        }  else if (forme instanceof Carre) {
        	DAO<Carre> carre = factory.getCarreDAO();
             carre.update((Carre) forme);
        }
        else {
            DAO<FormeGroupe> groupe = factory.getFormegroupeDAO();
             groupe.update((FormeGroupe) forme);
        }
       
		
	}

}