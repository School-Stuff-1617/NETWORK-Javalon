package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import values.Bad;
import values.CardType;
import values.Good;

public class PaneChooseRoles implements MainSceneComponent{

	private GridPane rolePane;
	private GridPane servantPane, minionPane;
	
	private ToggleButton[] servantSelect, minionSelect;
	private ScrollPane servantScroll, minionScroll;
	private Button btnContinue;
	private Label lblChooseServant, lblChooseMinion, lblLeftServant, lblLeftMinion;
	
	private HBox servantHBox, minionHBox;
	
	private final int ROW_CNT = 5;
	private final int COL_CNT = 62;
	
	private int selectedServants;
	private int selectedMinions;
	
	private int totalPlayers;
	private int totalMinions;
	
	// Lobby coordinates
	public int SCENE_COL = 1;
	public int SCENE_ROW = 1;
	public int SCENE_COLSPAN = 23;
	public int SCENE_ROWSPAN = 8;
			
	// TEMP  
	// TEMP CONTROLLER
	private SceneWrapper sw;
		
	public PaneChooseRoles(SceneWrapper sw, int players, int minions) {
		this.initPanes();
		this.initComp(players, minions);
		this.addComp();
		this.initActions();
		
		this.sw = sw;
	}
	
	private void initPanes() {
		rolePane = new GridPane();
		servantPane = new GridPane();
		minionPane = new GridPane();
		
		GridPane.setValignment(rolePane, VPos.TOP);
		
		// rolePane.setGridLinesVisible(true);
		//servantPane.setGridLinesVisible(true);
		//minionPane.setGridLinesVisible(true);
		
		for(int i = 0; i < this.ROW_CNT; i++) {
			RowConstraints rowCon = new RowConstraints(5);
			if(i == 1)
				rowCon = new RowConstraints(29);
			else if(i == 3)
				rowCon = new RowConstraints(240);
			else if(i == 4)
				rowCon = new RowConstraints(20);
			servantPane.getRowConstraints().add(rowCon);
			minionPane.getRowConstraints().add(rowCon);
		}
		
		for(int i = 0; i < this.COL_CNT; i++) {
			ColumnConstraints colCon = new ColumnConstraints(10);
			if(i == 0)
				colCon = new ColumnConstraints(5);
			servantPane.getColumnConstraints().add(colCon);
			minionPane.getColumnConstraints().add(colCon);
		}
	}

	private void initComp(int players, int minions) {
		// Initialize counters
		this.totalPlayers = players;
		this.totalMinions = minions;
		this.selectedServants = 0;
		this.selectedMinions = 0;
		
		// Initialize scroll panes		
		servantScroll = new ScrollPane();
		servantScroll.setMinHeight(240);
		servantScroll.setMinWidth(610);
	
		minionScroll = new ScrollPane();		
		minionScroll.setMinHeight(240);
		minionScroll.setMinWidth(610);
		
		// Initialize button
		btnContinue = new Button("Continue");
		btnContinue.setMinHeight(51);
		btnContinue.setMinWidth(120);
		btnContinue.setDisable(true);
		
		// Initialize labels
		lblChooseServant = new Label("Choose " + (totalPlayers - totalMinions));
		lblChooseServant.setFont(Font.font("Garamond", 28));
		lblChooseMinion = new Label("Choose " + totalMinions);
		lblChooseMinion.setFont(Font.font("Garamond", FontWeight.SEMI_BOLD, 28));
		lblLeftServant = new Label();
		lblLeftServant.setFont(Font.font("Garamond", FontWeight.SEMI_BOLD, 28));
		lblLeftMinion = new Label();
		lblLeftMinion.setFont(Font.font("Garamond", FontWeight.SEMI_BOLD, 28));
		this.setLeftCount();
		
		// Initialize card containers
		servantHBox = new HBox(27);
		minionHBox = new HBox(27);
		
		// Initialize cards
		servantSelect = new ToggleButton[7];
		minionSelect = new ToggleButton[7];
				
		servantSelect[0] = new ToggleButton("", new ImageView(ImageSources.getImgServantMerlin()));
		servantSelect[1] = new ToggleButton("", new ImageView(ImageSources.getImgServantPercival()));
		servantSelect[2] = new ToggleButton("", new ImageView(ImageSources.getImgServantA()));
		servantSelect[3] = new ToggleButton("", new ImageView(ImageSources.getImgServantB()));
		servantSelect[4] = new ToggleButton("", new ImageView(ImageSources.getImgServantC()));
		servantSelect[5] = new ToggleButton("", new ImageView(ImageSources.getImgServantD()));
		servantSelect[6] = new ToggleButton("", new ImageView(ImageSources.getImgServantE()));
		
		minionSelect[0] = new ToggleButton("", new ImageView(ImageSources.getImgMinionAssassin()));
		minionSelect[1] = new ToggleButton("", new ImageView(ImageSources.getImgMinionMordred()));
		minionSelect[2] = new ToggleButton("", new ImageView(ImageSources.getImgMinionMorgana()));
		minionSelect[3] = new ToggleButton("", new ImageView(ImageSources.getImgMinionOberon()));
		minionSelect[4] = new ToggleButton("", new ImageView(ImageSources.getImgMinionA()));
		minionSelect[5] = new ToggleButton("", new ImageView(ImageSources.getImgMinionB()));
		minionSelect[6] = new ToggleButton("", new ImageView(ImageSources.getImgMinionC()));
	}
	
