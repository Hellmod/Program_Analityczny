package aplikacja;

import javax.swing.JOptionPane;

public class Start {

	static void alert(String tytul, String komunikat) {
		String msg = "<html><center><b><font color=red>" + komunikat + "</font></b></center></html>";
		JOptionPane.showMessageDialog(null, msg, tytul, JOptionPane.WARNING_MESSAGE, null);
	}

	public static void main(String[] args) {
		// new Okienko();
		new Logowanie();

		// BazaDanych baza= new BazaDanych();
		// new Wykres(baza);

	}

}
