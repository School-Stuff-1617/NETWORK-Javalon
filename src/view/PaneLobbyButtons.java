package view;

import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class PaneLobbyButtons implements MainSceneComponent{
	
	private GridPane lobbyButtonsPane;
	private Button btnReady;
	private Button btnExit;

	// Lobby coordinates
	private final int SCENE_COL = 25;
	private final int SCENE_ROW = 1;
	private final int SCENE_COLSPAN = 8;
	private final int SCENE_ROWSPAN = 4;

	// TEMP CONTROLLER
	private SceneWrapper sw;
	
	// public PaneLobbyButtons() {
	public PaneLobbyButtons(SceneWrapper sw){
		this.initComp();
		this.initActions();
		
		this.sw = sw;
	}

	private void initComp() {
		btnReady = new Button();
		btnReady.setText("Ready");
		btnReady.setMinHeight(51);
		btnReady.setMinWidth(120);
		
		btnExit = new Button();
		btnExit.setText("Exit");
		btnExit.setMinHeight(51);
		btnExit.setMinWidth(120);
		
		lobbyButtonsPane = new GridPane();
		lobbyButtonsPane.setVgap(20);
		lobbyButtonsPane.add(btnReady, 0, 0);
		lobbyButtonsPane.add(btnExit, 0, 1);
		
		GridPane.setValignment(lobbyButtonsPane, VPos.TOP);
	}

	private void initActions() {

		btnReady.setOnAction(e -> {
			if(btnReady.getText().equalsIgnoreCase("Ready")) {
				btnReady.setText("Cancel");
				System.out.println("debooging");
				sw.setPhase(SceneWrapper.SET_PHASE_CHOOSE_CARDS);
				// c.setPlayerStatus(StatusStrings.READY.toString());
			}
			else if(btnReady.getText().equalsIgnoreCase("Cancel")) {
				btnReady.setText("Ready");
				// c.setPlayerStatus(StatusStrings.WAITING.toString());
			}
		});
	}
	
	public GridPane getPane() {
		return lobbyButtonsPane;
	}

	@Override
	public int[] getGridCoordinates() {
		// TODO Auto-generated method stub
		int[] coordinates = new int [4];
		coordinates[0] = SCENE_COL;
		coordinates[1] = SCENE_ROW;
		coordinates[2] = SCENE_COLSPAN;
		coordinates[3] = SCENE_ROWSPAN;
		return coordinates;
	}
}
