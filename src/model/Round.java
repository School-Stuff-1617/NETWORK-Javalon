package model;

public class Round {
	private Character leader;
	private Character[] characters;
	private boolean status;
	private Quest quest;
	
	public Round(Character leader, Quest quest) {
		// TODO Auto-generated constructor stub
		this.leader = leader;
		characters = new Character[quest.getCharacterCnt()];
		status = false;
		this.quest = quest;
	}
}
