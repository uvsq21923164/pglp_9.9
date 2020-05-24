package Uvsq21923164.pglp9_9;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class JdbcDAOGroupe implements DAO<FormeGroupe> {
	private static String dburl = Creationdb.dburl;
	@Override
	public FormeGroupe create(final FormeGroupe obj) {
	try (Connection connect = DriverManager.getConnection(dburl)) {
		PreparedStatement prepare = connect.prepareStatement("INSERT INTO groupe (id) VALUES (?)");
		prepare.setString(1, obj.getname());
		int result = prepare.executeUpdate();
		assert result == 1;
		ArrayList<Forme> liste = obj.getListForm();
		for(Iterator<Forme> it = liste.iterator();
				it.hasNext();) {
			Forme n = it.next();
		prepare = connect.prepareStatement(
				"INSERT INTO appartenir VALUES (?, ?)");
		prepare.setString(1, obj.getname());
		prepare.setString(2, n.getname());
		prepare.executeUpdate();
	}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	return obj;
}
	@Override
	public FormeGroupe find(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public FormeGroupe update(FormeGroupe obj) {
		// TODO Auto-generated method stub
		FormeGroupe gp = new FormeGroupe(obj.getname());
		try  (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM groupe WHERE id = ?  ");
			prepareFind.setString(1, obj.getname());
			DaoFactory factory = new DaoFactory();
		      DAO<Carre> dc = factory.getCarreDAO();
		      DAO<Cercle> dcrl = factory.getCercleDAO();
		      DAO<triangles> dt = factory.gettrianglesDAO();
		      DAO<Rectangle> drl = factory.getRectangleDAO();
		      ArrayList<Forme> liste = obj.getListForm();
				for(Iterator<Forme> it=liste.iterator(); it.hasNext();) {
		    	Forme ins= it.next();
		    	if (ins instanceof Cercle) {
		    		gp.ajouterForme(dcrl.update((Cercle) ins));}else {
		    			
		    			if (ins instanceof Rectangle) {
			    			drl.update((Rectangle) ins);}else {
			    				
			    				if (ins instanceof triangles) {
				    		    	dt.update((triangles) ins);} else {
				    		    		if (ins instanceof Carre) {
				    		    			gp.ajouterForme(dc.update((Carre) ins));}
				    		    	}}}
		    	
		    	
		    	
		    	
		      }
				
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		obj.affiche();
		    return obj;
	
	}
	@Override
	public void delete(FormeGroupe obj) throws SQLException {
		// TODO Auto-generated method stub
		try (Connection connect = DriverManager.getConnection(dburl)){
			PreparedStatement prepareFind = connect.prepareStatement(
					"SELECT * FROM groupe WHERE id = ?  ");
			prepareFind.setString(1, obj.getname());
			ResultSet res = prepareFind.executeQuery();
			if (res.next()) {
				PreparedStatement prepare = connect.prepareStatement(
						"DELETE FROM groupe WHERE id = ?");
				prepare.setString(1, obj.getname());
				int result = prepare.executeUpdate();
				assert result == 1;
				for (Forme forme : obj.getListForm()) {
					 prepare = connect.prepareStatement(
								"DELETE FROM appartenir "
								+ "WHERE id = ? "
							 	+ "and nom = ? ");
					 prepare.setString(1, obj.getname());
					 prepare.setString(2, forme.getname());
					 int resultat = prepare.executeUpdate();
						assert resultat == 1 ;
						}
				}
			}
		catch (SQLException e) {
			e.getMessage();
		}
	}
	@Override
	public ArrayList<FormeGroupe> show() {
		// TODO Auto-generated method stub
		return null;
	}
	}
	
	
	
	
	
	
	

