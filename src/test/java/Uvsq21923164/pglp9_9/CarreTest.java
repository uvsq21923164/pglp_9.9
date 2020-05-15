package Uvsq21923164.pglp9_9;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarreTest {


	@Test
	public void test() {
		Carre c1 = new Carre ("youyoyu",new Point(2,2), 5);
		c1.move("youyou", 2, 1);
		assertEquals(c1.getPoint().getX(),4);
		assertEquals(c1.getPoint().getY(),3);
		c1.move("youyou", 3, 6);
		assertEquals(c1.getPoint().getX(),7);
		assertEquals(c1.getPoint().getY(),9);
	}

}
