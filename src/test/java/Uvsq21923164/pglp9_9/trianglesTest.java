package Uvsq21923164.pglp9_9;

import static org.junit.Assert.*;

import org.junit.Test;

public class trianglesTest {

	@Test
	public void test() {
		triangles tr= new  triangles( "omar",new Point(0,1), new Point(2,3), new Point(4,5) );
		tr.deplacer("omar",6,7);
		assertEquals(tr.getPoint1().getX(),6);
		assertEquals(tr.getPoint1().getY(),8);
		
		assertEquals(tr.getPoint2().getX(),8);
		assertEquals(tr.getPoint2().getY(),10);
		
		assertEquals(tr.getPoint3().getX(),10);
		assertEquals(tr.getPoint3().getY(),12);
	
}
}