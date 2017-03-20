package view;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PaneCompanionList implements MainSceneComponent{

	// Lobby pane components (Right)
	private VBox companionPane;
	private PaneCompanion[] companionArr;
	
	private int enemyCount;
	
	// Lobby coordinates
	public int SCENE_COL = 32;
	public int SCENE_ROW = 0;
	public final int SCENE_COLSPAN = 1;
	public final int SCENE_ROWSPAN = 35;
	
	// TEMP CONTROLLER
	SceneWrapper sw;
	
	public PaneCompanionList(SceneWrapper sw) {
		this.initComp();
		this.initActions();
		
		this.sw = sw;
	}
	
	private void initComp() {
		companionArr = new PaneCompanion[9];
		enemyCount = 0;
		
		companionPane = new VBox(1);
		companionPane.setMinWidth(200);
		companionPane.setMinHeight(750);
		companionPane.setAlignment(Pos.CENTER_LEFT);
				
		// TEST 
		for(int i = 0; i < 9; i++) {
			companionPane.getChildren().add(new PaneCompanion().getPane());
		}
	}
	
	private void initActions() {
		System.out.println("mouse action");
		companionPane.setOnMouseEntered(e -> {
			System.out.println("enter");
			SCENE_COL -= 1;
			sw.setPhase(SceneWrapper.SET_PHASE_LOBBY);
		});
		companionPane.setOnMouseExited(e -> {
			System.out.println("exit");
			SCENE_COL += 1;
			sw.setPhase(SceneWrapper.SET_PHASE_LOBBY);
		});
	}
		
	public Pane getPane() {
		return companionPane;
	}

	@Override
	public int[] getGridCoordinates() {
		int[] coordinates = new int [4];
		coordinates[0] = SCENE_COL;
		coordinates[1] = SCENE_ROW;
		coordinates[2] = SCENE_COLSPAN;
		coordinates[3] = SCENE_ROWSPAN;
		return coordinates;
	}

	@Override
	public void adjustSceneMainCol(int adjustment) {
		// TODO Auto-generated method stub
		this.SCENE_COL += adjustment;
	}

	@Override
	public void adjustSceneMainRow(int adjustment) {
		// TODO Auto-generated method stub
		this.SCENE_ROW += adjustment;
	}
}
