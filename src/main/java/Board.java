import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

public class Board {

	Set<Cell> cells = Sets.newHashSet();

	public void add(int x, int y) {
		Cell c = new Cell(x, y);
		cells.add(c);
	}

	public void remove(int x, int y) {
		cells.remove(new Cell(x, y));
	}

	public boolean get(int x, int y) {
		Cell c = new Cell(x, y);
		return cells.contains(c);
	}

	public Zone getZone() {
		Zone z = new Zone();
		for (Cell cell : cells) {
			z.add(cell);
		}
		return z;
	}
}
