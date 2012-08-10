import com.google.common.collect.Sets;

import java.util.Set;

public class Zone {


	private Set<Cell> alive;
	private Set<Cell> dead;

	public Zone() {
		alive = Sets.newHashSet();
		dead = Sets.newHashSet();
	}


	public void add(Cell cell) {
		addAlive(cell);
		for (int x = cell.getX() - 1; x <= cell.getX() + 1; x++) {
			for (int y = cell.getY() - 1 ; y <= cell.getY() +  1; y++) {
				addDead(x, y);
			}
		}
	}

	private void addDead(int x, int y) {
		Cell cell = new Cell(x, y);
		if (!alive.contains(cell)) {
			dead.add(cell);
		}
	}

	private void addAlive(Cell cell) {
		alive.add(cell);
		dead.remove(cell);
	}

	public int size() {
		return dead.size() + alive.size();
	}

	public Iterable<? extends Cell> iterLiving() {
		alive.iterator();
	}

	public Iterable<? extends Cell> iterDead() {
		dead.iterator();
	}

	public int getLivingNeighbors(Cell cell) {
		int res = -1;
		for (int x = cell.getX() - 1; x <= cell.getX() + 1; x++) {
			for (int y = cell.getY() - 1 ; y <= cell.getY() +  1; y++) {
				if (alive.contains(new Cell(x,y))) {
					res++;
				}
			}
		}
	}
}
