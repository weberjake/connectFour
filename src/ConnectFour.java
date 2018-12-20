public class ConnectFour {
	
	// instance variables (member variables, properties)

	/**
	 *  Program entry point for the Connect Four game
	 */
	public static void main(String args[]) {
		// lhs = rhs
		// lhs (left hand side)  - define a variable <Type> <name>
		// rhs (right hand side) - define a value any valid expression "that evaluates to a result"
		// special type of expression that creates an Object (instance of a class type),
		//   and return the reference  to that object as a value
		//   new <constructor>(<arg list>)
		
	
		// System.out.println("args = " + Arrays.toString(args));
		if(args.length < 3) {
			usage();
			System.exit(1);
		}
		
		int nRows = Integer.parseInt(args[0]);
		int nCols = Integer.parseInt(args[1]);
		int nInARow = Integer.parseInt(args[2]);
		
		// Print game credits
		System.out.println(Game.credits());
		
		// Now create a game
		Game game = new Game(nRows, nCols, nInARow);
		
		// Now start game
		game.run();
	}
	
	private static void usage() {
		System.out.println("Usage: ConnectFour <nRows> <nCols> <nInARow>");
	}
}

