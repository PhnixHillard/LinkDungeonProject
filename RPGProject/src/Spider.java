 import java.util.Random;
public class Spider extends Creature implements Enemy{
	
	private Random random = new Random();
	private String name;
	private String adj;
	
	public Spider(int difficultyMod)
	{//Spiders are fast
		setAllStats(10, 4, 5, 8, 5, 1, 25);
		name = "Spider";
		setDescriptor(difficultyMod);
	}
	public void buffEnemy(int buffMod)
	{
		setLife(getLife()+(2*buffMod));
		setAttack(getAttack()+(1*buffMod));
		setDefense(getDefense()+(1*buffMod));
		setSpeed(getSpeed()+(3*buffMod));
		setMoney(getMoney()+(3*buffMod));
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
			adj = "Restless";
			buffEnemy(difficultyMod+1);
		}
		if (desc > 3 && desc <= 5) {
			adj = "Watchful";
			buffEnemy(difficultyMod+1);
		}
		if (desc == 6) {
			adj = "Meticulous";
			buffEnemy(difficultyMod+2);
		}
		if (desc > 6) {
			adj = "Sadistic";
			buffEnemy(difficultyMod+3);
		}
		setName(adj + " " + name);
	}
	public void makeBoss(int difficultyMod)
	{//creates a boss
		adj = "Monstrous";
		buffEnemy(difficultyMod*2);
		if (difficultyMod == 0)
		{//first floor boss is only slightly buffed
			buffEnemy(1);
		}
		setName(adj + " " + name);
	}
}
