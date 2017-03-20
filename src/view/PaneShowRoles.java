package view;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import values.Bad;
import values.CardType;
import values.Good;

public class PaneShowRoles implements MainSceneComponent {
	
	private GridPane availRolePane;
	private Label[] lblIncluded;
	
	private Label description;
	private Button btnContinue;
	
	// Lobby coordinates
	private int SCENE_COL = 1;
	private int SCENE_ROW = 10;
	private int SCENE_COLSPAN = 8;
	private int SCENE_ROWSPAN = 4;
	
	private final int ROW_CNT = 3;
	private final int COL_CNT = 6;
	
	public PaneShowRoles() {
		this.initComp();
		this.initActions();
	}
	
	private void initComp() {
		availRolePane = new GridPane();
		
		description = new Label("Cards included in-game:");
		description.setFont(Font.font("Garamond", FontWeight.SEMI_BOLD, 30));
		description.setWrapText(false);
		GridPane.setValignment(description, VPos.TOP);
		
		lblIncluded = new Label[10];
		
		btnContinue = new Button("Continue");
		btnContinue.setMinWidth(150);
		
		GridPane.setHalignment(btnContinue, HPos.RIGHT);
		GridPane.setValignment(btnContinue, VPos.TOP);
		
		// availRolePane.setGridLinesVisible(true);
		GridPane.setValignment(availRolePane, VPos.TOP);
		
		for(int i = 0; i < this.COL_CNT; i++) {
			ColumnConstraints colCon = new ColumnConstraints(100);
			availRolePane.getColumnConstraints().add(colCon);
		}		
		for(int i = 0; i < this.ROW_CNT; i++) {
			RowConstraints rowCon = new RowConstraints(190);
			if(i == 0)
				rowCon = new RowConstraints(50);
			availRolePane.getRowConstraints().add(rowCon);
		}
		
		availRolePane.add(description, 0, 0, 3, 1);
		availRolePane.add(btnContinue, 4, 0, 3, 1);
	}
	
	private void initActions() {
		
	}
	
	public void setIncluded(CardType[] included) {
		int count = 0;
		
		for(int i = 0; i < included.length; i++) {
			lblIncluded[i] = new Label("", new ImageView(included[i].getCard()));
		}
		
		for(int i = 0; i < ROW_CNT && count != included.length; i++) {
			for(int j = 0; j < COL_CNT - 1 && count != included.length; j++) {
				availRolePane.add(lblIncluded[count], j, i + 1);
				System.out.println("add");
				count++;
			}
		}
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
		return availRolePane;
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
