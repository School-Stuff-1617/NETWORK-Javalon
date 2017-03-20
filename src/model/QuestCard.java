package model;
import java.util.ArrayList;

public class QuestCard {
	private int characterCnt;
	private int minionCnt;
	private int successCnt;
	private int questCnt;
	private int voteCnt;

	private Quest[] quests;
	private ArrayList<Round> rounds;

	public QuestCard(int characterCnt) {
		// TODO Auto-generated constructor stub
		this.characterCnt = characterCnt;
		this.minionCnt = getMinionCnt(this.characterCnt);
		this.successCnt = 0;
		this.questCnt = 0;
		this.voteCnt = 0;

		quests = new Quest[5];
		rounds = new ArrayList<>();

		instantiateQuests();
	}
	
	public void setCharacterCnt(int characterCnt) {
		this.characterCnt = characterCnt;
	}
	
	public void setMinionCnt(int minionCnt) {
		this.minionCnt = minionCnt;
	}
	
	public void setQuestCnt(int questCnt) {
		this.questCnt = questCnt;
	}
	
	public void setSuccessCnt(int successCnt) {
		this.successCnt = successCnt;
	}
	
	public void setVoteCnt(int voteCnt) {
		this.voteCnt = voteCnt;
	}
	
	public void setQuests(Quest[] quests) {
		this.quests = quests;
	}
	
	public void setRounds(ArrayList<Round> rounds) {
		this.rounds = rounds;
	}
	
	public int getCharacterCnt() {
		return characterCnt;
	}
	
	public int getMinionCnt() {
		return minionCnt;
	}
	
	public int getQuestCnt() {
		return questCnt;
	}
	
	public int getSuccessCnt() {
		return successCnt;
	}
	
	public int getVoteCnt() {
		return voteCnt;
	}
	
	public Quest[] getQuests() {
		return quests;
	}
	
	public ArrayList<Round> getRounds() {
		return rounds;
	}

	public static int getMinionCnt(int characterCnt) {
		switch (characterCnt) {
		case 5:
		case 6:
			return 2;
		case 7:
		case 8:
		case 9:
			return 3;
		case 10:
			return 4;
		}
		return 0;
	}

	private void instantiateQuests() {
		switch (this.characterCnt) {
		case 5:
			quests[0] = new Quest(1, 2);
			quests[1] = new Quest(2, 3);
			quests[2] = new Quest(3, 2);
			quests[3] = new Quest(4, 3);
			quests[4] = new Quest(5, 3);
			break;
		case 6:
			quests[0] = new Quest(1, 2);
			quests[1] = new Quest(2, 3);
			quests[2] = new Quest(3, 4);
			quests[3] = new Quest(4, 3);
			quests[4] = new Quest(5, 4);
			break;
		case 7:
			quests[0] = new Quest(1, 2);
			quests[1] = new Quest(2, 3);
			quests[2] = new Quest(3, 3);
			quests[3] = new Quest(4, 4, 2);
			quests[4] = new Quest(5, 4);
			break;
		case 8:
			quests[0] = new Quest(1, 3);
			quests[1] = new Quest(2, 4);
			quests[2] = new Quest(3, 4);
			quests[3] = new Quest(4, 5, 2);
			quests[4] = new Quest(5, 5);
			break;
		case 9:
			quests[0] = new Quest(1, 3);
			quests[1] = new Quest(2, 4);
			quests[2] = new Quest(3, 4);
			quests[3] = new Quest(4, 5, 2);
			quests[4] = new Quest(5, 5);
			break;
		case 10:
			quests[0] = new Quest(1, 3);
			quests[1] = new Quest(2, 4);
			quests[2] = new Quest(3, 4);
			quests[3] = new Quest(4, 5, 2);
			quests[4] = new Quest(5, 5);
			break;

		default:
			break;
		}
	}
}