import java.util.Scanner;
public class ExitRoom implements Room{
	private String roomName;
	boolean proceed;
	Scanner scan = new Scanner(System.in);
	public ExitRoom(int difficultyMod)
	{//it's the exit room
		roomName = "Exit";
		proceed = false;
	}
	public String getRoomName()
	{
		return roomName;
	}
	public void getRoomDesc()
	{
		System.out.println("This is the exit to the next floor");
		System.out.println("It will bring you futher into the hive.");
	}
	public void interact(Hero hero)
	{//asks the player if they want to leave
		int choice;
		System.out.println("You've found the exit to this floor, would you like to leave?");
		System.out.println("1: Yes\n2: No");
	}
	public boolean changeFloor()
	{
		return proceed;
	}
	public Dungeon generate(int difficultyMod)
	{
		Dungeon newFloor = new Dungeon(difficultyMod);
		return newFloor;
	}

}
