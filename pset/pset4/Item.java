public class Item{
	private String description;
	private String name;

	public Item(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getDescription(Item item) {
		return description;
	}
}