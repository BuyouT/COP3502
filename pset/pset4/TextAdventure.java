import java.util.*;

public class TextAdventure {

	public static void main(String[] args) {
		//initializeWorld();
		System.out.println("Welcome to the City of Evil!");
		System.out.println("You've become the Grim Reaper of souls.");
		System.out.println("It is your mission to collect at least 5 souls to prove yourself worthy.");
		System.out.println("However what is the Grim Reaper with out its scythe.");
		System.out.println("Maybe we can find one at the weapon shop nearby. Let's try going there by typing: go Weapon-Shop.");
		System.out.println("Remember to use the '-' between two words!");
		Scanner input = new Scanner(System.in);
		Processor processor = new Processor();
		String command = "";
		while (!command.equals("quit")) {
			command = input.nextLine();
			processor.processCommand(command);
		}
	}
}