import java.util.*;

public class World {
	public Items items;
	public HashMap<String, Location> map = new HashMap<String, Location>();
	private Location tempLocation;
	

	public World() {
		createWorld();
	}

	public void createWorld() {
		items = new Items();
		String northBound =  "There's a city over there better stay here.";
		String southBound = "There's nothing beyond there can't go that way.";
		String eastBound = "There's a wall over there.";
		String westBound = "There's a cliff there no point going that way.";
		

		tempLocation = new Location("Weapon-Shop", "There are multiple weapons in display from katanas to RPGs, you see a scythe hanging on the wall.",
		 "School", "Construction-Site", "Bank", "Movie-Theater", items.getItems("Scythe"), null, null);
		map.put("Weapon-Shop",tempLocation);

		tempLocation = new Location("School", "You see several locked classrooms, a few closed lockers, one is not locked and there seems to be a key",
		 northBound, "Weapon-Shop", "Clothes-Shop", "Coffee-Shop", items.getItems("Key"), null, null);
		map.put("School", tempLocation);

		tempLocation = new Location("Clothes-Shop", "There are clothes everywhere, but you are looking for a cloak. Talk to the attendant maybe she can find one for you",
		 northBound, "Movie-Theater", "School", westBound, items.getItems("Cloak"), null, null);
		map.put("Clothes-Shop", tempLocation);

		tempLocation = new Location("Park" , "There are a lot of apple trees, I wonder if I can take one.",
		 "Movie-Theater", "Old-Retirement-Home", "Construction-Site", westBound, items.getItems("Apple"), null, null);
		map.put("Park", tempLocation);
		
		tempLocation = new Location("Construction-Site" , "I have a bad feeling of this place, but other than that there nothing here.",
		 "Weapon-Shop", "Cemetery", "Abandoned-House", "Park", null, null, null);
		map.put("Construction-Site", tempLocation);

		tempLocation = new Location("Coffee-Shop" , "There's a drink on top of the counter labled Coffee",
		 northBound, "Bank", eastBound, "School", items.getItems("Coffee"), null, null);
		map.put("Coffee-Shop", tempLocation);

		tempLocation = new Location("Bank" , "There's a chest laying on the floor I wonder what's inside? Maybe I can open it somehow",
		 "Coffee-Shop", "Abandoned-House", eastBound, "Construction-Site", null, new Chest(), null);
		map.put("Bank", tempLocation);

		tempLocation = new Location("Abandoned-House", " A soul! Looks so lonely",
		 "Bank", "Shady-Dark-Alley", eastBound, "Construction Site", items.getItems("Lost-Soul"), null, null);
		map.put("Abandoned-House", tempLocation);

		tempLocation = new Location("Old-Retirement-Home", "This place is a gold mine! I already see a soul roaming around!", "Park",
		 southBound, "Cemetery", westBound, items.getItems("Lonely-Soul"), null, null);
		map.put("Old-Retirement-Home", tempLocation);

		tempLocation = new Location("Cementary" , "Ha ha how ironic that there isn't a single soul here.",
		 "Construction-Site", southBound, "Shady-Dark-Alley", "Old-Retirement-Home", null, null, null);
		map.put("Cemetery", tempLocation);

		tempLocation = new Location("Shady-Dark-Alley" , "Hm I sense an evil presence, I guess I finally get to use my scythe!",
		 "Abandoned-House", southBound, eastBound, "Cemetery", null, null, new Enemy());
		map.put("Shady-Dark-Alley", tempLocation);

		tempLocation = new Location("Movie-Theater" , "I-Is that a soul watching a movie?? Can't blame him that's a really good movie",
		 "Clothes-Shop", "Park", "Weapon-Shop", westBound, items.getItems("Young-Soul"), null, null);
		map.put("Movie-Theater", tempLocation);
	}	

	public HashMap<String, Location> getMap() {
		return map;
	}
}