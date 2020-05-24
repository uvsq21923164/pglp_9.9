package Uvsq21923164.pglp9_9;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM Rectangle WHERE NameRc = ?  ");
			prepareFind.setString(1, obj.getname());
			ResultSet res = prepareFind.executeQuery();
			
			if(!res.next()) {  System.out.println(""
					+ "Le Rectangle n'existe pas ");}
			else {  
				PreparedStatement prepare = connect.prepareStatement(
						"UPDATE Rectangle SET point_x = ?, point_y = ?, "
				                + "largeur = ?, longeur = ? WHERE NameRc = ?");
				               
				        		prepare.setInt(1, obj.getPoint().getX());
				        		prepare.setInt(2, obj.getPoint().getY());
				        		prepare.setInt(3, obj.getLargeur());
				        		prepare.setInt(4, obj.getLongeur());
				        		prepare.setString(5, obj.getname());
				int result = prepare.executeUpdate();
				assert result == 1;}
			}
			catch (SQLException e) {
				e.getMessage();
			}
			return obj;	
		}
	

	@Override
	public void delete(Rectangle obj) {
		// TODO Auto-generated method stub
		try   (Connection connect = DriverManager.getConnection(dburl)){
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM Rectangle WHERE NameRc = ?  ");
			prepareFind.setString(1, obj.getname());
			ResultSet res = prepareFind.executeQuery();
			if(!res.next()) {  System.out.println(" le rectangle n'exist pas ");}
			else {
				PreparedStatement prepare = connect.prepareStatement(
						"DELETE FROM rectangle "
						+ "WHERE NameRc = ?");
				prepare.setString(1, obj.getname());
				int result = prepare.executeUpdate();
				assert result == 1;
		}}
		catch (SQLException e) {
			e.getMessage();
		}
	}
	

	@Override
	public Rectangle find(String id) throws SQLException {
		// TODO Auto-generated method stub
		Rectangle rtgl= null;
		try   (Connection connect = DriverManager.getConnection(dburl)){
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM Rectangle WHERE NameRc = ?  ");
			prepareFind.setString(1, id);
            ResultSet res = prepareFind.executeQuery();
            if (res.next()) {
                Point p = new Point(
                        res.getInt("point_x"),
                        res.getInt("point_y"));
                try {
                	rtgl = new Rectangle(id,p,res.getInt("largeur"),res.getInt("longeur"));
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return rtgl;
	}


	@Override
	public ArrayList<Rectangle> show() {
		// TODO Auto-generated method stub
		return null;
	}
	}

	
	
