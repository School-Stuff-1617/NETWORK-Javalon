package view;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class PaneQuestBoard implements MainSceneComponent {

	private GridPane pane;

	// Lobby coordinates
	private final int SCENE_COL = 1;
	private final int SCENE_ROW = 10;
	private final int SCENE_COLSPAN = 8;
	private final int SCENE_ROWSPAN = 4;

	private final int ROW_CNT = 3;
	private final int COL_CNT = 6;
	
	public PaneQuestBoard() {
		this.initComp();
	}
	
	private void initComp() {
		
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
	public Pane getPane() {
		return pane;
	}

}
