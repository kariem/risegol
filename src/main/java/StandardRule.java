public class StandardRule implements Rule {
	public boolean calculate(boolean alive, int livingNeighbors) {
		if (alive) {
			return livingNeighbors >= 2 && livingNeighbors <= 3;
		} else {
			return livingNeighbors == 3;
		}
	}
}
