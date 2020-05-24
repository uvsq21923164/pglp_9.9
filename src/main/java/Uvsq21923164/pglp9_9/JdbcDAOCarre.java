package Uvsq21923164.pglp9_9;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class JdbcDAOCarre implements DAO<Carre> {

	private static String dburl =Creationdb.dburl;
	@Override
	public Carre create(Carre obj) throws SQLException{
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT  INTO Carre (NameCr, point_x, point_y, cote)" +
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

		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM Carre WHERE Namecr = ?  ");
			prepareFind.setString(1, obj.getname());
			ResultSet res = prepareFind.executeQuery();
			
			if(!res.next()) {  System.out.println(""
					+ "Le carre n'existe pas ");}
			else {  
			PreparedStatement prepare = connect.prepareStatement(
					"UPDATE Carre SET point_x = ?, point_y =?, "
			                + "cote =? WHERE Namecr = ? ");
			prepare.setInt(1, obj.getPoint().getX());
			prepare.setInt(2, obj.getPoint().getY());
			prepare.setInt(3, obj.getCote());
			prepare.setString(4, obj.getname());
			int result = prepare.executeUpdate();
			 assert result == 1;
			System.out.println(result);}
		}
		catch (SQLException e) {
			e.getMessage();
		} 
		
		return obj;	
	}
	

	@Override
	public void delete(Carre obj) {
		// TODO Auto-generated method stub
		try   (Connection connect = DriverManager.getConnection(dburl)){
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM Carre WHERE Namecr = ?  ");
			prepareFind.setString(1, obj.getname());
			ResultSet res = prepareFind.executeQuery();
			if(!res.next()) {  System.out.println(" le Carre n'exist pas ");}
			else {
				PreparedStatement prepare = connect.prepareStatement(
						"DELETE FROM Carre "
						+ "WHERE Namecr  = ?");
				prepare.setString(1, obj.getname());
				int result = prepare.executeUpdate();
				assert result == 1;
		}}
		catch (SQLException e) {
			e.getMessage();
		}
	}
	

	@Override
	public Carre find(String id) throws SQLException {
		Carre cr= null;
		try   (Connection connect = DriverManager.getConnection(dburl)){
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM Carre WHERE Namecr = ?  ");
			prepareFind.setString(1, id);
	            ResultSet result = prepareFind.executeQuery();
	            if (result.next()) {
	            	 Point point = new Point(
	                        result.getInt("point_x"),
	                        result.getInt("point_y"));
	                try {
	                	cr = new Carre(id,point,result.getInt("cote"));
	                } catch (Exception e) {
	                    e.printStackTrace();
	                    return null;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	        return cr;
		
	}





	@Override
	public ArrayList<Carre> show() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
