package Uvsq21923164.pglp9_9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DrawingTUI {
	final int trois = 3, quatre = 4, cinq = 5, six=6;
	/**
	 * interpretation de la commande de creation du cercle
	
	 */
    private Forme createCercle( final String variable, final String[] split2){
	
     String[] split = split2[1].split("Cercle");
     if (!split[0].equals("")
             || !(split[1].startsWith("(") && split[1].endsWith(")"))) {
         System.err.println("Commande incorrcet,il manque les parenthese ");
     } else {
         split[1] = split[1].substring(1, split[1].length() - 1);
         split = split[1].split(",");
         if (split.length != trois) {
             System.err.println("Commande inccorecte, "
                     + split.length + "/" + trois + " arguments");
         } else {
             Point centre;
             int rayon;
             try {
                 centre = new Point(split[0] + "," + split[1]);
                 rayon = Integer.parseInt(split[2]);
                 return new Cercle(variable, centre, rayon);
             } catch (Exception e) {
                 System.err.println("impossible de crée la forme");
             }
         }
     }
     return null;
   }

     /**
     * interpretation de la commande de creation du carre
     */
     private Forme createCarre(  final String variable, final String[] split2){
	
    String[] split = split2[1].split("Carre");
    if (!split[0].equals("")
            || !(split[1].startsWith("(") && split[1].endsWith(")"))) {
        System.err.println("Commande incorrcet,il manque les parenthese ");
    } else {
        split[1] = split[1].substring(1, split[1].length() - 1);
        split = split[1].split(",");
        if (split.length != trois) {
            System.err.println("Commande inccorrect, "
                    + split.length + "/" + trois + " arguments");
        } else {
            Point point;
            int cote;
            try {
                point = new Point(split[0] + "," + split[1]);
                cote = Integer.parseInt(split[2]);
                return new Carre(variable, point, cote);
            } catch (Exception e) {
                System.err.println( "impossible de creer la forme");
            }
        }
    }
    return null;
  }

    /**
    * interpretation de la commande de creation du rectangle
    */
    private Forme createRectangle(final String variable, final String[] split2){
	
    String[] split = split2[1].split("Rectangle");
    if (!split[0].equals("")
            || !(split[1].startsWith("(") && split[1].endsWith(")"))) {
        System.err.println("Commande incorrcet,il manque les parenthese ");
    } else {
        split[1] = split[1].substring(1, split[1].length() - 1);
        split = split[1].split(",");
        if (split.length != quatre) {
            System.err.println("Commande inccorrect, "
                    + split.length + "/" + quatre + " arguments");
        } else {
        	Point point;
            int longeur;
            int largeur;
            try {
                final int trois = 3;
                point = new Point(split[0] + "," + split[1]);
                longeur = Integer.parseInt(split[2]);
                largeur = Integer.parseInt(split[trois]);
                return new Rectangle(
                        variable, point, longeur, largeur);
            } catch (Exception e) {
                System.err.println("impossible de creer la forme");
            }
        }
    }
    return null;
  }
	/**
	 * interpretation dela commande de creation du triangle
	
	 */
     private Forme createTriangle(final String variable, final String[] split2){
	
    String[]  split = split2[1].split("Triangle");
    if (!split[0].equals("")
            || !(split[1].startsWith("(") && split[1].endsWith(")"))) {
        System.err.println("Commande incorrcet,il manque les parenthese");
    } else {
        split[1] = split[1].substring(1, split[1].length() - 1);
        split = split[1].split(",");
        if (split.length != six) {
            System.err.println("Commande inccorrect, "
        + split.length + "/" + six + " arguments");
        }
        Point[] point = {null, null, null};
        try {
            
            point[0] = new Point(split[0] + "," + split[1]);
            point[1] = new Point(split[2] + "," + split[trois]);
            point[2] = new Point(split[quatre] + "," + split[cinq]);
            return new triangles(variable, point[0], point[1], point[2]);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("impossible de creer la forme");
        }
    }
    return null;
  }
   
   /**
   * interpretation de la commande groupe
   
   */
   private Forme createGroupe(final String variable, final String[] split2) throws SQLException{
	String[] split = split2[1].split("Groupe");
    if (!split[0].equals("")
            || !(split[1].startsWith("(") && split[1].endsWith(")"))) {
        System.err.println("Commande incorrcet,il manque les parenthese");
    } else {
        split[1] = split[1].substring(1, split[1].length() - 1);
        split = split[1].split(",");
        return createGroupeComposants(variable, split);
    }
    return null;
  }

   /**
   * interpretation de la commande pour la creation d'une partie composante
   */
   private Forme createGroupeComposants(String variable, String[] split) throws SQLException {
    FormeGroupe gf = new FormeGroupe(variable);
    for (String s : split) {
        Forme f = this.getForme(s);
        if (f != null) {
            gf.ajouterForme(f);
        } else {
            return null;
        }
    }
    return gf;
  }

  
   private Forme getForme(final String var) throws SQLException {
	 DaoFactory factory = new DaoFactory();
     DAO<Cercle> cercle = factory.getCercleDAO();
     DAO<Carre> carre = factory.getCarreDAO();
     DAO<Rectangle> rectangle = factory.getRectangleDAO();
     DAO<triangles> triangle = factory.gettrianglesDAO();
     DAO<FormeGroupe> grp = factory.getFormegroupeDAO();
     Forme f = cercle.find(var);
     if (f == null) {
         f = carre.find(var);
     }
     if (f == null) {
         f = rectangle.find(var);
     }
     if (f == null) {
         f = triangle.find(var);
     }
     if (f == null) {
         f = grp.find(var);
     }
     if (f == null) {
         System.err.println("Aucune forme n'existe a ce nom : "+ var);
     }
     factory.close();
     return f;
  }
   
   /**
   * interpretation de la commande de creation de la forme
   
   */
   private Forme create(final String cmd2) throws SQLException{
	String[] split;
    split = cmd2.split("=");
    split[0] = split[0].trim();
    String var = split[0];
    if (split[0].contains(" ")) {
        System.out.println("Le nom de la variable contient des espaces");
    } else {
        split[1] = split[1].replace(" ", "");
        Forme forme = null;
        if (split[1].contains("Cercle")) {
        	forme = this.createCercle(var, split);
        } else if (split[1].contains("Carre")) {
            forme = this.createCarre(var, split);
        } else if (split[1].contains("Rectangle")) {
            forme = this.createRectangle(var, split);
        } else if (split[1].contains("Triangle")) {
            forme = this.createTriangle(var, split);
        } else if (split[1].contains("Groupe")) {
            forme = this.createGroupe(var, split);
        }
        return forme;
    }
    return null;
  }
   
  /**
   * interpretation de la commande de deplacement la forme
   
   */
   private Commande move(final String cmd2){
	final int trois = 3;
    String cmd = cmd2.replace(" ", "");
    String[] split = cmd.split("move");
    if (!split[0].equals("")
            || !(split[1].startsWith("(") && split[1].endsWith(")"))) {
        System.err.println("Commande invalide, parentheses manquantes");
    } else {
        split[1] = split[1].substring(1, split[1].length() - 1);
        split = split[1].split(",");
        if (split.length != trois) {
            System.err.println("Commande invalide, "
                    + split.length + "/" + trois + " arguments");
        } else {
            String variable;
            Point deplacement;
            try {
                variable = split[0];
                deplacement = new Point(split[1] + "," + split[2]);
                Forme f = this.getForme(variable);
                if (f != null) {
                    return new DeplacementCommand(f, deplacement);
                }
            } catch (Exception e) {
                System.err.println("Commande invalide");
                e.printStackTrace();
            }
        }
    }
    return null;
  }
   
    /**
    * interpretation de la commande de suppression la forme
   
    */
    private Commande remove(final String cmd2) throws SQLException {
    String cmd = cmd2.replace(" ", "");
    String[] split = cmd.split("delete");
    if (!split[0].equals("")
            || !(split[1].startsWith("(") && split[1].endsWith(")"))) {
        System.err.println("Commande invalide, parentheses manquantes");
    } else {
        split[1] = split[1].substring(1, split[1].length() - 1);
        split = split[1].split(",");
        ArrayList<Forme> list = new ArrayList<Forme>();
        for (String var : split) {
            Forme forme = this.getForme(var);
            if (forme != null) {
                list.add(forme);
            } else {
                System.err.println("Commande invalide, forme inconnu");
                return null;
            }
        }
        return new SuppressionCommand(list);
    }
    return null;
  }	

   /**
   * interpretation d'une commande
   
   */
   public Commande nextCommand(final String command) throws SQLException {
    if (command.contains("=")) {
        Forme f = this.create(command);
        if (f != null) {
            return new CreationCommande(f);
        }
    } else if (command.contains("move")) {
        return this.move(command);
    } else if (command.contains("delete")) {
        return this.remove(command);
    } else if (command.equals("Q")) {
        System.out.println("Liste des actions: \n"
        		+ " Carre :forme = Carre((x,y), cote)\n"
                + " Cercle:forme = Cercle((x,y), rayon)\n"
                + " Rectangle :forme = Rectangle((x,y), longueur, largeur)\n"
                + " Triangle :forme = Triangle((x,y), (x,y), (x,y))\n"
                + " Groupe de formes :forme = Groupe(forme, ...)\n"
                + "\n"
                + " deplacer une forme ou un groupe :		"
                + "  move(forme, (x,y))\n"
                + " supprimer une forme ou un groupe :		"
                + " delete(forme, ...)"
                +"\n\n\n       veuillez respecter la synatx pour faire une execution :   \n");
    } else if (!command.equalsIgnoreCase("quit")) {
        System.err.println("Commande non reconnue");
    }
    return null;
    }

   

  /**
   * affichage des formes
   */
   public  void afficheDraw() {
    DaoFactory factory = new DaoFactory();
    DAO<Cercle> cercle = factory.getCercleDAO();
    DAO<Rectangle> rectangle = factory.getRectangleDAO();
    DAO<triangles> triangle = factory.gettrianglesDAO();
    DAO<Carre> carre = factory.getCarreDAO();
    DAO<FormeGroupe> groupe = factory.getFormegroupeDAO();
    ArrayList<Forme> formes = new ArrayList<Forme>();
    formes.addAll(cercle.show());
    formes.addAll(rectangle.show());
    formes.addAll(triangle.show());
    formes.addAll(carre.show());
    formes.addAll(groupe.show());
    for (Forme forme : formes) {
    	
     
            forme.affiche();
        
    }
    factory.close();
}
}