package tictactoe;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {
    private int row;
    private int column;
    private Player player;
}
