package Uvsq21923164.pglp9_9;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class JdbcDAOCarre implements DAO<Carre> {

	private static String dburl =Creationdb.dburl;
	@Override
	public Carre create(Carre obj) throws SQLException{
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT  INTO Carre (NamCr, point_x, point_y, cote)" +
					"VALUES (?, ?, ?, ?)");
			prepare.setString(1, obj.getname());
			prepare.setInt(2, obj.getPoint().getX());
			prepare.setInt(3, obj.getPoint().getY());
			prepare.setInt(4, obj.getCote());
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e) {
			e.getMessage();
			
		}
		return obj;
	}

	



	@Override
	public Carre update(Carre obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Carre obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Carre find(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
