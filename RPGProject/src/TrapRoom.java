import java.util.Random;
public class TrapRoom implements Room{
	private String name;
	Random random = new Random();
	Trap trap;
	public TrapRoom(int difficultyMod)
	{//random trap gets made venom trap, spider web, honey trap, bee grave
		int trapType = random.nextInt(3);
		if (trapType == 0)
		{
			trap = new BeePile(difficultyMod);
		}
		if (trapType == 1)
		{
			trap = new HoneyPool(difficultyMod);
		}
		if (trapType == 2)
		{
			trap = new SpiderWeb(difficultyMod);
		}
		if (trapType == 3)
		{
			trap = new Venom(difficultyMod);
		}
		name = trap.getName();
	}
	public String getRoomName()
	{
		return name;
	}
	public void getRoomDesc()
	{
		System.out.println(trap.getName());
		System.out.println(trap.getFlavor());
	}
	public void interact(Hero hero)
	{//actual interaction part of the trap, chance to skip doesn't scale with difficulty
		trap.trapChoice(hero);
	}
}
