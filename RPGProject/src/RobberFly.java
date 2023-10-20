import java.util.Random;
public class RobberFly extends Creature implements Enemy {

	private Random random = new Random();
	private String name;
	private String adj;
	
	public RobberFly(int difficultyMod)
	{//Robber Flies have attack as their highest stat
		setAllStats(10, 7, 6, 7, 15, 1, 20);
		name = "Robber Fly";
		setDescriptor(difficultyMod);
	}
	public void buffEnemy(int buffMod)
	{
		setLife(getLife()+(2*buffMod));
		setAttack(getAttack()+(3*buffMod));
		setDefense(getDefense()+(2*buffMod));
		setSpeed(getSpeed()+(2*buffMod));
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
			adj = "Regular";
			buffEnemy(difficultyMod);
			}
		if (desc > 1 && desc <= 3) {
			adj = "Hateful";
			buffEnemy(difficultyMod+1);
		}
		if (desc > 3 && desc <= 5) {
			adj = "Predatory";
			buffEnemy(difficultyMod+2);
		}
		if (desc == 6) {
			adj = "Homicidal";
			buffEnemy(difficultyMod+3);
		}
		if (desc > 6) {
			adj = "Slaughterous";
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
