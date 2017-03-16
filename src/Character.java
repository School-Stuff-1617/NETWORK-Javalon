
public class Character {
	private Player player;
	private CardType cardType;
	private String team;
	
	public Character(Player player, CardType cardType) {
		// TODO Auto-generated constructor stub
		this.player = player;
		this.cardType = cardType;
		if(cardType instanceof Good)
			this.team = "good";
		else
			this.team = "bad";
	}
	
	
}
