import java.util.Random;
public class Hornet extends Creature implements Enemy{
	
	private Random random = new Random();
	private String name;
	private String adj;
	
	public Hornet(int difficultyMod)
	{//Hornets have attack as their highest stat
		setAllStats(10, 9, 5, 6, 10, 1, 25);
		name = "Hornet";
		setDescriptor(difficultyMod);
	}
	public void buffEnemy(int buffMod)
	{
		setLife(getLife()+(2*buffMod));
		setAttack(getAttack()+(3*buffMod));
		setDefense(getDefense()+(1*buffMod));
		setSpeed(getSpeed()+(1*buffMod));
		setMoney(getMoney()+(5*buffMod));
		setLevel(getLevel()+buffMod);
		setExperience(getExperience()+(3*buffMod));
	}
	public void setDescriptor(int difficultyMod)
	{//Selects a random adjective from list and adjusts mob difficulty accordingly, weighted
		int desc;
		if (difficultyMod!= 0)
		{
			desc = random.nextInt(difficultyMod);
		}
		else
		{
			desc = 0;
		}
		if (desc <= 1) {
			adj = "Normal";
			buffEnemy(difficultyMod);
			}
		if (desc > 1 && desc <= 3) {
			adj = "Wrathful";
			buffEnemy(difficultyMod+1);
		}
		if (desc > 3 && desc <= 5) {
			adj = "Spiteful";
			buffEnemy(difficultyMod+1);
		}
		if (desc == 6) {
			adj = "Ferocious";
			buffEnemy(difficultyMod+2);
		}
		if (desc > 6) {
			adj = "Unhinged";
			buffEnemy(difficultyMod+3);
		}
		setName(adj + " " + name);
	}
	public void makeBoss(int difficultyMod)
	{
		adj = "Monstrous";
		buffEnemy(difficultyMod*2);
		if (difficultyMod == 0)
		{
			buffEnemy(1);
		}
		setName(adj + " " + name);
	}
}
