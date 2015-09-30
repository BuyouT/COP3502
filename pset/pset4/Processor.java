public class Processor {
	World newWorld = new World();
	Items myItems = new Items();
	Player player;
	

	public Processor() {
		player = new Player();
	}

	public void processCommand(String command) {
		//break command into words
		String[] words = parseCommand(command);
		//determine action to take based on words
		player = determinePlayer(words);		
	} 

	public String[] parseCommand(String command) {
		return command.split(" ");
	}

	public Player determinePlayer(String[] words) {
		
		if (words[0].equals("go")) {
			Location location = newWorld.getMap().get(words[1]);
			player.setLocation(location);
			System.out.println("you're now at the: " + location);	
		}
		else if (words[0].equals("look")) {
			String description = player.getLocation().getDescription();
			Location north = newWorld.getMap().get(player.getLocation().getNorth());
			Location south = newWorld.getMap().get(player.getLocation().getSouth());
			Location east = newWorld.getMap().get(player.getLocation().getEast());
			Location west = newWorld.getMap().get(player.getLocation().getWest());
			System.out.println(description);
			System.out.println("To your north is: " + north);
			System.out.println("To your south is: " + south);
			System.out.println("To your east is: " + east);
			System.out.println("To your west is: " + west);

		}
		
		else if (words[0].equals("take")) {
			Item item = myItems.getItems(words[1]);
			player.getInventory().getBackpack().add(item);
			
		}

		else if (words[0].equals("examine")) {
			Item item = myItems.getItems(words[1]);
			String description = player.getItem().getDescription(item);
			System.out.println(description);
		}
		
		else if (words[0].equals("use")) {
			if (words[1].equals("key") && player.getLocation().equals("Bank")) {
				Item item = player.getChest().getItem();
				player.getInventory().getBackpack().add(item);
			} else if (words[1].equals("Scythe") && player.getLocation().equals("Shady-Dark-Alley")) {
				Item item = player.getEnemy().getItem();
				player.getInventory().getBackpack().add(item);
			} else if (words[1].equals("Apple")) {
				System.out.println("That is one tasty apple.");
			} else if (words[1].equals("Coffee")) {
				System.out.println("I feel wide awake now.");
			}
		}

		else if (words[0].equals("check") && words[1].equals("inventory")) {
			System.out.println(player.getInventory().getBackpack());
		} 

		/*else if (player.getInventory.getBackpack().contains(myItems.getItems("Pure-Soul")) && 
			player.getInventory.getBackpack().contains(myItems.getItems("Dark-Soul")) &&
			player.getInventory.getBackpack().contains(myItems.getItems("Young-Soul")) &&
			player.getInventory.getBackpack().contains(myItems.getItems("Kind-Soul")) && 
			player.getInventory.getBackpack().contains(myItems.getItems("Lonely-Soul"))) {
			System.out.println("Congratulations! You've proved yourself worthy");
			System.out.println("You've earned the title of a Grim Reaper.");
			System.out.println("I hope you had fun during this adventure. You're welcome to play again!");
		}*/

		return player;
	}
}