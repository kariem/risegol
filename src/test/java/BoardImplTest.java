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
	@Test
	public void testStillBlock() {
		BoardImpl board = new BoardImpl(new StandardRule());
		boolean[][] states = new boolean[2][2];
		states[0][0]=true;
		states[0][1]=true;
		states[1][0]=true;
		states[1][1]=true;
		board.set(states);
		boolean[][] nextRound = board.tick();

		assertTrue(nextRound[0][0]);
		assertTrue(nextRound[0][1]);
		assertTrue(nextRound[1][0]);
		assertTrue(nextRound[1][1]);
	}

	@Test
	public void testOscillatingBlinker() {
		BoardImpl board = new BoardImpl(new StandardRule());
		boolean[][] states = new boolean[5][5];
		states[1][2] = true;
		states[2][2] = true;
		states[3][2] = true;
		board.set(states);
		boolean[][] nextRound = board.tick();

		assertTrue(nextRound[2][2]);
		assertTrue(nextRound[2][1]);
		assertTrue(nextRound[2][3]);
		assertFalse(nextRound[1][2]);
		assertFalse(nextRound[3][2]);
	}
}
