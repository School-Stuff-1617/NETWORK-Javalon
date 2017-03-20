package view;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class PaneQuestBoard implements MainSceneComponent {

	private GridPane pane;

	// Lobby coordinates
	private int SCENE_COL = 1;
	private int SCENE_ROW = 10;
	private int SCENE_COLSPAN = 8;
	private int SCENE_ROWSPAN = 4;

	private int ROW_CNT = 3;
	private int COL_CNT = 6;
	
	
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
