package Uvsq21923164.pglp9_9;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class JdbcDAOCercle implements DAO<Cercle> {
	private static String dburl = Creationdb.dburl;
	@Override
	public Cercle create(Cercle obj) throws SQLException {
			try (Connection connect = DriverManager.getConnection(dburl)) {
				PreparedStatement prepare = connect.prepareStatement(
						"INSERT  INTO Cercle (Nomcrl, centre_x, centre_y, rayon)" +
						"VALUES (?, ?, ?, ?)");
				prepare.setString(1, obj.getname());
				prepare.setInt(2, obj.getCentre().getX());
				prepare.setInt(3, obj.getCentre().getY());
				prepare.setInt(4, obj.getRayon());
				int result = prepare.executeUpdate();
				assert result == 1;
			}
			catch (SQLException e) {
				e.getMessage();
				
			}
			return obj;	
	}

	
	@Override
	public Cercle update(Cercle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Cercle obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cercle find(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
