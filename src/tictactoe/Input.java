package tictactoe;

import java.util.Scanner;
import java.util.stream.Stream;

public class Input {
	
	private static Scanner input = new Scanner(System.in);
	
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
}
