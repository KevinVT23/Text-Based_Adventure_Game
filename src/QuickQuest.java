// Goal is too make a text base adventure game.
//five room north south east west and the main room
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

//Gabriel Smith | December 12th, 2019

//This is the main class where the program will run.
//Try to add file saving and loading here, or wherever works really.
public class QuickQuest {
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Please input your character's name.\n");
		String characterName = userInput.nextLine();
		
		List<Item> inventory = new ArrayList<Item>();
		Character player = new Character(characterName, inventory);
		Menu display = new Menu(player, inventory);
		
		display.mainMenu();
		
		
	}
		
}

