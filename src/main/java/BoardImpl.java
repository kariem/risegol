class BoardImpl implements Board {
	
//	private Rule rule;

	private boolean[][] states;

	public void set(boolean[][] states) {
		this.states = states;
		
	}
	
	public boolean[][] tick() {
		boolean [][] next = createEmptyState();
		for(int line =0; line < states.length; line++ ) {
			for(int row=0; row< states[line].length; row++ ) {
				int neighbours= countNeighbours(line,row);
//				Rule.calulate()
			}			
		}
		return states;
	}

	private boolean[][] createEmptyState() {
		return new boolean[states.length][states[0].length];
	}

	private int countNeighbours(int line, int row) {
		return 0;
	}
}
