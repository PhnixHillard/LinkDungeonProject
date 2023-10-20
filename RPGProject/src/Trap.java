
public interface Trap {
	public String getName();
	public String getFlavor();
	public void trapChoice(Hero hero);
	public void trapEffect(Hero hero);
	public void trapSkip(Hero hero);
}
