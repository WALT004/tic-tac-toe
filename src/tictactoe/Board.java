package tictactoe;

public class Board {
	
	private char[][] board;
	private int boardSize;
	
    public Board(int boardSize) {
    	this.boardSize = boardSize;
    	board = new char[boardSize][boardSize];
    	for (int i = 0; i < boardSize ; i++) {
    		for (int j = 0; j < boardSize ; j++) {
    			//board[i][j];
    		}
    	}
	}

	public boolean finished() {
        return true;
    }

    public boolean isValidMove(Move move) {
        return true;
    }

    public void setMove(Move move) {
    }
}
