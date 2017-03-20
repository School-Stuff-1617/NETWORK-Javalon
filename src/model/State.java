package model;
import java.util.ArrayList;

import values.CardType;

public class State {
	private int code;
	private int playerCnt;
	private ArrayList<Player> players;
	private ArrayList<CardType> cardTypes;
	private Phase phase;

	private static int ctr = 0;

	public State(int playerCnt, ArrayList<CardType> cardTypes) {
		// TODO Auto-generated constructor stub
		this.code = getId();
		this.playerCnt = playerCnt;
		this.players = new ArrayList<>();
		phase = null;
	}
	
	public State(int playerCnt, ArrayList<CardType> cardTypes, ArrayList<Player> players) {
		// TODO Auto-generated constructor stub
		this.code = getId();
		this.playerCnt = playerCnt;
		this.players = new ArrayList<>();
		for(Player p : players) {
			addPlayer(p);
		}
		phase = null;
	}

	/*
	 * public void setPlayers(Player[] players) { this.players = players; }
	 */
	public boolean addPlayer(Player player) {
		if (this.players.size() >= playerCnt)
			return false;
		this.players.add(player);
		return true;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}
	
	public int getCode() {
		return code;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public Phase getPhase() {
		return phase;
	}

	public void startPhase() {
		Player[] players = new Player[playerCnt];

		for (int i = 0; i < playerCnt; i++) {
			players[i] = this.players.get(i);
		}

		phase = new Phase(players, cardTypes);
	}
	
	public boolean isCodeEqualTo(int code) {
		return this.code == code;
	}

	private static int getId() {

		int id = Integer
				.parseInt(String.valueOf(System.currentTimeMillis()).substring(1, 10).concat(String.valueOf(ctr)));
		ctr = (ctr + 1) % 10;
		return id;
	}
}
