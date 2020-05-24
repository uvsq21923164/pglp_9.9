package Uvsq21923164.pglp9_9;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<T> {
 T create(T object) throws SQLException;
	   
     T find(String id) throws SQLException;
       
    T update(T object);
   
    void delete(T object) throws SQLException;
    
    public abstract ArrayList<T> show();
}
	
	
	
	

