package Uvsq21923164.pglp9_9;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDAOtriangle implements DAO<triangles> {

	private static String dburl = Creationdb.dburl;
	@Override
	public triangles create(triangles obj) throws SQLException {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT  INTO Triangle (NameTr, point1_x, point1_y, point2_x, point2_y,point3_x, point3_y)" +
					"VALUES (?, ?, ?, ?, ?, ?, ?)");
			prepare.setString(1, obj.getname());
			prepare.setInt(2, obj.getPoint1().getX());
			prepare.setInt(3, obj.getPoint1().getY());
			prepare.setInt(4, obj.getPoint2().getX());
			prepare.setInt(5, obj.getPoint2().getY());
			prepare.setInt(6, obj.getPoint3().getX());
			prepare.setInt(7, obj.getPoint3().getY()); 
			
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e) {
			e.getMessage();
			
		}
		return obj;
	}

	
	


	@Override
	public triangles find(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public triangles update(triangles object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(triangles object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}
