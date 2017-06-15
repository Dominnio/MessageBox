package MessageBox;

public enum MessageBoxIcons {
	Information("infoIcon.png"), Warning("warningIcon.png"), Alert("alertIcon.png"), CriticalError("errorIcon.png");

	private String text;

	MessageBoxIcons(String msg) {
		text = msg;
	}

	@Override
	public String toString() {
		return text;
	}

}