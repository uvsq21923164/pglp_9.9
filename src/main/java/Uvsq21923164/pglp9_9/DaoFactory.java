package Uvsq21923164.pglp9_9;

public class DaoFactory {
	public DAO<Carre> getCarreDAO ( ) {
		return new JdbcDAOCarre () ;
		}
	public  DAO<Rectangle> getRectangleDAO ( ) {
		return new JdbcDAORectangle () ;
		}
	public  DAO<Cercle> getCercleDAO ( ) {
		return new JdbcDAOCercle () ;
		}
	public  DAO<triangles> gettrianglesDAO ( ) {
		return new JdbcDAOtriangle () ;
		}
	public  DAO<FormeGroupe> getFormegroupeDAO ( ) {
		return new JdbcDAOGroupe() ;
		}
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
}
