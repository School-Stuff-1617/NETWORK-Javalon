package values;

import javafx.scene.image.Image;
import view.ImageSources;

public enum Good implements CardType {
	
	MERLIN("Merlin", ImageSources.getImgServantMerlin()), 
	PERCIVAL("Percival", ImageSources.getImgServantPercival()), 
	SERVANT_A("Servant A", ImageSources.getImgServantA()), 
	SERVANT_B("Servant B", ImageSources.getImgServantB()),  
	SERVANT_C("Servant C", ImageSources.getImgServantC()), 
	SERVANT_D("Servant D", ImageSources.getImgServantD()), 
	SERVANT_E("Servant E", ImageSources.getImgServantE());
	
	private final String name;
	private final Image card;
	
	private Good(String name, Image card) {
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
		case MERLIN:
			return "Merlin";
		case PERCIVAL:
			return "Percival";
		case SERVANT_A:
			return "Servant A";
		case SERVANT_B:
			return "Servant B";
		case SERVANT_C:
			return "Servant C";
		case SERVANT_D:
			return "Servant D";
		case SERVANT_E:
			return "Servant E";
		}
		return "";
	}
}
