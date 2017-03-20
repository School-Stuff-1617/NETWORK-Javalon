package view;

import javafx.scene.layout.Pane;

public interface MainSceneComponent {
	
	public int[] getGridCoordinates();
	public void adjustSceneMainCol(int adjustment);
	public void adjustSceneMainRow(int adjustment);
	public Pane getPane();
	
}
