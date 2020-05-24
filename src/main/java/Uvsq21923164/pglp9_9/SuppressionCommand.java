package Uvsq21923164.pglp9_9;


import java.sql.SQLException;
import java.util.ArrayList;

public class SuppressionCommand implements Commande{

	ArrayList<Forme> formeList;
	
    public SuppressionCommand(ArrayList<Forme> list) {
	 this.formeList=list;
    }
   
	/**
	 *execution command
	 */
	public void execute() throws SQLException {
		DaoFactory factory = new DaoFactory();
		 for (Forme forme : formeList) {
        if (forme instanceof Cercle) {
            DAO<Cercle> cercle = factory.getCercleDAO();
             cercle.delete((Cercle) forme);
        } else if (forme instanceof Rectangle) {
        	DAO<Rectangle> rectangle = factory.getRectangleDAO();
             rectangle.delete((Rectangle) forme);
        } else if (forme instanceof triangles) {
        	DAO<triangles> triangle = factory.gettrianglesDAO();
             triangle.delete((triangles) forme);
        }  else if (forme instanceof Carre) {
        	DAO<Carre> carre = factory.getCarreDAO();
             carre.delete((Carre) forme);
        }
        else {
        	DAO<FormeGroupe> groupe = factory.getFormegroupeDAO();
             groupe.delete((FormeGroupe) forme);
        }
		 }
            System.out.println("La forme est supprimée");
       
		 
	}

}