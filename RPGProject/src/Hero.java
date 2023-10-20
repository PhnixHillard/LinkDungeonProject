public class Hero extends Creature {
	private String job;
	private int maximumLife;
	private int inventorySlotsTaken;
	Item[] inventory = new Item[4];//items are stored in an array, one item for each stat
	//the hero is a bee
	public Hero(String playerJob)
	{
		job = playerJob;
		if (job == "Miner") //miner bees start with higher speed
		{
			setAllStats(7,6,5,10,5,1,0);
		}
		if (job == "Carpenter") //carpenter bees start with higher defense
		{
			setAllStats(7,6,10,5,5,1,0);	
		}
		if (job == "Bumble") // bumble bees start with higher life
		{
			setAllStats(10,6,7,5,5,1,0);			
		}
		inventorySlotsTaken = 0;
		setName(job + " Bee");
		maximumLife = getLife();
		for (int i = 0; i < inventory.length; i++)
		{
			Item item = new Item();
			inventory[i] = item;
		}
	}
	public void heal(int recovery)
	{//adds the recovery amount, if the heal would restore above total life, life is just set to the max
		setLife(getLife()+recovery);
		if (getLife() > maximumLife)
		{
			setLife(maximumLife);
		}
	}
	public void equipItem(Item item)
	{//equips an item either in a slot that already holds that item type or in a new slot
		if(searchItem(item.getType()) != -1)
		{//unequips the item if there's an item of that type already
			int index = searchItem(item.getType());
			unequipItem(index);
			inventory[index] = item;
		}
		else
		{//equips the item to a new slot
			inventory[inventorySlotsTaken] = item;
			inventorySlotsTaken++;//keeps track of where to put a new item
		}
		int increase = item.getIncrease(); //apply the stat increase
		if (item.getType() == "Life");
		{
			setLife(getLife()+increase); 
			maximumLife = maximumLife + increase;
		}
		if (item.getType() == "Attack");
		{
			setAttack(getAttack()+increase);
		}
		if (item.getType() == "Defense");
		{
			setDefense(getDefense()+increase);
		}
		if (item.getType() == "Speed");
		{
			setSpeed(getSpeed()+increase);
		}
		
	}
	public int searchItem(String type)
	{//checks if the bee is holding an item of a specific type
		for(int i = 0; i < inventory.length-1; i++)
		{
			if (inventory[i].getType() == type)
			{
				return i;
			}
		}
		return -1;
	}
	public void unequipItem(int index)
	{//removes the buff from an equip and removes the equip from the slot
		int decrease = inventory[index].getIncrease();
		if (inventory[index].getType() == "Life");
		{
			setLife(getLife() - decrease);
			maximumLife = maximumLife - decrease;
		}
		if (inventory[index].getType() == "Attack");
		{
			setAttack(getAttack() - decrease);
		}
		if (inventory[index].getType() == "Defense");
		{
			setDefense(getDefense() - decrease);
		}
		if (inventory[index].getType() == "Speed");
		{
			setSpeed(getSpeed() - decrease);
		}
	}
	public void levelUp()
	{//levels up the bee, different types of bees get stats upgraded at different rates
		setExperience(getExperience()-(50*getLevel()));
		if (job == "Miner")
		{
			setLife(getLife()+3);
			maximumLife = maximumLife+3;
			setAttack(getAttack()+2);
			setDefense(getDefense()+2);
			setSpeed(getSpeed()+4);
			setLevel(getLevel()+1);
		}
		if (job == "Carpenter")
		{
			setLife(getLife()+3);
			maximumLife = maximumLife+3;
			setAttack(getAttack()+2);
			setDefense(getDefense()+4);
			setSpeed(getSpeed()+2);
			setLevel(getLevel()+1);
		}
		if (job == "Bumble")
		{
			setLife(getLife()+4);
			maximumLife = maximumLife+4;
			setAttack(getAttack()+2);
			setDefense(getDefense()+3);
			setSpeed(getSpeed()+2);
			setLevel(getLevel()+1);		
		}
	}
	public int getMaxLife()
	{
		return maximumLife;
	}
	public void setMaxLife(int maxLife)
	{
		maximumLife = maxLife;
	}
	public void printHeroStats()
	{//presents all hero stats
		System.out.println(getName());
		if (getLife() > 0)
		{
			System.out.println("Life: " + getLife() + "/" + maximumLife);
		}
		else 
		{//in case this is your results screen because you died
			System.out.println("Maximum Life: " + maximumLife);
		}
		System.out.println("Attack: " + getAttack());
		System.out.println("Defense: " + getDefense());
		System.out.println("Speed: " + getSpeed());
		System.out.println("Nectar: " + getMoney());
		System.out.println("Level: " + getLevel());
		System.out.println("Experience: " + getExperience());
	}
}
