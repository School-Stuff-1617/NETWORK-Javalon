package values;

public enum StatusStrings {
	READY, CHOOSING, WAITING, DEPLOYED;
	
	public String toString() {
		switch (this) {
		case READY:
			return "Ready!";
		case CHOOSING:
			return "Choosing...";
		case WAITING:
			return "Waiting...";
		case DEPLOYED:
			return "Deployed";
		default:
			return "";
		}
	}
}
