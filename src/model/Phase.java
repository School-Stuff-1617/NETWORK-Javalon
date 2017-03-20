package model;
import java.util.ArrayList;
import java.util.Random;

import values.CardType;

public class Phase {
	private QuestCard questCard;
	private Character[] characters;
	private int turn;
	
	public Phase(Player[] players) {
		// TODO Auto-generated constructor stub
		questCard = new QuestCard(players.length);
		characters = new Character[players.length];
		turn = 0;
		
		//instantiateCharacters();
	}
	
	public Phase(Player[] players, ArrayList<CardType> cardTypes) {
		// TODO Auto-generated constructor stub
		questCard = new QuestCard(players.length);
		characters = new Character[players.length];
		turn = 0;
		
		instantiateCharacters(players, cardTypes);
	}
	
	private void instantiateCharacters(Player[] players, ArrayList<CardType> cardTypes) {
		/*insert code here IF needed*/
		Random r = new Random();
		
		for(int i = 0; i < characters.length; i++) {
			characters[i] = new Character(players[i], cardTypes.remove(r.nextInt(players.length)));
		}
	}
	
	public void setQuestCard(QuestCard questCard) {
		this.questCard = questCard;
	}
	
	public void setCharacters(Character[] characters) {
		this.characters = characters;
	}
	
	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	public QuestCard getQuestCard() {
		return questCard;
	}
	
	public Character[] getCharacters() {
		return characters;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public void nextTurn() {
		turn++;
	}
}
