package model;
import javafx.scene.image.Image;

public class Player {
	private int id;
	private String name;
	private boolean admin;
	private Image image;
	
	public Player(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.admin = false;
		image = null;
	}
	
	public Player(String name, Image image) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.admin = false;
		this.image = image;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isAdmin() {
		return admin;
	}
	
	public Image getImage() {
		return image;
	}
}
