package Uvsq21923164.pglp9_9;

import static org.junit.Assert.*;

import org.junit.Test;

public class CercleTest {

	@Test
	public void test() {
		Cercle c1 = new Cercle ("youyou",new Point(2,3), 4);
		c1.move("youyou", 5, 2);
		assertEquals(c1.getCentre().getX(),7);
		assertEquals(c1.getCentre().getY(),5);
		c1.move("youyou", 2, 2);
		assertEquals(c1.getCentre().getX(),9);
		assertEquals(c1.getCentre().getY(),7);
	
}
}