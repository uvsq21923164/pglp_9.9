package Uvsq21923164.pglp9_9;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDAORectangle implements DAO<Rectangle> {

	
	private static String dburl = Creationdb.dburl;
	@Override
	public Rectangle create(Rectangle obj) throws SQLException {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT  INTO Rectangle (NameRc, point_x, point_y, largeur, longeur)" +
					"VALUES (?, ?, ?, ?, ?)");
			prepare.setString(1, obj.getname());
			prepare.setInt(2, obj.getPoint().getX());
			prepare.setInt(3, obj.getPoint().getY());
			prepare.setInt(4, obj.getLargeur());
			prepare.setInt(5, obj.getLongeur());
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e) {
			e.getMessage();
			
		}
		return obj;
	}

	
	@Override
	public Rectangle update(Rectangle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Rectangle obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle find(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
