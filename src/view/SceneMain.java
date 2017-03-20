package view;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;import javafx.scene.layout.Border;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import values.StatusStrings;

public class SceneMain implements EventHandler<Event>, SceneContainer {

	private Scene scene;
	private GridPane layout;
	
	// Player pane components (Top)
	// private PanePlayer playerPane;
	
	// Lobby pane components (Right)
	// private VBox lobbyPane;
	// private PaneCompanionList companionPane;
	
	// TEMP CONTROLLER
	private SceneWrapper sw;
		
	public SceneMain(SceneWrapper s) {
		this.initComp();
		this.initActions();
		this.sw = s;
	}
	
	private void initComp() {
		
		layout = new GridPane();
		layout.setHgap(20);
		layout.setVgap(20);
		
		//playerPane = new PanePlayer();
		//companionPane = new PaneCompanionList();
		
		//PaneChooseRoles rolePane = new PaneChooseRoles(10, 4);
		//PaneLobbyButtons plb = new PaneLobbyButtons();
		
		// GridPane.setValignment(rolePane.getPane(), VPos.TOP);
		// layout.add(rolePane.getPane(), 1, 1, 23, 8);
		// layout.add(playerPane.getPane(), 1, 1, 23, 8);
		// layout.add(lobbyPane, 32, 0, 1, 35);
		// layout.add(companionPane.getPane(), 32, 0, 1, 35);
		// GridPane.setValignment(plb.getPane(), VPos.TOP);
		// layout.add(plb.getPane(), 25, 1, 8, 4);
		//layout.add(btnReady, 25, 1, 8, 4);
		//GridPane.setValignment(btnExit, VPos.TOP);
		//layout.add(btnExit, 25, 5, 8, 4);
		// layout.setGridLinesVisible(true);
		
		layout.setGridLinesVisible(true);
		scene = new Scene(layout, 900, 750);
		System.out.println("Initialized");
	}
	
	private void initActions() {
		;
	}
	
	// Method for finding rectangle in gridpane:
	private void moveComponentFrom(int col, int row, int colOffset, int rowOffset) {
		
		for (Node node : layout.getChildren()) {
			if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
				MainSceneComponent nodeToMove = (MainSceneComponent)node;
				
				nodeToMove.adjustSceneMainCol(colOffset);
				nodeToMove.adjustSceneMainRow(rowOffset);
				layout.getChildren().remove(nodeToMove);
				System.out.println("remove");
				addPane((MainSceneComponent) nodeToMove);
				System.out.println("add");
				
				break;
			}
	    }
		
		
		
		//nodeToMove.setPosX()
	   
	}
	
	public void emptyScene() {
		layout.getChildren().clear();
	}
	
	public void addPane(MainSceneComponent pane) {
		int[] gridCoord = pane.getGridCoordinates();
		
		layout.add(pane.getPane(), gridCoord[0], gridCoord[1], gridCoord[2], gridCoord[3]);
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void initExistingPlayers() {
		// load existing players to lobbyPane
	}
	
	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub

	}
}
