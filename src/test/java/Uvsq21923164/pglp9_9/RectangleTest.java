package Uvsq21923164.pglp9_9;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTest {

	@Test
	public void test() {
		Rectangle c1 = new Rectangle ("youcef",new Point(3,2),2,5);
		c1.move("youcef",2, 2);
		assertEquals(c1.getPoint().getX(),5);
		assertEquals(c1.getPoint().getY(),4);
		c1.move("youcef", 1, 8);
		assertEquals(c1.getPoint().getX(),6);
		assertEquals(c1.getPoint().getY(),12);
	}
}
