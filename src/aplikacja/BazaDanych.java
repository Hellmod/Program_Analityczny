package aplikacja;

import java.util.ArrayList;
import java.util.List;

import biblioteka.Biblioteka;
import model.Zagrozenie;

public class BazaDanych {
	ArrayList<Object[]> baza;
	Biblioteka biblioteka;
	List<Zagrozenie> rekordy;

	public BazaDanych() {
		biblioteka = new Biblioteka();
		odczytaj();
	}

	/**
	 * Odczytuje dane z bazy danych i przepisuje je do listy baza
	 */
	private void odczytaj() {
		rekordy = biblioteka.selectRekord();
		baza = new ArrayList<Object[]>();

		for (Zagrozenie c : rekordy) {
			baza.add(new Object[] { c.getId(), c.getNazwa(), c.getPrawdopodobienstow(), c.getZagrozenie(),
					c.getRyzyko(), c.getOpis() });
		}

//		for (int i = 0; i < baza.size(); i++) {
//			System.out.println(baza.get(i)[0]+" "+baza.get(i)[1]+" "+baza.get(i)[2]+" "+baza.get(i)[3]+" "+baza.get(i)[4]+" "+baza.get(i)[5]);
//		}
//		System.out.println("_________________");

	}

	/**
	 * Dodaje Rekord do bazy i wywo³uje funkcjê odczytaj
	 */
	void dodaj(String nazwa, int prawdopodobienstow, int zagrozenie, String opis) {
		if (nazwa.isEmpty())
			nazwa = " ";
		if (opis.isEmpty())
			opis = " ";

		biblioteka.insertZagrozenia(nazwa, prawdopodobienstow, zagrozenie, 0, opis);
		odczytaj();

	}

	/**
	 * Usuwa Rekord z bazy i wywo³uje funkcjê odczytaj
	 */
	void usun(int id) {
		biblioteka.DeleteZagrozenia(id);
		odczytaj();
	}

}
