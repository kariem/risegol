import static org.junit.Assert.*;

import org.junit.Test;


public class BoardImplTest {

	
	@Test
	public void testCountingNeighbours() {
		BoardImpl board = new BoardImpl(new StandardRule());
		board.set(new boolean[2][2]);
		boolean[][] nextRound = board.tick();

		assertFalse(nextRound[0][0]);
		assertFalse(nextRound[0][1]);
		assertFalse(nextRound[1][0]);
		assertFalse(nextRound[1][1]);
	}
}
