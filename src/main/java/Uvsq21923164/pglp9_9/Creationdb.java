package Uvsq21923164.pglp9_9;
import Uvsq21923164.pglp9_9.TableExisteDeja;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Creationdb {

	
	private static final String userName = "";
	private static final String password = "";
	
	public static String dburl = "jdbc:derby:Derby;create=true";
	
	public Creationdb() {
		Properties connectionProps = new Properties();
		connectionProps.put("user", userName);
		connectionProps.put("user", password);
	}
	
	
	public void createTables() throws TableExisteDeja {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			  Statement state = connect.createStatement();
			    DatabaseMetaData databaseMetadata = connect.getMetaData();
			    ResultSet resultCARRE = databaseMetadata.getTables(null, null, "CARRE", null);
			    
			    if (resultCARRE.next()) {
			    	throw new TableExisteDeja("TABLE EXISTE TOUJOURS");
			    } else {
			
			state.addBatch(
					
					
					"CREATE TABLE Carre("
							+ "Namecr varchar(30) primary key,"
			                + "point_x int,"
			                + "point_y int,"
			                + "cote int"
					+ ")");
			
			    }
			    
			    
			    ResultSet resultRectangle = databaseMetadata.getTables(null, null, "RECTANGLE", null);
			    
			    if (resultRectangle.next()) {
			    	throw new TableExisteDeja("TABLE EXISTE TOUJOURS");
			    } else {
			
			state.addBatch(
					
					"CREATE TABLE Rectangle("
							+ "NameRc varchar(30) primary key,"
			                + "point_x int,"
			                + "point_y int,"
			                + "largeur int,"
			                + "longeur int"
				              + ")");
			
			    }
			    
			    
			    ResultSet resultTriangle = databaseMetadata.getTables(null, null, "TRIANGLE", null);
			    
			    if (resultTriangle.next()) {
			    	throw new TableExisteDeja("TABLE EXISTE TOUJOURS");
			    } else {
			
			state.addBatch(
					
					"CREATE TABLE Triangle("
							 + "NameTr varchar(30) primary key,"
				                + "point1_x int,"
				                + "point1_y int,"
				                + "point2_x int,"
				                + "point2_y int,"
				                + "point3_x int,"
				                + "point3_y int"
				           	+ ")");
			
			    }
			    
			    
			    ResultSet resultCercle = databaseMetadata.getTables(null, null, "CERCLE", null);
			    
			    if (resultCercle.next()) {
			    	throw new TableExisteDeja("TABLE EXISTE TOUJOURS");
			    } else {
			
			state.addBatch(
					
					"CREATE TABLE Cercle("
							+ "Namecrl varchar(30) primary key,"
			                + "centre_x int,"
			                + "centre_y int,"
			                + "rayon int"
				           + ")");
			
			    }
			    
			    ResultSet result = databaseMetadata.getTables(null, null, "GROUPE", null);
			    if (result.next()) {
			    	throw new TableExisteDeja("TABLE EXISTE TOUJOURS");
			    } else {			
				state.addBatch("CREATE TABLE groupe ("
						+ "id VARCHAR(100) PRIMARY KEY"
						+ ")");}
			    ResultSet res = databaseMetadata.getTables(null, null, "APPARTENIR", null);
			    if (res.next()) {
			    	throw new TableExisteDeja("TABLE EXISTE TOUJOURS");
			    } else {
				state.addBatch( 
						"CREATE TABLE appartenir("
						+ "id VARCHAR(100),"
						+ "name VARCHAR(100)"
						+ ")");
			    }
			state.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	
		
	}
	
	
	
	
	
	
	
	

