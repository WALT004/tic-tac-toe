package tictactoe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Board {
	
	private BoardElement[][] board;
	private int boardSize;

	private int winSize = 3;

	private Move lastMove;
	
    public Board(int boardSize) {
		if (boardSize < 3) {
			throw new IllegalArgumentException("The table should be at least 3x3");
		}
    	this.boardSize = boardSize;
    	board = new BoardElement[boardSize][boardSize];
    	for (int i = 0; i < boardSize ; i++) {
    		for (int j = 0; j < boardSize ; j++) {
    			board[i][j] = BoardElement.EMPTY;
    		}
    	}
	}

	public Board() {
		this(3);
	}

	public boolean finished() {
		if (Objects.isNull(lastMove)) {
			return false;
		}
		return true; //TODO implement
	}

    private boolean isValidMove(Move move) {
		if (isCoordinateOffBoard(move.getColumn()) && isCoordinateOffBoard(move.getRow())) {
			return false;
		}
		return isFieldEmpty(move);
    }

	public boolean setMove(Move move) {
		if (!isValidMove(move)) {
			return false;
		}
		board[move.getRow()][move.getColumn()] = move.getPlayer().getBoardElement();
		lastMove = move;
		return true;
    }

	private boolean isFieldEmpty(Move move) {
		return board[move.getRow()][move.getColumn()] == BoardElement.EMPTY;
	}

	private boolean isCoordinateOffBoard(int coordinate) {
		return coordinate < 0 || coordinate >= boardSize;
	}
}
