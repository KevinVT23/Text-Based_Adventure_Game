import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Room {
	private String currentLocation = "";
	private Character player;
	private Menu display;
	private Scanner userInput = new Scanner(System.in);
	private List<Item> inventory = new ArrayList<Item>();;
	
	
	//Empty-constructor
	public Room(Character inRoom) {
		this.player = inRoom;
	}
	
	//This method handles the menus and actions that take place in the East 'room'.
	public void East(int condition) {
		currentLocation = "East";
		inventory = new ArrayList<Item>();
		display = new Menu(player, inventory);
		switch (condition) {
		case 1: 
			System.out.println(player.getName() + " stares at the spirt and feel a familiar feeling wash over you... one of family, another of loss.\n" +
							   "You try to remember who you've lost, but you cannot recall. You still feel like they're family.\n" +
							   "You get startled by the crows flying above.\n");
					display.eastMenu();
					break;
		case 2: 
			System.out.println("You move towards the spirt. You begin to make out female wearing a dress.\n"
					+ "The sprit is dark, and you can sense a heavy, chilling aura around her.\n"
					+ "She speaks in a soft tone, asking for your name.\n");
			
			//Insert correct code here.
			System.out.println("1. Playername");
			
			System.out.println("\"I've heard of the name before...\" the spirt replied.\n" +
					   		   "Would you happen to be searching for...this?\" She pulls out a key.\n" +
					   		   "\"If you want it, then promise me your soul... for insurance, obviously.\"\n" + 
					   		   "What will you do?\n" +
					   		   "[1]: Give up your soul... for now.\n" +
							   "[2]: Leave the conversation abruptly.\n");
			
			condition = userInput.nextInt();
			
			switch(condition) {
			case 1:
				System.out.println("You got the key.\n");
				player.addItem ("Key", "A key item that is used in combination with another to open a chest.");
				display.eastMenu();
				break;
			case 2:
				display.eastMenu();
				break;
			default:
				System.out.println("Please pick a valid option.\n");
				break;
			}
			
			break;
		default:
			System.out.println("You did nothing and left.\n");
			break;
		}
	}
	
	
	public void West(int condition) {
		currentLocation = "West";
		inventory = new ArrayList<Item>();
		display = new Menu(player, inventory);
		switch (condition) {
		case 1: 
			System.out.println("As you take in the scent, you smell daisies and sunflowers.\n" +  
					   			  "A gentle breeze trickles down your spine; you flinch.\n" +
				   				  "You have a feeling you should talk to the woman.\n");
			display.westMenu();
			break;
			
		case 2: 		   
			System.out.println("You walk towards the woman. She seems to notice you, keeping quiet.\n" +
			"[1]: Walk closer.\n" +
			"[2]: Walk away.\n");
		   
			condition = userInput.nextInt();
			
			switch(condition) {
			case 1:
				System.out.println("As you walk closer she starts to wake from her deep sleep.\n" + 
				   				   "\"Are you a bandit? If so, I don't have anything of importance.\"\n" + 
				   				   "After explaining yourself, she recognized you weren't a bandit, just a regular citizen.\n" + 
				   				   "You noticed a torch next to her. That could be useful.\n" +
				   				   "[1]: Ask for the torch.\n" +
		   						   "[2]: Take your leave.\n");
				
				condition = userInput.nextInt();
				
				switch(condition) {
				case 1:
					System.out.println("\"Oh, that thing? No need for it. Take it if you wish.\"" + 
				   			  		   "She gave you the torch, and said bye while heading towards more flowers.\n");
					player.addItem("Torch", "A torch; can be used to burn off moss and plants. HOT!");
					display.westMenu();
					break;
				case 2:
					System.out.println("You took your leave after giving your regards.\n");
					display.westMenu();
					break;
				default:
					System.out.println("You did nothing and left.\n");
					break;
				}
				
				break;
				
			case 2:
				System.out.println("You walked back to the garden entrance.\n");
				display.westMenu();
				break;
				
			default:
				System.out.println("You did nothing and left.\n");
				break;
			}

		case 3: 
			display.centralMenu(inventory);
			break;
			
		default:
			System.out.println("You did nothing and left.\n");
			break;
		}
	}
	
	
	public void North(int condition) {
		currentLocation = "North";
		inventory = new ArrayList<Item>();
		display = new Menu(player, inventory);
		switch (condition) {
		case 1: 
			System.out.println("You take a deep benath and fresh air come in side you.\n" +
							   "It seem like there nothing. Just waves hitting the ocean.\n");
			break;
		case 2: 
			System.out.println("He is in deep sleep and can't not be awoken.\n" +
							   "You wonder to yourself why is he sleeping here?\n");
			break;
		default:
			System.out.println("You did nothing and left.\n");
		}
		display.northMenu();
	}
	
	
	public void South(int condition) {
		currentLocation = "South";
		inventory = new ArrayList<Item>();
		display = new Menu(player, inventory);
		switch (condition) {
		case 1: 
			System.out.println("It is dark outside and you can only see the fire from the camfire.\n" +
							   "The tree around you look like shadows. You can smell the fire from the campfire.\n");
		case 2: 
			System.out.println("As you apporch he move his head up.\n" +
							   "His face was rough. He look like he has gotten to fight before.\n" +
							   "he has a scar on his face.\n" +
							   "[1]: Walk toward him.\n" +
						  	   "[2]: Leave\n");
		if (condition == 1) {
			System.out.println("As you walk towards him, he takes out a drink and hands it to you.\n" +
							   "Seeing no threat, he remained silent and gestured towards a chair.\n" +
							   "You sat down and tried to talk to him.\n" +
							   "No matter how you tried, no response came about.\n" +
							   "You thanked him for the beer and take your leave.\n" +
							   "To find yourself where you began all over again.\n");
		}
		break;
		case 3: 
			display.centralMenu(inventory);
			break;
		default:
			System.out.println("Please input a valid option from the prompted selection.\n");
		}
	}
	
	
	
}
