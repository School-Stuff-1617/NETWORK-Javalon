package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneTitle implements EventHandler<Event>, SceneContainer {

	private Scene scene;
	private Button btnJoin;
	private Button btnCreate;
	
	// TEMP CONTROLLER
	private SceneWrapper sw;
	// private Controller c;

	public SceneTitle(SceneWrapper s) {
		this.initComp();
		this.setActions();
		this.sw = s;
	}

	private void initComp() {

		btnJoin = new Button();
		btnJoin.setText("Join game");
		btnJoin.setMinHeight(51);
		btnJoin.setMinWidth(194);

		btnCreate = new Button();
		btnCreate.setText("Create game");
		btnCreate.setMinHeight(51);
		btnCreate.setMinWidth(194);
	
		GridPane layout = new GridPane();
		layout.setHgap(90);
		layout.setVgap(35);
		// layout.setGridLinesVisible(true);
		
		BackgroundImage backImg = new BackgroundImage(ImageSources.getImgBGTitle(), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		
		layout.setBackground(new Background(backImg));
		layout.add(btnCreate, 6, 11, 3, 1);
		layout.add(btnJoin, 6, 12, 3, 1);

		scene = new Scene(layout, 900, 750);
		System.out.println("Initialized");
	}

	private void setActions() {
		btnJoin.setOnAction(e -> {
			String result = DialogBox.display("Title", "Enter your name.");
			// if(c.createPlayer(result))
			sw.setToLobby();
			//else {
				//DialogBox.display("", "Cannot add any more players to game.");
			//}
		});
	
	}
	public Scene getScene() {
		return scene;
	}

	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub

	}
}
