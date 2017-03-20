package view;
import javafx.stage.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class DialogBox {
	
	static String text;
	
	public static String display(String title, String message) {
		Stage window = new Stage();
		TextField tField = new TextField();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMaxWidth(500);
		window.initStyle(StageStyle.UNDECORATED);
		
		Label label = new Label();
		label.setText(message);
		
		tField.setMinWidth(200);
		
		Button enterButton = new Button("Enter");
		enterButton.setOnAction(e -> {
			text = tField.getText();
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().add(label);	
		layout.getChildren().add(tField);
		layout.getChildren().add(enterButton);	
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return text;
	}
}
