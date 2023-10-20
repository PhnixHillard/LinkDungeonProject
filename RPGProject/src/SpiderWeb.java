import java.util.Random;
import java.util.Scanner;
public class SpiderWeb implements Trap{
	private String name;
	private String flavor;
	private int statDecrease;
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	public SpiderWeb(int difficultyMod)
	{
		name = "Spider Web";
		flavor = "A spider web, the spider is nowhere to be seen.";
		statDecrease = 1+difficultyMod;
	}
	public String getName()
	{
		return name;
	}
	public String getFlavor()
	{
		return flavor;
	}
	public void trapChoice(Hero hero)
	{//choice to skip
		System.out.println("The spider web is before you, what do you do?");
		System.out.println("1: Go through normally\n2: Attempt to cut through it (" + hero.getAttack() + "% Success)");
		int choice = scan.nextInt();
		if (choice == 2)
		{
			trapSkip(hero);
		}
		else
		{
			trapEffect(hero);
		}
	}
	public void trapEffect(Hero hero)
	{//speed decrease
		System.out.println("You get caught in the spider web and slowed.\nYour speed decreases by " + statDecrease + ".");
		hero.setSpeed(hero.getSpeed()-statDecrease);
	}
	public void trapSkip(Hero hero)
	{//contests the random result with hero's attack
		System.out.println("You attempt to slice through the spider web.");
		int result = random.nextInt(100);
		if (result > hero.getAttack())
		{//failure makes the effect twice as bad
			System.out.println("You fail to cut through it, it's just too durable for you.");
			System.out.println("You get tangled in the web much worse than you would've had you not tried that.");
			System.out.println("Your speed decreases by " + statDecrease*2 + ".");
			hero.setSpeed(hero.getSpeed()-(statDecrease*2));
		}
		else
		{//success
			System.out.println("You manage to cut a path clean through the web.");
			System.out.println("It likely won't be long before it's fixed, but you're safe for now. Well done.");
		}
	}
}
