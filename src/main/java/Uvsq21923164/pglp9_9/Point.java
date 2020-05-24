package Uvsq21923164.pglp9_9;

import java.io.CharConversionException;

public class Point {
	 public int x, y;

	    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

		public Point(int x, int y) {

	        this.x = x;

	        this.y = y;

	    }

	    public Point(String p) throws CharConversionException {
			// TODO Auto-generated constructor stub
	    	 p.replace(" ", "");
		        if (p.charAt(0) != '('
		                || p.charAt(p.length() - 1) != ')') {
		                    System.err.println(p);
		                    throw new CharConversionException();
		                }
		                String pos2 = p.substring(1, p.length() - 1);
		                String[] positionSplit = pos2.split(",");
		                if (positionSplit.length != 2) {
		                    System.err.println(p);
		                    throw new CharConversionException();
		                }
		                try {
		                    x = Integer.parseInt(positionSplit[0]);
		                    y = Integer.parseInt(positionSplit[1]);
		                } catch (NumberFormatException e) {
		                    System.err.println("Caractère inconnu "
		                            + "lors de la conversion des nombres.");
		                    throw e;
		                }
		}

		public void move(int dx, int dy) {

	        x += dx;

	        y += dy;

	    }

	    public String toString() {

	        return "Point de coordonnees : " + x + ", " + y;

	    }
	    public Point copie() {
	    	return new Point(x,y);
	    }
	
	
}
