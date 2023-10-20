import java.util.Random;
import java.util.Scanner;
public class HoneyPool implements Trap{
	private String name;
	private String flavor;
	private int statDecrease;
	private int healing;
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	public HoneyPool(int difficultyMod)
	{
		name = "Honey Pool";
		flavor = "A large pool of honey, looks delicious";
		statDecrease = 1+difficultyMod;
		healing = 2+(2*difficultyMod);
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
	{//choice to "skip," really just a chance to only get the positive effect
		System.out.println("The honey pool is before you. What do you do?");
		System.out.println("1: Indulge\n2: Indulge carefully (" + hero.getLife() + "% Success)");
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
	{//heals some and decreases speed some
		System.out.println("You partake of the honey. It's delicious and you regain " + healing + " life.");
		System.out.println("Some of the honey also sticks to you, slowing you down by " + statDecrease + ".");
		hero.heal(healing);
		hero.setSpeed(hero.getSpeed()-statDecrease);
	}
	public void trapSkip(Hero hero)
	{
		int result = random.nextInt(100);
		if (result > hero.getLife())
		{//twice the healing, twice the speed loss
			System.out.println("You are simply too hungry and you eat twice as much honey as would've had you not tried to resist");
			System.out.println("You gain " + healing*2 + " life and lose " + statDecrease*2 + " speed.");
			hero.heal(healing*2);
			hero.setSpeed(hero.getSpeed()-statDecrease*2);
		}
		else
		{//only the healing effect, nice
			System.out.println("You're able to avoid eating too much or getting the honey stuck to you. Well done.");
			System.out.println("You regain " + healing + " life.");
			hero.heal(healing);
		}
	}
}
