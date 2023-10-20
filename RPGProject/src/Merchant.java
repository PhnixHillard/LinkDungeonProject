import java.util.Random;
import java.util.Scanner;
public class Merchant {
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	Item item1;
	Item item2;
	int merchantUnfairness;
	int healPrice;
	boolean hasHeal;
	public Merchant(int difficultyMod)
	{//merchant gets less "fair" as the player through the game
		if (difficultyMod != 0)
		{
			merchantUnfairness = (random.nextInt(difficultyMod*10));
		}
		else
		{
			merchantUnfairness = 0;
		}
		if (random.nextInt()%2 == 0)//50/50 chance merchant has a heal
		{
			hasHeal = true;
		}
		if (merchantUnfairness < 20)//heal is guaranteed free for the first 2 floors if the merchant has one
		{
			healPrice = 0;
		}
		else 
		{
			healPrice = merchantUnfairness/2;
		}
		generateWares(difficultyMod);
	}
	public void generateWares(int difficultyMod)
	{//merchant has a random inventory, always two items
		int itemType = random.nextInt(3);
		if (itemType == 0)
		{
			item1 = new Item(difficultyMod);
			item1.setName("Magic Pollen");
		}
		else if (itemType == 1)
		{
			item1 = new Item(difficultyMod);
			item1.setName("Sword");
		}
		else if (itemType == 2)
		{
			item1 = new Item(difficultyMod);
			item1.setName("Armor");
		}
		else if (itemType == 3)
		{
			item1 = new Item(difficultyMod);
			item1.setName("Boots");
		}
		itemType = random.nextInt(3);
		if (itemType == 0)
		{
			item2 = new Item(difficultyMod);
			item2.setName("Magic Pollen");
		}
		else if (itemType == 1)
		{
			item2 = new Item(difficultyMod);
			item2.setName("Sword");
		}
		else if (itemType == 2)
		{
			item2 = new Item(difficultyMod);
			item2.setName("Armor");
		}
		else if (itemType == 3)
		{
			item2 = new Item(difficultyMod);
			item2.setName("Boots");
		}
	}
	public void showWares()
	{//tells you what the merchant has for you
		System.out.println("A moth stands before you. He offers you his wares.");
		if (hasHeal)
		{
			System.out.println("He also offers you a place to rest.");
		}
		System.out.println("He has these two items: ");
		item1.getEverything();
		item2.getEverything();
		if (hasHeal)
		{
			if (healPrice == 0)
			{
				System.out.println("He will let you rest here for free.");
			}
			else
			{
				System.out.println("He will let you rest here for " + healPrice + " nectar.");
			}
		}
	}
	public void shop(Hero hero)
	{//shopping loop
		boolean leaving = false;
		while (leaving == false)
		{//loops as long as the player doesn't choose to leave
			System.out.println("What would you like to do?");
			System.out.println("1: Leave");
			if (item1 != null)//item1 has to exist
			{
				System.out.println("2: Buy the first item");
			}
			if (item2 != null)//item2 has to exist
			{
				System.out.println("3: Buy the second item");
			}
			if(hasHeal)//he has to have a heal
			{
				System.out.println("4: Rest");
			}
			int choice = scan.nextInt();
			if (choice == 1)
			{
				System.out.println("You decide to leave");
				leaving = true;
			}
			else if (choice == 2 && item1 != null)
			{
				System.out.println("\"A fine choice!\"");
				if (hero.getMoney()>=item1.getPrice())
				{
					hero.setMoney(hero.getMoney()-item1.getPrice());
					hero.equipItem(item1);
					item1 = null;
					System.out.println("\"And a pleasure doing business.\"");
				}
				else
				{
					System.out.println("\"But you don't seem to have enough nectar...\"");
				}
			}
			else if (choice == 3 && item2 != null)
			{
				System.out.println("\"A fine choice!\"");
				if (hero.getMoney()>=item2.getPrice())
				{
					hero.setMoney(hero.getMoney()-item2.getPrice());
					hero.equipItem(item2);
					item2 = null;
					System.out.println("\"And a pleasure doing business.\"");
				}
				else
				{
					System.out.println("\"But you don't seem to have enough nectar...\"");
				}
			}
			else if (choice == 4 && hasHeal)
			{
				if (hero.getMoney()>=healPrice)
				{
					System.out.println("\"Wonderful! Get yourself comfortable, I promise you'll be safe here.\"");
					hero.setLife(hero.getMaxLife());
					System.out.println("You rest for a while, you feel fully restored.");
				}
				else
				{
					System.out.println("\"Oh dear, you don't seem to have enough nectar...\"");
					if (merchantUnfairness < 50 && hero.getLife() < 10)
					{
						System.out.println("\"Since you look so worn, I'll let you rest for free this time.\"");
						hero.setLife(hero.getMaxLife());
						System.out.println("You rest for a while, you feel fully restored.");
					}
					else
					{
						System.out.println("\"I'm sorry, but I have to eat too, come back when you have enough.\"");
					}
				}
			}
			else
			{
				System.out.println("That wasn't one of the choices, the moth looks at you, puzzled.");
			}
		}
		System.out.println("\"Hope to see you again soon\" says the moth, smiling widely.");
	}
}
