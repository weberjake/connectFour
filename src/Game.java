
public class Game {
	// Instance variables
	private final int numRows, numCols, nInARow;
	private final Console console;
	private final KeyboardInput keyboardInput;
	private final ConnectFourGameBoardAnalyzer analyzer;
	
	public Game(int numRows, int numCols, int nInARow) {
		this.numRows = numRows;
		this.numCols = numCols;
		this.nInARow = nInARow;
		this.console = new Console();
		this.keyboardInput = new KeyboardInput();
		this.analyzer = new ConnectFourGameBoardAnalyzer(nInARow);
	}
	
	public void run() {
		// First create the game board
		GameBoard board = new GameBoard(numRows, numCols);
		
		// Next create two players
		this.console.print("Enter Player One's name: ");
		String player1Name = this.keyboardInput.nextLine();
		Player player1 = new Player(player1Name.trim());
		this.console.print("Enter Player Two's name: ");
		String player2Name = this.keyboardInput.nextLine();
		Player player2 = new Player(player2Name.trim());
		
		// Create a player array
		Player players[] = new Player[2];
		players[0] = player1;
		players[1] = player2;
		
		char playerPiece[] = new char[2];
		playerPiece[0] = 'R';
		playerPiece[1] = 'B';
		
		// Print a welcome message for each of the players
		console.println("Welcome " + player1.getName() + " - you are player 1");
		console.println("Welcome " + player2.getName() + " - you are player 2");
		
		// Now run the game, loop over the player turns
		int turn = 0;
		int winningPlayer = -1;
		while(board.isInPlay()) {
			// Print out the turn and the board
			int playerNum = turn%2;
			this.console.print("Round " + ((turn/2)+1) + " ");
			this.console.println("Player" + ((playerNum)+1) + "'s turn");
			board.printGameBoard(this.console);

			// get the player's choice
			while(true) {
				this.console.print(players[playerNum].getName() + " choose a column: ");
				String input = this.keyboardInput.nextLine();
				
				// get the column from the user input
				int userChoice = -1;
				
				boolean keepTrying = true;
				while(keepTrying) {
					try {
						userChoice = Integer.parseInt(input);
						if(userChoice < 1 || userChoice > this.numCols) {
							throw new IllegalArgumentException();
						}
						if(board.isColumnFull(userChoice)) {
							this.console.print("Sorry, that column is full. ");
							throw new Exception();
						}
						keepTrying = false;
					}
					catch(Exception e) {
						this.console.print("Please enter a number in the range of  1 to " + this.numCols + ": ");
						input = this.keyboardInput.nextLine();
					}
				}
				
				// try the player's move
				boolean isOk = board.addPiece(playerPiece[playerNum], userChoice);
				if(isOk) {break;}
				this.console.println("Invalid move");
			}
			// check if the game is over
			Character winnerToken = analyzer.findNInARowToken(board);
			if(winnerToken != null) {
				// yay somebody won the game
				board.printGameBoard(this.console);
				String winningPlayerName = "Placeholder";
				if(playerPiece[playerNum] == 'R') winningPlayerName = player1Name;
				if(playerPiece[playerNum] == 'B') winningPlayerName = player2Name;
				System.out.println(winningPlayerName + " has won the game.");
				
				assert(winnerToken == playerPiece[playerNum]) 
				: "Winner Token mismatch (winner='" + winnerToken + "', player= '" + playerPiece[playerNum] + "')";
				winningPlayer = playerNum;
				
				break;
			}
			
			turn++;
		}
		
		// print a congrats msg and the winning gameboard
		// weberjake@gmail.com
	}
	
	public static String credits() {
		return "Connect Four by Jake W.";
	}
}
