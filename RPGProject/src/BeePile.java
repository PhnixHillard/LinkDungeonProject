import java.util.Random;
import java.util.Scanner;
public class BeePile implements Trap{
	private String name;
	private String flavor;
	private int statDecrease;
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	public BeePile(int difficultyMod)
	{//this is incredibly depressing
		name = "Bee Pile";
		flavor = "A pile of dead bees. Seeing them makes you want to cry.";
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
		System.out.println("The bee pile is before you. What do you do?");
		System.out.println("1: Walk through bravely\n2: Avert your eyes (" + hero.getDefense() + "% Success)");
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
	{//just makes your bee sad
		System.out.println("The sight of all of your fallen friends discourages you. Your attack decreases by " + statDecrease + ".");
		hero.setAttack(hero.getAttack()-statDecrease);
	}
	public void trapSkip(Hero hero)
	{
		int result = random.nextInt(100);
		if (result > hero.getDefense())
		{//makes the bee even sadder
			System.out.println("You try to look away and ignore the sight before you, but you fail.");
			trapEffect(hero);
			System.out.println("Your defense also decreases by the same amount.");
			hero.setDefense(hero.getDefense()-statDecrease);
		}
		else
		{//success(the sad kind)
			System.out.println("You manage not to look your fallen friends in the eye. Well done.");
		}
	}
}
