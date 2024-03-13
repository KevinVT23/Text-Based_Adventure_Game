import java.util.ArrayList;
import java.util.List;

//This class creates the character, with a name and 'controls'.
public class Character {
	private String characterName;
	private List<Item> inventory;
	
	
	public Character() {
		
	}
	
	public Character(String name) {
		this.characterName = name;
	}
	
	//Constructor loaded with name, specified by player.
	public Character(String name, List<Item> inventory) {
		this.characterName = name;
		this.inventory = inventory;
		inventory = new ArrayList<Item>();
	}
	
	public String getName() {
		return this.characterName;
	}
	// adding too our inv
	public void addItem(String itemName, String description) {
		Item item = new Item(itemName, description);
		inventory.add(item);
	}
}
