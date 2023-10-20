import java.util.Random;
import java.util.Scanner;
public class ItemRoom implements Room{
	private String name;
	Item item;
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	public ItemRoom(int difficultyMod)
	{
		name = "Item Room";
		int itemType = random.nextInt(3);
		//a type of item is randomly generated, they have random stats, difficulty mod determines how good they can be
		if (itemType == 0)
		{
			item = new Item(difficultyMod);
			item.setName("Magic Pollen");
		}
		else if (itemType == 1)
		{
			item = new Item(difficultyMod);
			item.setName("Sword");
		}
		else if (itemType == 2)
		{
			item = new Item(difficultyMod);
			item.setName("Armor");
		}
		else if (itemType == 3)
		{
			item = new Item(difficultyMod);
			item.setName("Boots");
		}
	}
	public String getRoomName()
	{
		return name;
	}
	public void getRoomDesc()
	{
		System.out.println("An item room");
		System.out.println("It has a piece of equipment for you, free for the taking.");
	}
	public void interact(Hero hero)
	{//asks the player if they want to equip the item in the room
		if (item != null)
		{
			System.out.println("The room contains " + item.getFlavor());
			System.out.println("They will improve: " + item.getType() + " by " + item.getIncrease() + ".");
			System.out.println("Would you like to equip them?");
			System.out.println("1: Yes\n2:No");
			int choice = scan.nextInt();
			if (choice == 1)
			{
				hero.equipItem(item);
				name = "room with nothing inside";
				item = null;
			}
			else
			{
				System.out.println("You decide to leave the equipment where it is.");
			}
		}
		else
		{
			System.out.println("There's nothing here anymore.");
		}
	}
}
