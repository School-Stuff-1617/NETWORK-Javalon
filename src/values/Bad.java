package values;

import javafx.scene.image.Image;
import view.ImageSources;

public enum Bad implements CardType {
	ASSASSIN("Assassin", ImageSources.getImgMinionAssassin()),
	MORDRED("Mordred", ImageSources.getImgMinionMordred()), 
	MORGANA("Morgana", ImageSources.getImgMinionMorgana()), 
	OBERON("Oberon", ImageSources.getImgMinionOberon()),
	MINION_A("Minion A", ImageSources.getImgMinionC()),
	MINION_B("Minion B", ImageSources.getImgMinionC()),
	MINION_C("Minion C", ImageSources.getImgMinionC());
	
	private final String name;
	private final Image card;
	
	private Bad(String name, Image card) {
		this.name = name;
		this.card = card;
	}
	
	public String getName() {
		return name;
	}
	
	public Image getCard() {
		return card;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		switch (this) {
			case ASSASSIN:
				return "Assassin";
			case MORDRED:
				return "Mordred";
			case MORGANA:
				return "Morgana";
			case OBERON:
				return "Oberon";
			case MINION_A:
				return "Minion A";
			case MINION_B:
				return "Minion B";
			case MINION_C:
				return "Minion C";
			default:
				break;
		}
		return "";
	}
}
