import java.util.Random;
import java.util.Scanner;
public class BattleRoom implements Room{
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	Creature foe;
	private String roomName;
	private Boolean runFlag;
	private Boolean roomEmpty;
	public BattleRoom(int difficultyMod)
	{//picks a random enemy for the room, each is buffed according to the difficulty mod
		int enemy = random.nextInt(3);
		if (enemy == 0)
		{//generates a hornet enemy
			foe = new Hornet(difficultyMod);
		}
		else if (enemy == 1)
		{//generates a mantis enemy
			foe = new Mantis(difficultyMod);
		}
		else if (enemy == 2)
		{
			foe = new RobberFly(difficultyMod);
		}
		else if (enemy == 3)
		{
			foe = new Spider(difficultyMod);
		}
		roomName = "room with an enemy";
		roomEmpty = false;
	}
	public BattleRoom(Creature boss)
	{//makes a boss room
		foe = boss;
		roomName = "boss room";
		roomEmpty = false;
	}
	public String getRoomName()
	{
		return roomName;
	}
	public void getRoomDesc()
	{
		System.out.println("This room holds an enemy");
		System.out.println("In particular this one holds a level "+ foe.getLevel() +" " + foe.getName() +".");
	}
	public void interact(Hero hero)
	{//upon going to an enemy room, player can choose to run at the start of combat or at the end of each turn
		if(roomEmpty == false)
		{//makes sure you aren't trying to run from an empty room on revisits
			{
				System.out.println("The " + foe.getName() + " stands before you.");
				System.out.println("It is level " + foe.getLevel() + ".");
				runFlag = runChoice(hero);
			}
			while (foe.getLife() > 0 && hero.getLife() > 0 && runFlag == false)
			{
				if (foe.getSpeed() > hero.getSpeed())
				{//enemy outspeeds hero
					foe.attack(hero);
					if (hero.getLife() > 0)
					{//makes sure hero isn't dead yet
						hero.attack(foe);
					}
				}
				else if (foe.getSpeed() < hero.getSpeed())
				{//if hero outspeeds enemy
					hero.attack(foe);
					{//makes sure enemy isn't dead yet
						foe.attack(hero);
					}
				}
				else
				{//if speed stats are equal
					int tieBreaker = random.nextInt(4);
					if(tieBreaker % 2 == 0)
					{//hero goes first
						hero.attack(foe);
						{//makes sure enemy isn't dead yet
							foe.attack(hero);
						}
					}
					else
					{
						foe.attack(hero);
						if (hero.getLife() > 0)
						{//makes sure hero isn't dead yet
							hero.attack(foe);
						}
					}
				}
				runFlag = runChoice(hero);
			}
			if (foe.getLife() <= 0)
			{//only opportunity for level ups are after combat
				System.out.println("You stand valiantly over the dead " + foe.getName() + ".");
				System.out.println("You recieve " + foe.getMoney() + " drops of nectar and " + foe.getExperience() + " experience");
				hero.setMoney(hero.getMoney()+foe.getMoney());
				hero.setExperience(hero.getExperience()+foe.getExperience());
				if(hero.getExperience() >= hero.getLevel()*50)
				{
					hero.levelUp();
					System.out.println("You level up to level " + hero.getLevel() + ".");
				}
				roomEmpty = true;
				roomName = "room with nothing inside";
			}
		}
		else
		{
			System.out.println("There's nothing here anymore.");
		}
	}
	public Boolean runChoice(Hero hero)
	{//this probably gets annoying when it's every turn
		System.out.println("Do you wish to run?");
		System.out.println("1: Yes\n2: No");
		int input = scan.nextInt();
		if(input == 1)
		{
			System.out.println("You choose to run, but the " + foe.getName() + " still gets an attack on you.");
			foe.attack(hero);
			return true;
		}
		else
		{
			return false;
		}
	}
}
