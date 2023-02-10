package tictactoe;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Player {

    private  Player nextPlayer;

    public abstract Move getMove();

}
