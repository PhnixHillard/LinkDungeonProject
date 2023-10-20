
public class Creature {//the hero and all the enemies are creatures
	//all of the stats
	private int life;
	private int attack;
	private int defense;
	private int speed;
	private int money;
	private int level;
	private int experience;
	private String name;
	
	public Creature()
	{
		life = 0;
		attack = 0;
		defense = 0;
		speed = 0;
		money = 0;
		level = 0;
		experience = 0;
	}
	public Creature(int userLife, int userAttack, int userDefense, int userSpeed, int userMoney, int userLevel, int userExperience)
	{//each creature has individual stats, all of them are different
		life = userLife;
		attack = userAttack;
		defense = userDefense;
		speed = userSpeed;
		money = userMoney;
		level = userLevel;
		experience = userExperience;
	}
	//all the getters and setters
	public void setAllStats(int userLife, int userAttack, int userDefense, int userSpeed, int userMoney, int userLevel, int userExperience)
	{//each creature has individual stats, all of them are different
		life = userLife;
		attack = userAttack;
		defense = userDefense;
		speed = userSpeed;
		money = userMoney;
		level = userLevel;
		experience = userExperience;
	}
	public int getLife()
	{
		return life;
	}
	public void setLife(int userLife)
	{
		life = userLife;
	}
	public int getAttack()
	{
		return attack;
	}
	public void setAttack(int userAttack)
	{
		attack = userAttack;
	}
	public int getDefense()
	{
		return defense;
	}
	public void setDefense(int userDefense)
	{
		defense = userDefense;
	}
	public int getSpeed()
	{
		return speed;
	}
	public void setSpeed(int userSpeed)
	{
		speed = userSpeed;
	}
	public int getMoney()
	{
		return money;
	}
	public void setMoney(int userMoney)
	{
		money = userMoney;
	}
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int userLevel)
	{
		level = userLevel;
	}
	public int getExperience()
	{
		return experience;
	}
	public void setExperience(int userExperience)
	{
		experience = userExperience;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String userName)
	{
		name = userName;
	}
	public void attack(Creature otherCreature)
	{//All creatures are able to attack
		System.out.println(getName() + " attacks " + otherCreature.getName() + ".");
		int damage = 0;
		if (attack > otherCreature.getDefense())
		{//defense reduces damage
			damage = attack - otherCreature.getDefense();
			otherCreature.setLife(otherCreature.getLife()-damage);
		}
		else if (attack == otherCreature.getDefense())
		{//if the defense and attack are the same, creature still deals 1 damage, pity damage
			damage = 1;
			otherCreature.setLife(otherCreature.getLife()-damage);
		}
		System.out.println(otherCreature.getName() + " takes " + damage + " damage.");
	}
}
