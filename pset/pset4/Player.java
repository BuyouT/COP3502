public class Player {
	Location currentLocation;
	World world;
	Item currentItem;
	Inventory currentInventory;
	Chest chest;
	Enemy enemy;


	public Player() {
		currentInventory = new Inventory();
		world = new World();
		world.createWorld();
		currentLocation = world.map.get("Construction-Site");
	}

	public Location getLocation() {
		return currentLocation;
	}

	public void setLocation(Location location) {
		currentLocation = location;
	}

	public Item getItem() {
		return currentItem;
	}

	public Inventory getInventory() {
		return currentInventory;
	}

	public Chest getChest() {
		return chest;
	}

	public Enemy getEnemy() {
		return enemy;
	}

}