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
	public triangles update(triangles obj) {
		// TODO Auto-generated method stub
		try  (Connection connect = DriverManager.getConnection(dburl)){
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM Triangle WHERE NameTr = ?  ");
			prepareFind.setString(1, obj.getname());
			ResultSet res = prepareFind.executeQuery();
			
			if(!res.next()) { System.out.println("Le triangle n'existe pas ");
					}
			else {  
			PreparedStatement prepare = connect.prepareStatement(
					"UPDATE Triangle  SET point1_x = ?, "
					+ "point1_y = ?, "
					+ "point2_x = ?, "
					+ "point2_y = ?, "
					+ "point3_x = ?, "
					+ "point3_y = ? WHERE NameTr = ?");
			prepare.setInt(1, obj.getPoint1().getX());
			prepare.setInt(2, obj.getPoint1().getY());
			prepare.setInt(3, obj.getPoint2().getX());
			prepare.setInt(4, obj.getPoint2().getY());
			prepare.setInt(5, obj.getPoint3().getX());
			prepare.setInt(6, obj.getPoint3().getY());
			prepare.setString(7, obj.getname());
			int result = prepare.executeUpdate();
			assert result == 1;}
		}
		catch (SQLException e) {
			e.getMessage();
		}
		return obj;	
	}
	

	@Override
	public void delete(triangles obj) throws SQLException {
		// TODO Auto-generated method stub
		try   (Connection connect = DriverManager.getConnection(dburl)){
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM Triangle WHERE NameTr = ?  ");
			prepareFind.setString(1, obj.getname());
			ResultSet res = prepareFind.executeQuery();
			if(!res.next()) {  System.out.println(" le rectangle n'exist pas ");}
			else {
				PreparedStatement prepare = connect.prepareStatement(
						"DELETE FROM Triangle "
						+ "WHERE NameTr  = ?");
				prepare.setString(1, obj.getname());
				int result = prepare.executeUpdate();
				assert result == 1;
		}}
		catch (SQLException e) {
			e.getMessage();
		}
	}
	

	
	
	
	
	
}
