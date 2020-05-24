package Uvsq21923164.pglp9_9;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class JdbcDAOCercle implements DAO<Cercle> {
	private static String dburl = Creationdb.dburl;
	
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
		Cercle crl= null;
       

        	try   (Connection connect = DriverManager.getConnection(dburl)){
        		PreparedStatement prepareFind = connect.prepareStatement(
        				"SELECT * FROM Cercle WHERE Namecrl = ?  ");
            prepareFind.setString(1, id);
            ResultSet res = prepareFind.executeQuery();
            if (res.next()) {
                Point centre = new Point(
                        res.getInt("centre_x"),
                        res.getInt("centre_y"));
                try {
                    crl = new Cercle(id,centre,res.getInt("rayon"));
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        	
        	
        return crl;


	
        }


	@Override
	public ArrayList<Cercle> show() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
}
	
	
	
	
	
	

