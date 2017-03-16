
public enum Bad implements CardType {
	MINION, MORDRED, MORGANA, OBERON, ASSASIN;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		switch (this) {
		case MINION:
			return "Minion";
		case MORDRED:
			return "Mordred";
		case MORGANA:
			return "Morgana";
		case OBERON:
			return "Oberon";
		case ASSASIN:
			return "Assasin";
		default:
			break;
		}
		return "";
	}
}
