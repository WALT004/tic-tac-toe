package tictactoe;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Board {
	
	private BoardElement[][] board;
	private int boardSize;

	private int winSize = 3;

	private Move lastMove;

	private Map<BoardElement, String> winPattern = new HashMap<>();
	
    public Board(int boardSize) {
		this.boardSize = boardSize;
	    validateSize();
	    initBoard();
	    initPattern(BoardElement.TIC);
	    initPattern(BoardElement.TAC);
	}

	private void validateSize() {
		if (boardSize < 3) {
			throw new IllegalArgumentException("The table should be at least 3x3");
		}
	}

	private void initBoard() {
		board = new BoardElement[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				board[i][j] = BoardElement.EMPTY;
			}
		}
	}

	private void initPattern(BoardElement element) {
		StringBuilder pattern = new StringBuilder();
		for(int i= 0; i< winSize; i++){
			pattern.append(element.name());
		}
		winPattern.put(element, pattern.toString());
	}

	public Board() {
		this(3);
	}

	public boolean finished() {
		if (Objects.isNull(lastMove)) {
			return false;
		}
		return checkVerticallyFromLastMove() ||
		checkHorizontallyFromLastMove() ||
		checkLeftDiagonalFromLastMove() ||
		checkRightDiagonalFromLastMove();
	}

	private boolean checkRightDiagonalFromLastMove() {
		int rangeStartX = lastMove.getRow()-(winSize-1);
		int rangeStartY = lastMove.getColumn()-(winSize-1);
		if(rangeStartX < 0 || rangeStartY < 0) {
			int correction = Math.abs(Math.min(rangeStartX,rangeStartY));
			rangeStartX += correction;
			rangeStartY += correction;
		}
		int rangeEndX = lastMove.getRow() + (winSize-1);
		int rangeEndY = lastMove.getColumn() + (winSize-1);
		if(rangeEndX > boardSize-1 || rangeEndY > boardSize -1) {
			int correction = Math.max(rangeEndX,rangeEndY)-boardSize-1;
			rangeEndX -= correction;
			rangeEndY -= correction;
		}

		StringBuilder lineElements = new StringBuilder();

		for(int i = rangeStartX,j = rangeStartY; i<= rangeEndX || j <= rangeEndY; i++,j++) {
			lineElements.append(board[i][j].name());
		}

		return lineElements.toString().contains(getBoardElementFromLastMove());
	}

	private boolean checkLeftDiagonalFromLastMove() {
		return false;//Todo
	}

	private boolean checkHorizontallyFromLastMove() {
		int rangeStart = Math.max(lastMove.getRow() - (winSize-1), 0);
		int rangeEnd = Math.min(lastMove.getRow() + (winSize-1), boardSize -1);
		StringBuilder lineElements = new StringBuilder();

		for(int i= rangeStart; i<= rangeEnd; i++){
			lineElements.append(board[i][lastMove.getColumn()].name());
		}

		return lineElements.toString().contains(getBoardElementFromLastMove());
	}

	private boolean checkVerticallyFromLastMove() {
		int rangeStart = Math.max(lastMove.getColumn() - (winSize-1), 0);
		int rangeEnd = Math.min(lastMove.getColumn() + (winSize-1), boardSize -1);
		StringBuilder lineElements = new StringBuilder();

		for(int i= rangeStart; i<= rangeEnd; i++){
			lineElements.append(board[lastMove.getRow()][i].name());
		}

		return lineElements.toString().contains(getBoardElementFromLastMove());
	}

	private String getBoardElementFromLastMove() {
		return winPattern.get(lastMove.getPlayer().getBoardElement());
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