	private void addComp() {
		// Add cards to horizontal box
		for(int i = 0; i < servantSelect.length; i++) {
			servantHBox.getChildren().add(servantSelect[i]);
		}
		for(int i = 0; i < minionSelect.length; i++) {
			minionHBox.getChildren().add(minionSelect[i]);
		}
		
		// Add horizontal box to scroll pane
		servantScroll.setContent(servantHBox);
		minionScroll.setContent(minionHBox);
		
		// Add labels and scroll pane to secondary grid panes 
		servantPane.add(lblChooseServant, 2, 1, 20, 1);
		servantPane.add(lblLeftServant, 52, 1, 20, 1);
		servantPane.add(servantScroll, 1, 3);
		
		minionPane.add(lblChooseMinion, 2, 1, 20, 1);
		minionPane.add(lblLeftMinion, 52, 1, 20, 1);
		minionPane.add(minionScroll, 1, 3);		
			
		// Add secondary grid panes to main pane
		rolePane.add(servantPane, 1, 0);
		rolePane.add(minionPane, 1, 1);
		GridPane.setHalignment(btnContinue, HPos.RIGHT);
		rolePane.add(btnContinue, 1, 2);
	}
	
	private void initActions() {
		for(int i = 0; i < servantSelect.length; i++) {
			servantSelect[i].addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
				if(!((ToggleButton)(event.getSource())).isSelected() && selectedServants >= (totalPlayers - totalMinions))
					event.consume();
			});
			servantSelect[i].setOnMousePressed(e -> {
				ToggleButton b = (ToggleButton)(e.getSource());
				
				if(!b.isSelected()) {
					selectedServants++;
					System.out.println("add select servant");
					setLeftCount();
					btnContinue.setDisable(!(selectedMinions >= totalMinions && selectedServants >= (totalPlayers - totalMinions)));
				}
				else if(b.isSelected()) {
					selectedServants--;
					System.out.println("minus select servant");
					setLeftCount();
					btnContinue.setDisable(!(selectedMinions >= totalMinions && selectedServants >= (totalPlayers - totalMinions)));
				}
			});
		}
		for(int i = 0; i < minionSelect.length; i++) {
			minionSelect[i].addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
				if(!((ToggleButton)(event.getSource())).isSelected() && selectedMinions >= totalMinions)
					event.consume();
			});
			minionSelect[i].setOnMousePressed(e -> {
				ToggleButton b = (ToggleButton)(e.getSource());
				
				if(!b.isSelected()) {
					selectedMinions++;
					setLeftCount();
					btnContinue.setDisable(!(selectedMinions >= totalMinions && selectedServants >= (totalPlayers - totalMinions)));
				}
				else if(b.isSelected()) {
					selectedMinions--;
					setLeftCount();
					btnContinue.setDisable(!(selectedMinions >= totalMinions && selectedServants >= (totalPlayers - totalMinions)));
				}
			});
		}
		btnContinue.setOnAction(e -> {
			System.out.println("reveal included cards to players");
			
			sw.setIncludedCards(getSelectedCards());
			sw.setPhase(SceneWrapper.SET_PHASE_SHOW_ROLES);
		});
	}
	
	public CardType[] getSelectedCards() {
		CardType[] cards = new CardType[totalPlayers];
		int count = 0;
		
		for(int i = 0; i < servantSelect.length; i++) {
			if(servantSelect[i].isSelected()) {
				cards[count] = Good.values()[i];
				count++;
			}
		}
		for(int i = 0; i < minionSelect.length; i++) {
			if(minionSelect[i].isSelected()) {
				cards[count] = Bad.values()[i];
				count++;
			}
		}
		
		for(int i = 0; i < cards.length; i++) {
			System.out.println("INCLUDE: " + cards[i].toString());
		}
		
		return cards;
	}
	
	public void setLeftCount() {
		lblLeftServant.setText(((totalPlayers - totalMinions) - selectedServants) + " Left");
		lblLeftMinion.setText((totalMinions - selectedMinions) + " Left");
	}
	
	public void setBtnContinue() {
		btnContinue.setDisable(!(selectedMinions >= totalMinions && selectedServants >= (totalPlayers - totalMinions)));
	}
	
	public GridPane getPane() {
		return rolePane;
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

