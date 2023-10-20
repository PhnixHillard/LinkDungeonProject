import java.util.Random;
public class Dungeon {
	CircularLinkedList hive = new CircularLinkedList();
	Random random = new Random();
	private int floorSize;
	public Dungeon(int difficultyMod)
	{//generates dungeon floor
		floorSize = random.nextInt(3)+4;//random floor size 4 - 7 rooms, not counting the exit
		while(hive.size()<floorSize)//generates rooms
		{
			Room room;
			int roomType = random.nextInt(6);
			if (roomType < 3)//generates a battle room
			{
				room = new BattleRoom(difficultyMod);
			}
			else if (roomType == 3)//generates an item room
			{
				room = new ItemRoom(difficultyMod);
			}
			else if (roomType == 4)//generates a trap room
			{
				room = new TrapRoom(difficultyMod);
			}
			else if (roomType == 5)//generates a merchant room
			{
				room = new Shop(difficultyMod);
			}
			else 
			{
				room = new Shop(difficultyMod);
			}
			hive.addInFront(room);
			if(hive.size()==floorSize-1)
			{//creates a boss for the end of the floor
				int bossType = random.nextInt(3);
				if (bossType == 0)
				{
					Hornet boss = new Hornet(difficultyMod);
					boss.makeBoss(difficultyMod);
					BattleRoom bossRoom = new BattleRoom(boss);
					hive.addInFront(bossRoom);
				}
				else if (bossType == 1)
				{
					Mantis boss = new Mantis(difficultyMod);
					boss.makeBoss(difficultyMod);
					BattleRoom bossRoom = new BattleRoom(boss);
					hive.addInFront(bossRoom);
				}
				else if (bossType == 2)
				{
					RobberFly boss = new RobberFly(difficultyMod);
					boss.makeBoss(difficultyMod);
					BattleRoom bossRoom = new BattleRoom(boss);
					hive.addInFront(bossRoom);
				}
				else if (bossType == 3)
				{
					Spider boss = new Spider(difficultyMod);
					boss.makeBoss(difficultyMod);
					BattleRoom bossRoom = new BattleRoom(boss);
					hive.addInFront(bossRoom);
				}
			}
		}
		//generates exit randomly somewhere in the floor
		int exitPosition = random.nextInt(floorSize-1);
		Room exitRoom = new ExitRoom(difficultyMod);
		hive.add(exitPosition, exitRoom);
		floorSize++; //counting the exit
	}
	public String leftRoomName(int index)
	{
		if(index == 0)
		{
			Room room = hive.get(floorSize).getData();
			return room.getRoomName();
		}
		else
		{
			Room room = hive.get(index-1).getData();
			return room.getRoomName();
		}
	}
	public int leftRoomLocation(int index)
	{
		if(index == 0 || index == 1)
		{
			return floorSize;
		}
		else
		{
			return index-1;
		}
	}
	public String rightRoomName(int index)
	{
		Room room = hive.get(index+1).getData();
		return room.getRoomName();
	}
	public int rightRoomLocation(int index)
	{
		if (index == floorSize)
		{
			return 1;
		}
		else
		{
			return index+1;
		}
	}
	public void roomInteract(int index, Hero hero)
	{
		Room room = hive.get(index).getData();
		room.interact(hero);
	}
	public Room currentRoom(int index)
	{
		Room room = hive.get(index).getData();
		return room;
	}
	public void floorMap(int index)
	{
		if (floorSize == 5)
		{
			System.out.println(hive.get(3).getData().getRoomName() + "\n  Room 3");
			System.out.println("    |         \\");
			System.out.println("    |          \\");
			System.out.println(hive.get(4).getData().getRoomName() +"     " + hive.get(2).getData().getRoomName());
			System.out.println("  Room 4        Room 2");
			System.out.println("    |           |");
			System.out.println("    |           |");
			System.out.println(hive.get(5).getData().getRoomName() +"     " + hive.get(1).getData().getRoomName());	
			System.out.println("  Room 5        Room 1");
			System.out.println("    |          /");
			System.out.println("    |         /");
		}
		if (floorSize == 6)
		{
			System.out.println(hive.get(4).getData().getRoomName() +"     " + hive.get(3).getData().getRoomName());
			System.out.println("  Room 4------Room 3");
			System.out.println("    |          |");
			System.out.println("    |          |");		
			System.out.println(hive.get(5).getData().getRoomName() +"     " + hive.get(2).getData().getRoomName());
			System.out.println("  Room 5        Room 2");
			System.out.println("    |          |");
			System.out.println("    |          |");	
			System.out.println(hive.get(6).getData().getRoomName() +"     " + hive.get(1).getData().getRoomName());
			System.out.println("  Room 6        Room 1");
			System.out.println("    \\          /");
			System.out.println("     \\        /");
		}
		if (floorSize == 7)
		{
			System.out.println(hive.get(4).getData().getRoomName() + "\n  Room 4");
			System.out.println("    |         \\");
			System.out.println("    |          \\");
			System.out.println(hive.get(5).getData().getRoomName() +"     " + hive.get(3).getData().getRoomName());
			System.out.println("  Room 5        Room 3");
			System.out.println("    |           |");
			System.out.println("    |           |");
			System.out.println(hive.get(6).getData().getRoomName() +"     " + hive.get(2).getData().getRoomName());	
			System.out.println("  Room 6        Room 2");
			System.out.println("    |          |");
			System.out.println("    |          |");
			System.out.println(hive.get(7).getData().getRoomName() +"     " + hive.get(1).getData().getRoomName());
			System.out.println("  Room 7        Room 1");
			System.out.println("    |          /");
			System.out.println("    |         /");
		}
		if (floorSize == 8)
		{
			System.out.println(hive.get(5).getData().getRoomName() +"     " + hive.get(4).getData().getRoomName());
			System.out.println("  Room 5------Room 4");
			System.out.println("    |          |");
			System.out.println("    |          |");		
			System.out.println(hive.get(6).getData().getRoomName() +"     " + hive.get(3).getData().getRoomName());
			System.out.println("  Room 6        Room 3");
			System.out.println("    |          |");
			System.out.println("    |          |");		
			System.out.println(hive.get(7).getData().getRoomName() +"     " + hive.get(2).getData().getRoomName());
			System.out.println("  Room 7        Room 2");
			System.out.println("    |          |");
			System.out.println("    |          |");	
			System.out.println(hive.get(8).getData().getRoomName() +"     " + hive.get(1).getData().getRoomName());
			System.out.println("  Room 8        Room 1");
			System.out.println("    \\          /");
			System.out.println("     \\        /");	
		}
		if (index != 0)
		{ 
			System.out.println("You are in room " + index);
		}
		else
		{
			System.out.println("You are not in a room currently");
		}
	}
	public int getFloorSize()
	{
		return floorSize;
	}
	public void roomDescription(int index)
	{
		hive.get(index).getData().getRoomDesc();
	}
	
}
