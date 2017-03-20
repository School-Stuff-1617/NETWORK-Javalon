package model;
import java.util.ArrayList;

import javafx.scene.image.Image;
import values.CardType;

public class ModelController {
	private ArrayList<State> state;
	private State currentState;
	private Player player;
	
	public ModelController() {
		// TODO Auto-generated constructor stub
		state = new ArrayList<>();
		currentState = null;
		player = null;
	}
	
	public void createPlayer(String name) {
		this.player = new Player(name);
	}
	
	public void createPlayer(String name, Image image) {
		this.player = new Player(name, image);
	}
	
	public void createState(int playerCnt, ArrayList<CardType> cardTypes) {
		currentState = new State(playerCnt, cardTypes);
		this.state.add(currentState);
	}
	
	public boolean joinState(int code) {
		for(State s : state) {
			if(s.isCodeEqualTo(code)) {
				currentState = s;
				return true;
			}
		}
		return false;
	}
}
