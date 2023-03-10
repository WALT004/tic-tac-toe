package tictactoe;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlayerType {

    USER(new User()),
    EASY(new Easy()),
    MEDIUM(new Medium()),
    HARD(new Hard());

    private Player player;

}
