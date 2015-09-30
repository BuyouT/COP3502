import java.util.*;

public class Inventory {
	public ArrayList<Item> backpack;
	private Item item; 

	public void inventory() {
		backpack = new ArrayList<Item>();
	}

	public ArrayList<Item> getBackpack() {
		return backpack;
	}
} 