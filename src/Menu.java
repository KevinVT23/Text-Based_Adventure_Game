import java.util.Scanner;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Menu {
	//Declaring global variables
	private int condition;
	private Room room;
	Scanner userInput;
	private boolean chestOpen = false;
	Menu menu;
	List<Item> inventory;
	List<Item> keyItemChecker;
	Character player;
	// our two item too beat the game
	Item key = new Item("Key", "A key item that is used in combination with another to open a chest.");
	Item torch = new Item("Torch", "A torch; can be used to burn off moss and plants. HOT!");
	//Empty-constructor.
	public Menu(Character playerCharacter, List<Item> inventoryCharacter) {
		this.player = playerCharacter;
		this.inventory = inventoryCharacter;
		inventoryCharacter = new ArrayList<Item>();
		this.keyItemChecker = new ArrayList<Item>();
	}
	
	//This method outlines the options for the east Menu, and prompts input to continue the game.
	public void eastMenu() {
		userInput = new Scanner(System.in);
		inventory = new ArrayList<Item>();
		menu = new Menu(player, inventory);
		room = new Room(player);
		while (condition != 3) {
		System.out.println(player.getName() + " travels east towards the graveyard. It is foggy and hard to see anything.\n" +
		"The sky is dark and the moon is a half-moon. As "+ player.getName() + " stops, they see a spirt floating ahead.\n" +
		"[1]: Inspect the graveyard in greater detail.\n" +
		"[2]: Approach the spirt.\n" +
		"[3]: Return to town.\n");
		
		condition = userInput.nextInt();
		
		switch(condition) {
		case 1:
			room.East(condition);
			break;
		case 2:
			room.East(condition);
			break;
		case 3:
			System.out.println("You've returned to town.\n");
			menu.centralMenu(inventory);
			break;
		
		default:
			System.out.println("Please choose from the given options.\n");
			break;
			}
		}
	}

	//This method highlights the options for the west Menu, and prompts input to continue the game.
	public void westMenu() {
		userInput = new Scanner(System.in);
		inventory = new ArrayList<Item>();
		menu = new Menu(player, inventory);
		room = new Room(player);
		while (condition != 3) {
		System.out.println(player.getName() + " travels west towards the garden, and it was a beautful site to see. Several diferrent colors and flowers made up the scenery.\n" +
		"As the moon begins to shine down on the gardern," + player.getName() + " is met with a wonder with a view right out of a masterful painting.\n" +
		player.getName() + " takes a deep breath and takes it all in. As they began to leave, they saw a woman resting, curled up by a bunch of plants, as if she was hiding.\n" +
		"[1]: Inspect the garden in greater detail.\n" +
		"[2]: Approach the woman.\n" +
		"[3]: Return to town.\n");
		
		condition = userInput.nextInt();
		
		switch(condition) {
		case 1:
			room.West(condition);
			break;
		case 2:
			room.West(condition);
			break;
		case 3:
			System.out.println("You've returned to town.\n");
			menu.centralMenu(inventory);
			break;
		default:
			System.out.println("Please choose from the given options.\n");
			break;
			}
		}
	}
	
	//This method highlights the options for the north Menu, and prompts input to continue the game.
	public void northMenu() {
		userInput = new Scanner(System.in);
		inventory = new ArrayList<Item>();
		menu = new Menu(player, inventory);
		room = new Room(player);
		while (condition != 3) {
		System.out.println(player.getName() + " travels north towards the cliff. You hear ocean waves crashing into each other and birds chirping and screaming around.\n" +
		player.getName() + " notices a young kid looking towards the ocean, seemingly deep in thought. They sense there is something wrong with him.\n" +
		"[1]: Inspect the Cliff in greater detail.\n" +
		"[2]: Talk to the kid.\n" +
		"[3]: Return to town.\n");
		
		condition = userInput.nextInt();
		
		switch(condition) {
		case 1:
			room.North(condition);
			break;
		case 2:
			room.North(condition);
			break;
		case 3:
			System.out.println("You've returned to town.\n");
			menu.centralMenu(inventory);
			break;
		default:
			System.out.println("Please choose from the given options.\n");
			break;
			}
		}
	}

	//This method highlights the options for the south Menu, and prompts input to continue the game.
	public void southMenu() {
		userInput = new Scanner(System.in);
		inventory = new ArrayList<Item>();
		menu = new Menu(player, inventory);
		room = new Room(player);
		while (condition != 3) {
		System.out.println("You travel south and find you self to be in a forest. You see a camp in the distance and see a campfire as you apporch you see a man\n" +
		"[1]: Inspect your sourroundings.\n" +
		"[2]: Greet the man.\n" +
		"[3]: Return to town.\n");
		
		condition = userInput.nextInt();
		
		switch(condition) {
		case 1:
			room.South(condition);
			break;
		case 2:
			room.South(condition);
			break;
		case 3:
			System.out.println("You've returned to town.\n");
			menu.centralMenu(inventory);
			break;
		default:
			System.out.println("Please choose from the given options.\n");
			break;
			}
		}
	}
	
	//This method highlights the options for the central Menu, and prompts input to continue the game.
	//This menu has a chest that, when prompted with certain items in inventory, ends the game.
	public void centralMenu(List<Item> inventory) {
		userInput = new Scanner(System.in);
		inventory = new ArrayList<Item>();
		menu = new Menu(player, inventory);
		while (chestOpen == false) {
		System.out.println("You're in a town. Only silence fills the streets.\n" +
		"In the main square of the town, you see the chest with 4 oddly specifcly shaped slots, as if they were intentionally missing.\n" +
		"[1]: Open the chest.\n" +
		"[2]: Head North (Cliff Sides)\n" +
		"[3]: Head East (Graveyard)\n" +
		"[4]: Head West (Town Garden)\n" +
		"[5]: Head South (Forest)\n" +
		"[6]: Look around the city.\n");
		
		condition = userInput.nextInt();
		
		switch(condition) {
		case 1:
			player.addItem ("Key", "A key item that is used in combination with another to open a chest.");
			player.addItem ("Torch", "A torch; can be used to burn off moss and plants. HOT!");

			keyItemChecker.add(key);
			keyItemChecker.add(torch);
			if (inventory.contains(torch) & inventory.contains(key)) {
				System.out.println("You burned the moss off of it, and unlocked the chest!\n");
				chestOpen = true;
			}
			else {
				System.out.println("You couldn't access the chest. Moss crawls back over the chest, almost as if it were alive.\n");
				keyItemChecker.clear();
			}
			break;
		case 2:
			menu.northMenu();
			break;
		case 3:
			menu.eastMenu();
			break;
		case 4:
			menu.westMenu();
			break;
		case 5:
			menu.southMenu();
			break;
		case 6:
			System.out.println("The town is dark; you can see lights from lanterns around the city. This place feels antique... and worn down.\n");
			break;
		default:
			System.out.println("Please choose from the given options.\n");
			break;
			}
		}
		menu.endScreen();
	}
	
	//This method highlights the options for the main Menu, and prompts input.
	//Can start or load games.
	public void mainMenu() {
		userInput = new Scanner(System.in);
		inventory = new ArrayList<Item>();
		menu = new Menu(player, inventory);
		while (condition != 3) {
			System.out.println("[1]: Start\n" +
						   	   "[2]: Load\n" +
						   	   "[3]: Quit\n");
		
		condition = userInput.nextInt();
		
		switch(condition) {
		case 1:
			System.out.println("Welcome to Quick Quest, a quick text adventure game. Enjoy!\n");
			System.out.println("Welcome, and enjoy, " + player.getName());
			menu.centralMenu(inventory);
			break;
		case 2:
			break;
		case 3:
			System.out.println("Oh. Well, have a good day then.");
			break;
		default:
			System.out.println("Please choose from the given options.\n");
			break;
			}
		}
	}
	//When you beat the game and open the chest.
	public void endScreen() {
		userInput = new Scanner(System.in);
		inventory = new ArrayList<Item>();
		menu = new Menu(player, inventory);
		while (condition != 2) {
			
			System.out.println("The End\n" +
							   "Program by Gabriel B Smith and Kevin Than\n" +
							   "Thank You for playing our game.\n" +
							   "[1]: Play Again\n" +
							   "[2]: Quit\n");
		
		condition = userInput.nextInt();
		
		switch(condition) {
		case 1:
			inventory.clear();
			menu.mainMenu();
			break;
		case 2:
			System.out.println("Thank you, and good day.");
			System.exit(0); //Exit since it's the end of the program.
			break;
		default:
			System.out.println("Please choose from the given options.\n");
			break;
			}
		}
	}
}
