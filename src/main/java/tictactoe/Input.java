package tictactoe;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;
import java.util.stream.Stream;

public class Input {

	//TODO create singleton
	
	private static final Scanner input = new Scanner(System.in);

    public Player getPlayerType(String player) {
    	System.out.println("Please select type for " + player);
    	Stream.of(PlayerType.values()).forEach(System.out::println);
    	while (true) {
    		String userEnteredPlayerType = input.next();
    		try {
    			PlayerType selectedPlayerType = PlayerType.valueOf(userEnteredPlayerType);
    			return selectedPlayerType.getPlayer();
    		} catch (IllegalArgumentException e) {
    			System.out.println("There is no type with " + userEnteredPlayerType);
    		}
    	}
    }

	public int getMove() {
		while (true) {
			String userEnteredMove = input.next();
			try {
				return Integer.parseInt(userEnteredMove);
			} catch (NumberFormatException e) {
				//TODO print error message
			}
		}
	}
}
