import java.util.Random;
import java.util.Scanner;
public class Venom implements Trap{
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	private String name;
	private String flavor;
	private int statDecrease;
	private int venomType;
	public Venom(int difficultyMod)
	{
		venomType = random.nextInt(1);
		name = "Venom puddle";
		if(venomType == 0)
		{//this venom type will decrease your defense
			flavor = "A puddle of venom from a wasp's stinger.";
		}
		if(venomType == 1)
		{//this venom type will decrease your life and max life
			flavor = "A puddle of venom from a robber fly's mouth.";
		}
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
		System.out.println("The venom puddle is before you. What do you do?");
		System.out.println("1: Go through normally\n2: Attempt to avoid the puddle (" + hero.getSpeed() + "% Success)");
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
	{//different stats are effected based on venom type
		if(venomType == 0)
		{
			System.out.println("The venom burns against your body, your defense has decreased by " + statDecrease + ".");
			hero.setDefense(hero.getDefense()-statDecrease);
		}
		if(venomType == 1)
		{
			System.out.println("The venom stings harshly, your maximum and current life have decreased by " + statDecrease + ".");
			hero.setLife(hero.getLife()-statDecrease);
			hero.setMaxLife(hero.getMaxLife()-statDecrease);
		}
	}
	public void trapSkip(Hero hero)
	{//contests speed with random result
		int result = random.nextInt(100);
		if(result >= hero.getSpeed())
		{//no real downside to skipping this trap
			System.out.println("You fail to avoid the puddle. How unfortunate");
			trapEffect(hero);
		}
		else
		{//success
			System.out.println("You gracefully avoid the puddle. Well done.");
		}
	}
}
