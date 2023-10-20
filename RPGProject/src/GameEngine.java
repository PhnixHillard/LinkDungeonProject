import java.util.Scanner;
public class GameEngine {
	public void runGame()
	{//the whole game
		int difficultyMod = 0;
		int floor = 1;
		int position = 0;
		Scanner scanner = new Scanner(System.in);
		int choice;
		Hero player;
		System.out.println("You are one of the last bees remaining in your hive.");
		System.out.println("Just yesterday an invasion of predator bugs wiped out almost everyone you've ever known.");
		System.out.println("It is time to avenge them.");
		System.out.println("What kind of bee are you?");
		System.out.println("1.Miner bee (Higher speed)\n2.Carpenter bee (Higher defense)\n3.Bumble bee(Higher life)");
		choice = scanner.nextInt();
		if (choice == 1)
		{
			player = new Hero("Miner");
		}
		else if (choice == 2)
		{
			player = new Hero("Carpenter");
		}
		else if (choice == 3)
		{
			player = new Hero("Bumble");
		}
		else
		{
			System.out.println("You seem a bit confused, you'll be a bumble bee");
			player = new Hero("Bumble");
		}
		System.out.println("You enter your hive, likely for the last time in your life.");
		System.out.println("You won't leave alive.");
		System.out.println("Generating...");
		Dungeon hive = new Dungeon(difficultyMod);
		while (player.getLife()>0)
		{
			System.out.println("To your left is a " + hive.leftRoomName(position));
			System.out.println("To your right is a " + hive.rightRoomName(position));
			System.out.println("What would you like to do?");
			System.out.println("1: Go Left\n2: Go Right\n3: Look at the map\n4: Inspect a cell\n5: Check Stats");
			choice = scanner.nextInt();
			if (choice == 1)
			{
				System.out.println("You go left to the " + hive.leftRoomName(position));
				position = hive.leftRoomLocation(position);
				hive.roomInteract(position, player);
				if(hive.currentRoom(position) instanceof ExitRoom)
				{
					choice = scanner.nextInt();
					if (choice == 1)
					{
						System.out.println("You proceed to the next floor");
						difficultyMod++;
						Dungeon newFloor = new Dungeon(difficultyMod);
						hive = newFloor;
						floor++;
					}
					else
					{
						System.out.println("You stay on this floor...for now.");
					}
					
				}
			}
			else if (choice == 2)
			{
				System.out.println("You go right to the " + hive.rightRoomName(position));
				position = hive.rightRoomLocation(position);
				hive.roomInteract(position, player);if(hive.currentRoom(position) instanceof ExitRoom)
				{
					choice = scanner.nextInt();
					if (choice == 1)
					{
						System.out.println("You proceed to the next floor");
						difficultyMod++;
						Dungeon newFloor = new Dungeon(difficultyMod);
						hive = newFloor;
						floor++;
					}
					else
					{
						System.out.println("You stay on this floor...for now.");
					}
					
				}
			}
			else if (choice == 3)
			{
				hive.floorMap(position);
			}
			else if (choice == 4)
			{
				System.out.println("Which cell?");
				choice = scanner.nextInt();
				if (choice <= hive.getFloorSize())
				{
					hive.roomDescription(choice);
				}
			}
			else
			{
				player.printHeroStats();
			}
			
		}
		System.out.println("Your adventure has come to an end.");
		System.out.println("You died on floor " + floor + " of the hive.");
		System.out.println("These are your final stats: ");
		player.printHeroStats();
		
	}
}