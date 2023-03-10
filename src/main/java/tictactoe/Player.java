package tictactoe;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Player {

    private Player nextPlayer;
    private BoardElement boardElement;

    public abstract Move getMove();

}
