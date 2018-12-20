
public class ConnectFourGameBoardAnalyzer {
	
	private final int nInARow;
	
	public ConnectFourGameBoardAnalyzer(int nInARow) {
		this.nInARow = nInARow;
	}
	
	public Character findNInARowToken(GameBoard board) {
		Character      ch = findNInARowTokenByRow(board);
		if(ch == null) ch = findNInARowTokenByColumn(board);
		if(ch == null) ch = findNInARowTokenByDiagonal1(board);
		if(ch == null) ch = findNInARowTokenByDiagonal2(board);
		return ch;
	}
	
	/*
	 *  This method looks for any token that appears nInARow times consecutively
	 */
	private Character findNInARowTokenByRow(GameBoard board) {
		
		for(int i = 0; i < board.getNumRows(); i++) {
			// current token that I am counting Consecutive occurrences of
			Character currToken = null;
			// the number of consecutive occurrences
			int occurrencesCounter = 0;
			
			// loop over the elements (columns) of that row and update currToken and occurrences
			for(int j = 0; j < board.getNumCols(); j++) {
				// get the token (or empty space) value at the current row and column indices
				char token = board.getValueAt(i, j);
				
				// check if current value (value at row and column) matches the curr token
				if(token != 'X' && currToken != null && token == currToken) {
					// the current token (at row, col) matches the current token,
					//   that I am counting Consecutive occurrences of
					// increment the occurrences counter
					occurrencesCounter ++;
					
					// check if the occurrences counter equals the target nInARow
					if(occurrencesCounter == this.nInARow) { //TODO - Jake fix this condition
						// return the current token
						return currToken;
					}
				} else {
					// the token (at row, col) does not match the current token we are counting occurrences of
					// set the current token to the token, and set the counter back to 1
					currToken = token;
					occurrencesCounter = 1;
				}
				
			}
		}
		return null;
	}
	
	private Character findNInARowTokenByColumn(GameBoard board) {
		for(int i = 0; i < board.getNumCols(); i++) {
			// current token that I am counting Consecutive occurrences of
			Character currToken = null;
			// the number of consecutive occurrences
			int occurrencesCounter = 0;
			
			// loop over the elements (columns) of that row and update currToken and occurrences
			for(int j = 0; j < board.getNumRows(); j++) {
				// get the token (or empty space) value at the current row and column indices
				char token = board.getValueAt(j, i);
				
				// check if current value (value at row and column) matches the curr token
				if(token != 'X' && currToken != null && token == currToken) {
					// the current token (at row, col) matches the current token,
					//   that I am counting Consecutive occurrences of
					// increment the occurrences counter
					occurrencesCounter ++;
					
					// check if the occurrences counter equals the target nInARow
					if(occurrencesCounter == this.nInARow) { //TODO - Jake fix this condition
						// return the current token
						return currToken;
					}
				} else {
					// the token (at row, col) does not match the current token we are counting occurrences of
					// set the current token to the token, and set the counter back to 1
					currToken = token;
					occurrencesCounter = 1;
				}
				
			}
		}
		return null;
	}
	
	private Character findNInARowTokenByDiagonal1(GameBoard board) {
		for(int i = 0; i < board.getNumCols() - nInARow + 1; i++) {
			Character currToken = null;
			int occurrencesCounter = 0;
			int k = i;
			
			for(int j = 0; j < board.getNumRows() && k < board.getNumCols(); j++,k++) {
				char token = board.getValueAt(j, k);
				
				if(token != 'X' && currToken != null && token == currToken) {
					// the current token (at row, col) matches the current token,
					//   that I am counting Consecutive occurrences of
					// increment the occurrences counter
					occurrencesCounter ++;
					
					// check if the occurrences counter equals the target nInARow
					if(occurrencesCounter == this.nInARow) { //TODO - Jake fix this condition
						// return the current token
						return currToken;
					}
				} else {
					// the token (at row, col) does not match the current token we are counting occurrences of
					// set the current token to the token, and set the counter back to 1
					currToken = token;
					occurrencesCounter = 1;
				}
			
			}
		}
		
		for(int i = 1; i < board.getNumRows() - nInARow + 1; i++) {
			Character currToken = null;
			int occurrencesCounter = 0;
			int k = i;
			
			for(int j = 0; j < board.getNumCols() && k < board.getNumRows(); j++,k++) {
				char token = board.getValueAt(k, j);
				
				if(token != 'X' && currToken != null && token == currToken) {
					// the current token (at row, col) matches the current token,
					//   that I am counting Consecutive occurrences of
					// increment the occurrences counter
					occurrencesCounter ++;
					
					// check if the occurrences counter equals the target nInARow
					if(occurrencesCounter == this.nInARow) { //TODO - Jake fix this condition
						// return the current token
						return currToken;
					}
				} else {
					// the token (at row, col) does not match the current token we are counting occurrences of
					// set the current token to the token, and set the counter back to 1
					currToken = token;
					occurrencesCounter = 1;
				}
			
			}
		}
		
		return null;
	}
	
	private Character findNInARowTokenByDiagonal2(GameBoard board) {
		for(int i = board.getNumCols() - 1; i > nInARow - 1; i--) {
			Character currToken = null;
			int occurrencesCounter = 0;
			int k = i;
			
			for(int j = 0; j < board.getNumRows() && k >= 0; j++,k--) {
				char token = board.getValueAt(j, k);
				
				if(token != 'X' && currToken != null && token == currToken) {
					// the current token (at row, col) matches the current token,
					//   that I am counting Consecutive occurrences of
					// increment the occurrences counter
					occurrencesCounter ++;
					
					// check if the occurrences counter equals the target nInARow
					if(occurrencesCounter == this.nInARow) { //TODO - Jake fix this condition
						// return the current token
						return currToken;
					}
				} else {
					// the token (at row, col) does not match the current token we are counting occurrences of
					// set the current token to the token, and set the counter back to 1
					currToken = token;
					occurrencesCounter = 1;
				}
			
			}
		}
		
		for(int i = 1; i < board.getNumRows() - nInARow + 1; i++) {
			Character currToken = null;
			int occurrencesCounter = 0;
			int k = i;
			
			for(int j = board.getNumCols() - 1; j >= 0 && k < board.getNumRows(); j--,k++) {
				char token = board.getValueAt(k, j);
				
				if(token != 'X' && currToken != null && token == currToken) {
					// the current token (at = 0 row, col) matches the current token,
					//   that I am counting Consecutive occurrences of
					// increment the occurrences counter
					occurrencesCounter ++;
					
					// check if the occurrences counter equals the target nInARow
					if(occurrencesCounter == this.nInARow) { //TODO - Jake fix this condition
						// return the current token
						return currToken;
					}
				} else {
					// the token (at row, col) does not match the current token we are counting occurrences of
					// set the current token to the token, and set the counter back to 1
					currToken = token;
					occurrencesCounter = 1;
				}
			
			}
		}
		
		return null;
	}
}
