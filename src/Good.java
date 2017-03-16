
public enum Good implements CardType {
	SERVANT, PERCIVAL, MERLIN;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		switch (this) {
		case SERVANT:
			return "Servant";
		case PERCIVAL:
			return "Percival";
		case MERLIN:
			return "Merlin";
		}
		return "";
	}
}
