
public class GameBoard {
	/*
	 *     |X X X X X X X|
	 *     |X X X X X X X|
	 *     |X X X X X X X|
	 *     |X X X X X X X|
	 *     |X X X X X X X|
	 *     |X R X B X X X|
	 * 
	 */
	
	private final char board[][];

	public GameBoard(int numRows, int numCols) {
		this.board = new char[numRows][numCols];
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				board[i][j] = 'X';
			}
		}
	}
	
	public boolean isInPlay() {
		return true;
	}

	
	public void printGameBoard(Console console) {
		console.println("Gameboard: ");
		for(int i = 0; i < this.board.length; i++) { // row
			console.print('|');
			for(int j = 0; j < this.board[i].length; j++) {  //col
				if(j > 0) console.print(' ');
				console.print(board[i][j]);
			}
			console.println('|');
		}
	}
	
	public boolean addPiece(char piece, int column) {
		// Check that the column is in range
		if (column < 1 || column > this.board[0].length) {
			return false;
		}
		
		// Check the column is not full
		if (this.board[0][column-1] != 'X') {
			return false;
		}
		
		int rowToPlacePiece = 0;
		
		for(int i = 1; i < this.board.length && this.board[i][column-1]=='X'; i++) {
			rowToPlacePiece++;
		}
		
		this.board[rowToPlacePiece][column-1]=piece;
		
		return true;
	}
	
	public int getNumRows() {
		return this.board.length;
	}	
	
	public int getNumCols() {
		return this.board[0].length;
	}	
	
	public char getValueAt(int row, int column) {
		// assert that row and col are in range
		assert(row>=0 && row < this.board.length) : "row = " + row + " out of range [0, " + this.board.length + ")";
		assert(column>=0 && column < this.board[0].length) : "col = " + column + " out of range [0, " + this.board[0].length + ")";
		return this.board[row][column];
	}
	
	public boolean isColumnFull(int column) {
		return (this.board[0][column-1] != 'X');
	}
		
	
}
