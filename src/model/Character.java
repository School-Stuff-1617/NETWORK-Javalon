package model;

import values.CardType;
import values.Good;

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
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public CardType getCardType() {
		return cardType;
	}
	
	public String getTeam() {
		return team;
	}
}
