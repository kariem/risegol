import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {

	@Test
	public void testInit() {
		int x = 5;
		int y = 15;
		Cell c = new Cell(x, y);

		assertEquals(x, c.getX());
		assertEquals(y, c.getY());
	}
}
