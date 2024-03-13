import java.util.ArrayList;

public class Item {
	//Declaring variables
	private String nameOfItem;
	private String descriptionOfItem;
	
	//Constructor for item
	public Item(String name, String description) {
		this.nameOfItem = name;
		this.descriptionOfItem = description;
	}
	
	//Get the details of an item, because CONTENT.
	public String getItemDetails() {
		return this.nameOfItem + "\n" + this.descriptionOfItem;
	}

}

