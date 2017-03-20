package view;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class ProfileImage {
	
	private StackPane stack;
	
	private Label lblProfile;
	private Label lblFrame;
	private Label lblBG;
	
	// private Player player;
		
	//public ProfileImage(Player player) {
	public ProfileImage() {
		this.lblProfile = new Label("", new ImageView(ImageSources.getImgTestEnemySquare()));
		this.lblFrame = new Label("", new ImageView(ImageSources.getImgTestEnemyFrame()));
		this.lblBG = new Label("", new ImageView(ImageSources.getImgTestEnemyBG()));
		
		this.stack = new StackPane();
		this.stack.getChildren().addAll(lblBG, lblProfile, lblFrame);		
	}
	
	public ProfileImage(String s) {
		this.lblProfile = new Label("", new ImageView(ImageSources.getImgTestSquare()));
		this.lblFrame = new Label("", new ImageView(ImageSources.getImgTestPlayerFrame()));
		this.lblBG = new Label("", new ImageView(ImageSources.getImgTestPlayerBG()));
		
		this.stack = new StackPane();
		this.stack.getChildren().addAll(lblBG, lblProfile, lblFrame);	
	}
	
	public StackPane getProfileImage() {
		return stack;
	}
}
