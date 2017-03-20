package view;

import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import values.StatusStrings;

public class PanePlayer implements MainSceneComponent{
	/*
	 *  TODO	Add emblems to pane
	 */
	
	private GridPane playerPane;
	private ProfileImage playerImage;
	private Label lblPlayerName, lblPlayerStatus, lblTurnCnt;
	private Button btnHoverShow;
	
	private final int ROW_CNT = 7;
	private final int COL_CNT = 14;
	
	// Lobby coordinates
	public final static int SCENE_COL = 1;
	public final static int SCENE_ROW = 1;
	public final static int SCENE_COLSPAN = 23;
	public final static int SCENE_ROWSPAN = 8;
		
	// public PanePlayer(Player p) {
	public PanePlayer() {
		this.initPane();
		this.initComp();
	}

	private void initPane() {
		playerPane = new GridPane();
		// playerPane.setGridLinesVisible(true);
		
		for(int i = 0; i < this.COL_CNT; i++) {
			ColumnConstraints colCon = new ColumnConstraints(20);
			if(i == 9)
				colCon = new ColumnConstraints(170);
			else if(i == 10)
				colCon = new ColumnConstraints(50);
			playerPane.getColumnConstraints().add(colCon);
		}
		
		for(int i = 0; i < this.ROW_CNT; i++) {
			RowConstraints rowCon = new RowConstraints(30);
			if(i == 0)
				rowCon = new RowConstraints(12);
			else if(i == 6)
				rowCon = new RowConstraints(20);
			else if(i == 2 || i == 4)
				rowCon = new RowConstraints(15);
			playerPane.getRowConstraints().add(rowCon);
		}
		
		System.out.println(playerPane.getPrefHeight() + " " + playerPane.getWidth());
	}
	
	private void initComp() {
		// Initialize labels, player profile picture, and button
		lblPlayerName = new Label();
		lblPlayerStatus = new Label();
		lblTurnCnt = new Label();
		btnHoverShow = new Button();
		playerImage = new ProfileImage("test");
		
		// Set label and button formatting
		lblPlayerName.setMaxWidth(170);
		lblPlayerName.setFont(Font.font("Garamond", FontWeight.BOLD, 35));
		lblPlayerName.setWrapText(false);
		
		lblPlayerStatus.setMaxWidth(170);
		lblPlayerStatus.setFont(Font.font("Gotham Extra Light", 25));
		lblPlayerStatus.setWrapText(false);
		
		lblTurnCnt.setMaxWidth(170);
		lblTurnCnt.setFont(Font.font("Garamond", FontWeight.BOLD, 25));
		lblTurnCnt.setWrapText(false);
		
		btnHoverShow.setText("Show");
		btnHoverShow.setMinHeight(154);
		btnHoverShow.setMinWidth(30);
		btnHoverShow.setMaxWidth(40);
		
		GridPane.setValignment(playerImage.getProfileImage(), VPos.TOP);
		playerPane.add(playerImage.getProfileImage(), 1, 1, 3, 2);
		GridPane.setValignment(btnHoverShow, VPos.TOP);
		playerPane.add(btnHoverShow, 12, 0, 3, 5);
		GridPane.setValignment(lblPlayerName, VPos.BASELINE);
		playerPane.add(lblPlayerName, 9, 1);
		GridPane.setValignment(lblPlayerStatus, VPos.TOP);
		playerPane.add(lblPlayerStatus, 9, 3);
		GridPane.setValignment(lblTurnCnt, VPos.BOTTOM);
		playerPane.add(lblTurnCnt, 9, 5);
		
		// TESTING PURPOSES
		this.setPlayerNameLbl("Galahad");
		this.setPlayerStatusLbl(StatusStrings.CHOOSING.toString());
		this.setTurnCntLbl(5);
	}
	
	public void setPlayerNameLbl(String name) {
		lblPlayerName.setText(name);
	}
	
	public void setPlayerStatusLbl(String status) {
		lblPlayerStatus.setText(status);
	}
	
	public void setTurnCntLbl(int turn) {
		lblTurnCnt.setText("Turn: " + turn);
	}
	
	public GridPane getPane() {
		return playerPane;
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
}
