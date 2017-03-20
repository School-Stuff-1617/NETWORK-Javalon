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

public class PaneCompanion {

	private GridPane companionPane;
	private ProfileImage companionImg;
	private Label lblCompanionName, lblCompanionStatus;
	private Button btnHoverShow;
	
	private final int ROW_CNT = 6;
	private final int COL_CNT = 23;
	
	// public PanePlayer(Player p) {
	public PaneCompanion() {
		this.initPane();
		this.initComp();
	}

	private void initPane() {
		companionPane = new GridPane();
		//companionPane.setGridLinesVisible(true);
		
		for(int i = 0; i < this.COL_CNT; i++) {
			ColumnConstraints colCon = new ColumnConstraints(11);
			if(i == 0)
				colCon = new ColumnConstraints(10);
			companionPane.getColumnConstraints().add(colCon);
		}
		
		for(int i = 0; i < this.ROW_CNT; i++) {
			RowConstraints rowCon = new RowConstraints(25);
			if(i == 0 )
				rowCon = new RowConstraints(4);
			else if(i == 5)
				rowCon = new RowConstraints(8);
			else if(i == 2 || i == 4)
				rowCon = new RowConstraints(5);
			companionPane.getRowConstraints().add(rowCon);
		}
		
		System.out.println(companionPane.getPrefHeight() + " " + companionPane.getWidth());
	}
	
	private void initComp() {
		// Initialize labels, player profile picture, and button
		lblCompanionName = new Label();
		lblCompanionStatus = new Label();
		btnHoverShow = new Button();
		companionImg = new ProfileImage();
		
		// Set label and button formatting
		lblCompanionName.setMaxWidth(170);
		lblCompanionName.setFont(Font.font("Garamond", 28));
		lblCompanionName.setWrapText(false);
		
		lblCompanionStatus.setMaxWidth(170);
		lblCompanionStatus.setFont(Font.font("Gotham Extra Light", 20));
		lblCompanionStatus.setWrapText(false);
		
		btnHoverShow.setText("Show");
		btnHoverShow.setMinHeight(154);
		btnHoverShow.setMinWidth(30);
		btnHoverShow.setMaxWidth(40);
		
		GridPane.setValignment(companionImg.getProfileImage(), VPos.TOP);
		companionPane.add(companionImg.getProfileImage(), 1, 1, 3, 2);
		//GridPane.setValignment(btnHoverShow, VPos.TOP);
		//companionPane.add(btnHoverShow, 12, 0, 3, 5);
		GridPane.setValignment(lblCompanionName, VPos.BASELINE);
		companionPane.add(lblCompanionName, 8, 1, 8, 1);
		GridPane.setValignment(lblCompanionStatus, VPos.TOP);
		companionPane.add(lblCompanionStatus, 8, 3, 13, 1);
		
		// TESTING PURPOSES
		this.setPlayerNameLbl("Freya");
		this.setPlayerStatusLbl(StatusStrings.READY.toString());
	}
	
	public void setPlayerNameLbl(String name) {
		lblCompanionName.setText(name);
	}
	
	public void setPlayerStatusLbl(String status) {
		lblCompanionStatus.setText(status);
	}
	
	public GridPane getPane() {
		return companionPane;
	}
}
