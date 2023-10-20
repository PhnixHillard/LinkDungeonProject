import java.util.Random;
public class Item {
	private String statIncreaseType;
	private String itemName;
	private String flavor;
	private int statIncrease;
	private int price;
	Random random = new Random();
	public Item()
	{//the dreaded null item
		statIncreaseType = "";
		itemName = "";
		statIncrease = 0;
		price = 0;
	}
	public Item(int difficultyMod)
	{//random stat, cost is based on stat increase
		int statIncreaseMod = random.nextInt(difficultyMod+5);
		statIncreaseType = "";
		itemName = "";
		statIncrease = statIncreaseMod+2;
		price = statIncrease*3;
	}
	//getters and setters
	public String getType()
	{
		return statIncreaseType;
	}
	public void setType(String type)
	{
		statIncreaseType = type;
	}
	public String getName()
	{
		return itemName;
	}
	public void setName(String name)
	{
		itemName = name;
		if (itemName == "Magic Pollen")
		{
			setType("Life");
			flavor = "magic pollen that will improve your max life.";
		}
		if (itemName == "Sword")
		{
			setType("Attack");
			flavor = "a sword, made to bee scale, it will increase your attack.";
		}
		if (itemName == "Armor")
		{
			setType("Defense");
			flavor = "a suit of armor for your little bee body, it will increase defense.";
		}
		if (itemName == "Boots")
		{
			setType("Speed");
			flavor = "a pair of boots, they'll help you move faster, they increase speed";
		}
	}
	public int getIncrease()
	{
		return statIncrease;
	}
	public void setIncrease(int increase)
	{
		statIncrease = increase;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int cost)
	{
		price = cost;
	}
	public String getFlavor()
	{
		return flavor;
	}
	public void getEverything()
	{
		System.out.println(itemName + ", will increase " + statIncreaseType + " by " + statIncrease);
	}
}
