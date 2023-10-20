
public class Shop implements Room{

	Merchant mothMerchant;
	String roomName;
	public Shop(int difficultyMod)
	{
		mothMerchant = new Merchant(difficultyMod);
		roomName = "shop";
	}
	public String getRoomName()
	{
		return roomName;
	}
	public void getRoomDesc()
	{
		System.out.println("A shop!");
		System.out.println("A lovely little moth is running it. He'll trade nectar for equipment.");
	}
	public void interact(Hero hero)
	{//show and shop
		mothMerchant.showWares();
		mothMerchant.shop(hero);
	}
}
