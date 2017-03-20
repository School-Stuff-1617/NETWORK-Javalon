package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import values.CardType;

public class SceneWrapper extends Application {
	
	private Stage stage;
	
	private SceneTitle sTitle;
	private SceneMain sMain;
	
	private PanePlayer pPlayer;
	private PaneLobbyButtons pLButtons;
	private PaneCompanionList pCompList;
	private PaneChooseRoles pChooseRoles;
	private PaneShowRoles pShowRoles;
	
	public static final int SET_PHASE_LOBBY = 1;
	public static final int SET_PHASE_CHOOSE_CARDS = 2;
	public static final int SET_PHASE_SHOW_ROLES = 3;
	
	public SceneWrapper() {
		sTitle = new SceneTitle(this);
		sMain = new SceneMain(this);
		
		pPlayer = new PanePlayer();
		pLButtons = new PaneLobbyButtons(this);
		pCompList = new PaneCompanionList();
		pChooseRoles = new PaneChooseRoles(this, 6, 2); // 10 players, 4 minions
		pShowRoles = new PaneShowRoles();
	}
	
	public void setToTitle() {
		stage.setScene(sTitle.getScene());
	}
	
	public void setToLobby() {
		stage.setScene(sMain.getScene());
		this.setPhase(SET_PHASE_CHOOSE_CARDS);
	}

	public void setPhase(int setPhase) {
		if(setPhase == SET_PHASE_LOBBY) {
			sMain.emptyScene();
			sMain.addPane(pPlayer);
			sMain.addPane(pLButtons);
			sMain.addPane(pCompList);
		}
		else if(setPhase == SET_PHASE_CHOOSE_CARDS) {
			// if admin
			sMain.emptyScene();
			sMain.addPane(pChooseRoles);
			sMain.addPane(pCompList);
			// if not admin
		}
		else if(setPhase == SET_PHASE_SHOW_ROLES) {
			sMain.emptyScene();
			sMain.addPane(pPlayer);
			sMain.addPane(pCompList);
			sMain.addPane(pShowRoles);
		}
		
	}
	
	// MOVE TO CONTROLLER
	public void setIncludedCards(CardType[] included) {
		pShowRoles.setIncluded(included);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		stage = primaryStage;
		
		primaryStage.setResizable(false);
		primaryStage.setTitle("The Resistance: Javalon");
		primaryStage.setMaxWidth(900);
		primaryStage.setMaxHeight(750);
		
		// this.setToTitle();
		this.setToLobby();
		
		primaryStage.show();	
	}
}
