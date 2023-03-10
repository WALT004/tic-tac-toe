package tictactoe;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Visualiser {

    private final Map<BoardElement, String> tiles;

    public Visualiser(){
        tiles = new HashMap<>();
        tiles.put(BoardElement.EMPTY, " ");
        tiles.put(BoardElement.TIC, "X");
        tiles.put(BoardElement.TAC, "O");
    }

    public void draw(Board board) {
        int columnWidth = Integer.toString(board.getBoardSize()).length() + 1;
        printHeader(board, columnWidth);
        IntStream.range(1, board.getBoardSize()).forEach(idx -> StringUtils.leftPad(Integer.toString(idx), columnWidth));

        IntStream.range(1, board.getBoardSize()).forEach(idx -> printRow(idx, board.getBoard()[idx], columnWidth));

        System.out.println(tiles.get(board.getLastMove().getPlayer().getNextPlayer().getBoardElement()) + " player please input your next step (X,Y)");
    }

    private static void printHeader(Board board, int columnWidth) {
        System.out.print(StringUtils.leftPad("", columnWidth));
        IntStream.range(1, board.getBoardSize()).forEach(idx -> StringUtils.leftPad(Integer.toString(idx), columnWidth));
        System.out.println();
    }

    private void printRow(int index, BoardElement[] row, int columnWidth){
        System.out.print(StringUtils.leftPad(Integer.toString(index), columnWidth));
        Arrays.stream(row).forEach(element -> StringUtils.leftPad(tiles.get(element), columnWidth));
        System.out.println();
    }

    public void invalidMoveMessage(Move move) {
        System.out.printf("X: %d, Y: %d is not a valid move%n", move.getRow(), move.getColumn());
    }
}
