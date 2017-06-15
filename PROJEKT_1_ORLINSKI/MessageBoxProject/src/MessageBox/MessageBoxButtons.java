package MessageBox;

public enum MessageBoxButtons {
	AbortRetryIgnore("Przerwij", "Ponów", "Ignoruj"), OK("OK"), OkCancel("OK", "Anuluj"), RetryCancel("Ponów",
			"Anuluj"), YesNo("Tak", "Nie"), YesNoCancel("Tak", "Nie", "Anuluj");

	private String[] text = new String[3];
	private int count;

	MessageBoxButtons(String... msg) {
		for (int i = 0; i < msg.length; ++i)
			text[i] = msg[i];
		count = msg.length;
	}

	@Override
	public String toString() {
		return text[0];
	}

	public String getText(int i) {
		return text[i];
	}

	public int getCount() {
		return count;
	}
}