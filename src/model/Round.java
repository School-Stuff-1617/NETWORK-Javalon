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
	
	public void setLeader(Character leader) {
		this.leader = leader;
	}
	
	public void setCharacters(Character[] characters) {
		this.characters = characters;
	}
	
	public void setQuest(Quest quest) {
		this.quest = quest;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Character[] getCharacters() {
		return characters;
	}
	
	public Character getLeader() {
		return leader;
	}
	
	public Quest getQuest() {
		return quest;
	}
	
	public boolean getStatus() {
		return status;
	}
}
