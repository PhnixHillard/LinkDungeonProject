import java.util.Random;
public class Mantis extends Creature implements Enemy {
	
	private Random random = new Random();
	private String name;
	private String adj;
	
	public Mantis(int difficultyMod)
	{//Mantises have speed as their highest stat
		setAllStats(15, 10, 7, 9, 3, 1, 30);
		name = "Mantis";
		setDescriptor(difficultyMod);
	}
	public void buffEnemy(int buffMod)
	{
		setLife(getLife()+(2*buffMod));
		setAttack(getAttack()+(2*buffMod));
		setDefense(getDefense()+(1*buffMod));
		setSpeed(getSpeed()+(3*buffMod));
		setMoney(getMoney()+(2*buffMod));
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
			adj = "Stoic";
			buffEnemy(difficultyMod+1);
		}
		if (desc > 3 && desc <= 5) {
			adj = "Prideful";
			buffEnemy(difficultyMod+1);
		}
		if (desc == 6) {
			adj = "Focused";
			buffEnemy(difficultyMod+2);
		}
		if (desc > 6) {
			adj = "Vigilant";
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
