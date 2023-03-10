package tictactoe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Move {
    private int row;
    private int column;
    private Player player;
}
