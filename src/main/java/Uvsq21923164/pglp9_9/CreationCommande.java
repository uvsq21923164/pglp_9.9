package Uvsq21923164.pglp9_9;



import java.sql.SQLException;

public class CreationCommande implements Commande{
	
		Forme forme;
		
     /**
      * constructeur**/
    public CreationCommande(Forme forme) {
    	 this.forme=forme;
     }
	/**
	 *execution command
	 */
	public void execute() throws SQLException {
	
		DaoFactory factory = new DaoFactory();
		
        if (forme instanceof Cercle) {
            DAO<Cercle> cercle = factory.getCercleDAO();
             cercle.create((Cercle) forme);
        } else if (forme instanceof Rectangle) {
        	DAO<Rectangle> rectangle = factory.getRectangleDAO();
             rectangle.create((Rectangle) forme);
        } else if (forme instanceof triangles) {
        	DAO<triangles> triangle = factory.gettrianglesDAO();
             triangle.create((triangles) forme);
        }  else if (forme instanceof Carre) {
        	DAO<Carre> carre = factory.getCarreDAO();
             carre.create((Carre) forme);
        }
        else {
            DAO<FormeGroupe> groupe = factory.getFormegroupeDAO();
             groupe.create((FormeGroupe) forme);
        }
       
            System.out.println("La forme est créée ");
       
	}

}
	
	

