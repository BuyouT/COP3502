import java.util.*;

public class Items {
	public HashMap<String, Item> stuff = new HashMap<String, Item>();
	private Item item;

	public Items() {
		createItems();
	}

	public void createItems() {
		stuff.put("Scythe", new Item("Scythe", "A powerful weapon that can reap an enemy with a single blow."));
		stuff.put("Cloak", new Item ("Cloak" , "An elegant robe that will demonstrate your power as a Reaper."));
		stuff.put("Key", new Item("Key", "With this key there is no door you can't unlock."));
		stuff.put("Pure-Soul", new Item("Pure-Soul" , "A soul from an inocent pure hearted person, collect these to prove your value as a Reaper."));
		stuff.put("Dark-Soul", new Item("Dark-Soul", "A soul from an evil person filled with hatred, collect these to prove your value as a Reaper."));
		stuff.put("Lonely-Soul", new Item("Lonely-Soul" , "A soul from a very lonely person, collect these to prove your value as a Reaper."));
		stuff.put("Young-Soul", new Item("Young-Soul", "A soul from a kid, collect these to prove your value as a Reaper."));
		stuff.put("Kind-Soul", new Item("Kind-Soul" , "A soul from an kindred hearted person, collect these to prove your value as a Reaper."));
		stuff.put("Apple", new Item("Apple", "Believed to be Reaper's favorite food. ('Hey isn't that a ripoff from that show with the notebook?')"));
		stuff.put("Coffee", new Item("Coffee" , "Hmm, suddenly I feel more energetic than before!"));
	} 

	public Item getItems(String name) {
		return stuff.get(name);
	}



}