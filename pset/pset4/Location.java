public class Location {
	private String description;
	private String north;
	private String south;
	private String east;
	private String west;
	private String name;
	Item item;
	Chest chest;
	Enemy enemy;

	public Location(String name, String description, 
		String north, String south, String east, String west, Item item, Chest chest, Enemy enemy) {
		this.name = name;
		this.description = description;
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		this.item = item;
		this.chest = chest;
		this.enemy = enemy;

	}	
	public String getName(){
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getNorth() {
		return north;
	}

	public String getSouth() {
		return south;
	}

	public String getEast() {
		return east;
	}

	public String getWest() {
		return west;
	}

	public String toString(){
		return name;
	}

	public Item getItem() {
		return item;
	}

	public Chest getChest() {
		return chest;
	}

	public Enemy getEnemy() {
		return enemy;
	}

} 