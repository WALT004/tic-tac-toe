package tictactoe;

public class TicTacToe {

    private Player player1;
    private Player player2;
    private Input input;
    private Board board;
    private Visualiser visualiser;
    private int boardSize = 3;

    public TicTacToe() {
        input = new Input();
        visualiser = new Visualiser();
    }

    public static void main(String[] args) {
        new TicTacToe().start();
    }

    private void start() {
        initPlayers();
        initBoard();
        startGame();
    }

    private void initPlayers() {
        player1 = input.getPlayerType("player1");
        player2 = input.getPlayerType("player2");
        player1.setNextPlayer(player2);
        player2.setNextPlayer(player1);
    }

    private void initBoard() {
        board = new Board(boardSize);
    }

    private void startGame() {

        Player currentPlayer = player1;

        while (!board.finished()) {
            visualiser.draw(board);
            doStep(currentPlayer);
        }

    }

    private void doStep(Player currentPlayer) {
        boolean isValidMove;
        Move move;
        do {
            move = currentPlayer.getMove();
            isValidMove = board.setMove(move);
            if (!isValidMove) {
                visualiser.message("error message");
            }
        } while (!isValidMove);
    }
}
