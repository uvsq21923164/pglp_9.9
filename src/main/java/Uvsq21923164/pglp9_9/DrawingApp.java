
package Uvsq21923164.pglp9_9;

import java.io.File;
import java.sql.SQLException;
import java.util.Scanner;



public class DrawingApp {
	
    Scanner scanner;
   
    
    DrawingTUI d;
    public static void main(final String[] args) throws Exception {
	       
        DrawingApp app = new DrawingApp();
        app.run();
    }
	public DrawingApp(){
		d = new DrawingTUI();
        scanner = new Scanner(System.in);
	}
	
	  public void run() throws SQLException {
	        System.out.print(" veuillez Taper Q pour afficher la liste des actions ou quit pour quitter\n>");
	        String cmd = scanner.nextLine();
	        Commande c;
	        while (!cmd.equals("quit")) {
	            c = d.nextCommand(cmd);
	            if (c != null) {
	                c.execute();
	            }
	            d.afficheDraw();
	            cmd = scanner.nextLine();
	           
	        }
	    }


	    
	    
}

