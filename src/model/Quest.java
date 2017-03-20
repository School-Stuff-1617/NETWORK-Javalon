package model;

public class Quest {
	private int questNo;
	private Character[] characters;
	private int characterCnt;
	private boolean success;
	private int toFailCnt;
	
	public Quest(int questNo, int characterCnt) {
		// TODO Auto-generated constructor stub
		this.questNo = questNo;
		this.characters = new Character[characterCnt];
		this.characterCnt = characterCnt;
		this.success = false;
		this.toFailCnt = 1;
	}
	
	public Quest(int questNo, int characterCnt, int toFailCnt) {
		// TODO Auto-generated constructor stub
		this.questNo = questNo;
		characters = new Character[characterCnt];
		this.characterCnt = characterCnt;
		success = false;
		this.toFailCnt = toFailCnt;
	}
	
	public void setQuestNo(int questNo) {
		this.questNo = questNo;
	}
	
	public void setCharacters(Character[] characters) {
		this.characters = characters;
	}
	
	public void setCharacterCnt(int characterCnt) {
		this.characterCnt = characterCnt;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public void setToFailCnt(int toFailCnt) {
		this.toFailCnt = toFailCnt;
	}
	
	public int getQuestNo() {
		return questNo;
	}
	
	public Character[] getCharacters() {
		return characters;
	}
	
	public int getCharacterCnt() {
		return characterCnt;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public int getToFailCnt() {
		return toFailCnt;
	}
}
