import com.google.common.collect.Sets;
import org.junit.Rule;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CellTest {

	@Test
	public void testInit() {
		int x = 5;
		int y = 15;
		Cell c = new Cell(x, y);

		assertEquals(x, c.getX());
		assertEquals(y, c.getY());
	}

	@Test
	public void getState() throws Exception {
		Board b = new Board();
		b.add(4, 5);

		assertTrue(b.get(4, 5));
	}

	@Test
	public void testAddTwice() {
		Board b = new Board();
		b.add(4, 5);
		b.add(4, 5);

		b.remove(4, 5);

		assertFalse(b.get(4, 5));
	}

	@Test
	public void testZone() {
		Board b = new Board();
		b.add(4, 5);
		b.add(4, 9);
		Zone zone = b.getZone();
		assertEquals(18, zone.size());
	}

	@Test
	public void testZoneOverlapping() {
		Board b = new Board();
		b.add(4, 5);
		b.add(4, 6);
		b.add(5, 5);
		b.add(5, 6);
		Zone zone = b.getZone();
		assertEquals(16, zone.size());
	}

	public void applyRule() {

		Board b = new Board();
		b.add(4, 5);
		b.add(4, 6);
		b.add(5, 5);
		b.add(5, 6);
		Zone zone = b.getZone();

		Set<Cell> livingNextRound = new Rule() {
			public void apply(Zone z) {
				Set<Cell> result = Sets.newHashSet();
				for (Cell c : z.iterLiving()) {
					int living = z.getLivingNeighbors(c);
					if (living >= 2 && living <= 3) {
						result.add(c);
					}
				}
				for (Cell c : z.iterDead()) {
					int living = z.getLivingNeighbors(c);
					if (living == 3) {
						result.add(c);
					}
				}
			}
		}).apply(zone);
	}


}
