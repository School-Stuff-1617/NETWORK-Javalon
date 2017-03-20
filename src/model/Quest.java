package model;

public class Quest {
	private Character[] characters;
	private int characterCnt;
	private boolean success;
	private int toFailCnt;
	
	public Quest(int characterCnt, int toFailCnt) {
		// TODO Auto-generated constructor stub
		characters = new Character[characterCnt];
		this.characterCnt = characterCnt;
		success = false;
		this.toFailCnt = toFailCnt;
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
