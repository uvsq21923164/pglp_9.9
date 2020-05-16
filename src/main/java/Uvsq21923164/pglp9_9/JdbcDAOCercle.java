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
						"INSERT  INTO Cercle (Namecrl, centre_x, centre_y, rayon)" +
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
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM Cercle WHERE Namecrl = ?  ");
			prepareFind.setString(1, obj.getname());
			ResultSet res = prepareFind.executeQuery();
			
			if(!res.next()) {  System.out.println(""
					+ "Le carre n'existe pas ");}
			else {  
				PreparedStatement prepare = connect.prepareStatement(
						"UPDATE Cercle SET centre_x = ?, "
						+ "centre_y = ?, "
						+ "rayon = ? WHERE Namecrl = ?");
				prepare.setInt(1, obj.getCentre().getX());
				prepare.setInt(2, obj.getCentre().getY());
				prepare.setInt(3, obj.getRayon());
				prepare.setString(4, obj.getname());
				int result = prepare.executeUpdate();
				assert result == 1;}
			}
			catch (SQLException e) {
				e.getMessage();
			}
			return obj;	
		}
	
	

	@Override
	public void delete(Cercle obj) {
		// TODO Auto-generated method stub
		
	try   (Connection connect = DriverManager.getConnection(dburl)){
		PreparedStatement prepareFind = connect.prepareStatement(
				"SELECT * FROM Cercle WHERE Namecrl = ?  ");
		prepareFind.setString(1, obj.getname());
		ResultSet res = prepareFind.executeQuery();
		if(!res.next()) {  System.out.println(" Cercle n'exist pas ");}
		else {
			PreparedStatement prepare = connect.prepareStatement(
					"DELETE FROM Cercle "
							+ "WHERE Namecrl = ?");
			prepare.setString(1, obj.getname());
			int result = prepare.executeUpdate();
			assert result == 1;
	}}
	catch (SQLException e) {
		e.getMessage();
	}
}
	

	@Override
	public Cercle find(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
